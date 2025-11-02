package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.xbrowser.play.R;

import java.util.Arrays;

public class QrScanActivity extends Activity {

    private static final int REQUEST_CODE_PICK_IMAGE = 201;
    public CaptureManager capture;

    public DecoratedBarcodeView barcodeScannerView;

    /**
     * Launches the image picker to select an image from the gallery.
     *
     * @param view The view that triggered this action (can be used for context if needed)
     */
    public final void openGallery(View view) {
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImageIntent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            handlePickedImage(data.getData());
        }
    }

    /**
     * Decodes the selected image and returns the result
     */
    private void handlePickedImage(Uri imageUri) {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));

            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

            RGBLuminanceSource source = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), pixels);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

            QRCodeReader decoder = new QRCodeReader();
            String result = decoder.decode(binaryBitmap).getText();

            if (result == null) {
                result = getString(R.string.toast_unrecognised_qrcode);
            }

            setResult(RESULT_OK, new Intent().putExtra("SCAN_RESULT", result));
        } catch (Exception e) {
            e.printStackTrace();
            setResult(RESULT_OK, new Intent().putExtra("SCAN_RESULT", getString(R.string.toast_unrecognised_qrcode)));
        } finally {
            finish();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscan);
        this.barcodeScannerView = (DecoratedBarcodeView) findViewById(R.id.zxing_barcode_view);
        this.barcodeScannerView.getBarcodeView().setDecoderFactory(
                new DefaultDecoderFactory(Arrays.asList(
                        BarcodeFormat.QR_CODE,
                        BarcodeFormat.CODE_39,
                        BarcodeFormat.CODE_128,
                        BarcodeFormat.EAN_13,
                        BarcodeFormat.EAN_8,
                        BarcodeFormat.UPC_A,
                        BarcodeFormat.UPC_E,
                        BarcodeFormat.AZTEC,
                        BarcodeFormat.CODABAR,
                        BarcodeFormat.UPC_A,
                        BarcodeFormat.DATA_MATRIX,
                        BarcodeFormat.ITF,
                        BarcodeFormat.PDF_417,
                        BarcodeFormat.RSS_14,
                        BarcodeFormat.RSS_EXPANDED,
                        BarcodeFormat.MAXICODE,
                        BarcodeFormat.UPC_EAN_EXTENSION)));
        ((TextView) findViewById(R.id.scan_from_image)).setOnClickListener(this::openGallery);
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        capture.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
