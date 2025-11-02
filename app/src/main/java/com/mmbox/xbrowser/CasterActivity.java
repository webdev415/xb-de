package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.xbrowser.play.R;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import p000.DlnaCaster;

public class CasterActivity extends Activity {

    private WifiManager.MulticastLock multicastLock;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> deviceList;
    private HashMap<String, String> deviceMap;
    private DlnaCaster dlnaCaster;
    private TextView tvDialogTitle;
    private ImageButton btnRescan;
    private ProgressBar scanProgress;
    private String mediaUrl;
    private boolean isDeviceDiscovered = false;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaUrl = getIntent().getStringExtra("media_url");
        setContentView(R.layout.activity_caster);

        initViews();
        setupWifiMulticastLock();
        initDlnaCaster();
        startDeviceDiscovery();
    }

    private void initViews() {
        listView = findViewById(R.id.device_list_view);
        deviceList = new ArrayList<>();
        deviceMap = new HashMap<>();
        adapter = new ArrayAdapter<>(this, R.layout.device_list_item, R.id.device_name, deviceList);
        listView.setAdapter((ListAdapter) adapter);

        tvDialogTitle = findViewById(R.id.dialog_title);
        btnRescan = findViewById(R.id.btn_rescan);
        scanProgress = findViewById(R.id.scan_progress);

        tvDialogTitle.setText(R.string.select_target_casting_device);

        btnRescan.setOnClickListener(v -> {
            Log.d("DlnaCaster", "Rescan button clicked");
            tvDialogTitle.setText(R.string.scanning_casting_device);
            btnRescan.setVisibility(View.GONE);
            scanProgress.setVisibility(View.VISIBLE);
            startDeviceDiscovery();
        });

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            String deviceName = deviceList.get(position);
            String deviceUrl = deviceMap.get(deviceName);
            if (dlnaCaster != null && deviceUrl != null) {
                castMediaToDevice(deviceName, deviceUrl);
            } else {
                Toast.makeText(this, "Cannot cast: Caster or device URL missing.", Toast.LENGTH_SHORT).show();
                Log.w("DlnaCaster", "Caster or locationUrl is null. Cannot cast.");
            }
        });
    }

    private void setupWifiMulticastLock() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            multicastLock = wifiManager.createMulticastLock("dlna-lock");
            multicastLock.setReferenceCounted(true);
            multicastLock.acquire();
        } else {
            Log.e("DlnaCaster", "WifiManager is null, cannot acquire multicast lock.");
        }
    }

    private void initDlnaCaster() {
        try {
            dlnaCaster = new DlnaCaster();
            tvDialogTitle.setText(R.string.scanning_casting_device);
            btnRescan.setVisibility(View.GONE);
            scanProgress.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Log.e("DlnaCaster", "Error initializing DlnaCaster", e);
            tvDialogTitle.setText(R.string.select_target_casting_device);
            btnRescan.setVisibility(View.VISIBLE);
            scanProgress.setVisibility(View.GONE);
        }
    }

    private void castMediaToDevice(String deviceName, String deviceUrl) {
        new Thread(() -> {
            try (InputStream inputStream = new URL(deviceUrl).openStream()) {
                String controlUrl = dlnaCaster.resolveControlURL(inputStream, deviceUrl);
                if (controlUrl != null) {
                    dlnaCaster.playMedia(controlUrl, mediaUrl);
                    runOnUiThread(() -> Toast.makeText(this,
                            getString(R.string.casting_connection_established) + " " + deviceName,
                            Toast.LENGTH_SHORT).show());
                    Log.i("DlnaCaster", "Play command sent to " + deviceName + " for media: " + mediaUrl);
                } else {
                    runOnUiThread(() -> Toast.makeText(this,
                            "Failed to get control URL for " + deviceName, Toast.LENGTH_LONG).show());
                    Log.e("DlnaCaster", "Failed to parse control URL for " + deviceName);
                }
            } catch (Exception e) {
                Log.e("DlnaCaster", "Error during casting process for " + deviceName, e);
                runOnUiThread(() -> Toast.makeText(this,
                        "Error casting to " + deviceName, Toast.LENGTH_LONG).show());
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (multicastLock != null && multicastLock.isHeld()) {
            multicastLock.release();
        }
    }

    private void startDeviceDiscovery() {
        try {
            isDeviceDiscovered = false;

            // Clear previous devices
            if (!deviceList.isEmpty()) {
                deviceList.clear();
                deviceMap.clear();
                adapter.notifyDataSetChanged();
            }

            handler.removeCallbacksAndMessages(null);

            // Delay UI update for scanning result
            handler.postDelayed(() -> {
                if (tvDialogTitle == null || btnRescan == null || scanProgress == null) return;

                tvDialogTitle.setText(R.string.select_target_casting_device);
                btnRescan.setVisibility(View.VISIBLE);
                scanProgress.setVisibility(View.GONE);

                if (!isDeviceDiscovered && deviceList.isEmpty()) {
                    Toast.makeText(this, R.string.toast_no_devices_message, Toast.LENGTH_LONG).show();
                    tvDialogTitle.setText(R.string.no_casting_devices_found);
                }
            }, 3000L);

            Log.d("DlnaCaster", "Starting device discovery...");

            dlnaCaster.discoverDevices((name, url) -> {
                Log.i("DlnaCaster", "Device found on discovery thread: " + name + ", Location: " + url);
                isDeviceDiscovered = true;

                runOnUiThread(() -> {
                    if (!deviceList.contains(name)) {
                        deviceList.add(name);
                        deviceMap.put(name, url);
                        adapter.notifyDataSetChanged();
                        Log.d("DlnaCaster", "Device added to list: " + name);
                    } else {
                        Log.d("DlnaCaster", "Device already in list: " + name);
                    }
                });
            }, 0);

        } catch (Exception e) {
            Log.e("DlnaCaster", "Error during device discovery", e);
            if (tvDialogTitle != null && btnRescan != null && scanProgress != null) {
                tvDialogTitle.setText(R.string.no_casting_devices_found);
                btnRescan.setVisibility(View.VISIBLE);
                scanProgress.setVisibility(View.GONE);
            }
            runOnUiThread(() -> Toast.makeText(this, "扫描设备时出错", Toast.LENGTH_SHORT).show());
        }
    }
}
