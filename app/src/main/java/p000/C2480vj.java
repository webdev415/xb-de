package p000;

import android.content.Context;
import android.content.Intent;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.BindException;
import java.net.ConnectException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class C2480vj implements AbstractC2434uj.a {

    public static C2480vj instance;

    public Context context = null;

    public InterfaceC0353Hl f7729b = null;

    public UserResourceManager f7730c = null;

    public final ArrayList f7731d = new ArrayList<>();

    public boolean f7732e = false;

    public final boolean f7733f = false;

    public Proxy proxy = null;

    public int f7735h = 0;

    public String f7736i = null;

    public int triesAvailable = 3;

    public int f7738k = 1;

    public static C2480vj getInstance() {
        if (instance == null) {
            instance = new C2480vj();
        }
        return instance;
    }

    @Override
    public void mo8178b(byte[] bArr, int i) {
        f7730c.addUploadFlow(i);
    }

    @Override
    public void mo8469e(byte[] bArr, int i) {
        f7730c.addDownloadFlow(i);
        f7730c.consumeLeftFlow(i);
    }

    @Override
    public void mo10181g(Exception exc) {
        System.out.println("xproxy receive eror:" + exc.toString() + " proxy:" + proxy.proxyHost + ":" + proxy.getProxyPort());
        if (f7729b != null && f7729b.mo1597b() == -1 && BrowserActivity.getActivity() != null) {
            BrowserActivity.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "tunnel init error", Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (exc instanceof BindException) {
            if (triesAvailable > 0) {
                proxy.localPort++;
                m10376k();
                triesAvailable--;
            }
        } else if (exc instanceof ConnectException) {
            BrowserActivity.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String msg = exc.getMessage();
                    if (msg != null) {
                        if (f7735h == 2) {
                            if (msg.indexOf("ENETUNREACH") > 0) {
                                proxy.h = -1;
                                m10377l();
                            } else if (msg.indexOf("ECONNREFUSED") > 0) {
                                BrowserActivity.getActivity().getHandler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        m10377l();
                                        proxy.h = -1;
                                    }
                                }, 200L);
                            }
                        }
                        if (msg.indexOf("ENETUNREACH") > 0) {
                            m10384t();
                        }
                    }
                }
            });
        }
        exc.printStackTrace();
        if (f7735h == 2) {
            proxy.h = -1;
        }
    }

    public void m10375j(boolean z) throws SecurityException, IllegalArgumentException {
        m10376k();
        if (!z) {
            setWebViewSocksProxy(null, 0);
        } else {
            setWebViewSocksProxy("127.0.0.1", proxy.localPort);
            Log.i("xproxy", "use proxy in this request .....");
        }
    }

    public void m10376k() {
        if (f7729b == null || f7729b.mo1597b() == -1) {
            f7729b = C0445Jl.m2065b().m2067c(proxy);
            C2525wi.m10587c().m10591e(PhoneUtils.getInstance().getAppSignatureMd5());
            C2525wi.m10587c().m10592f(PhoneUtils.getInstance().getVersionCode());
            InterfaceC0353Hl interfaceC0353Hl2 = f7729b;
            if (interfaceC0353Hl2 instanceof C1375cm) {
                ((C1375cm) interfaceC0353Hl2).m5939g(this);
            }
            f7729b.start();
        }
    }

    public void m10377l() {
        m10375j(false);
        f7735h = 0;
    }

    public boolean m10378n() {
        return f7735h == 2;
    }

    public void m10379o(Context context) {
        this.context = context;
        f7738k = SharedPreferencesHelper.getInstance().getString("xproxy_node_select_strategy", "best").equals("rand") ? 0 : 1;
        f7730c = C2439uo.getInstance().getUser();
        if (proxy == null) {
            proxy = m10380p("default-proxy", "t.xbext.com", 9998);
            proxy.country = "us";
        }
    }

    public final Proxy m10380p(String str, String str2, int i) {
        Proxy proxy = new Proxy();
        proxy.configId = str;
        proxy.localIP = "127.0.0.1";
        proxy.localPort = 8989;
        proxy.proxyHost = str2;
        proxy.basePort = i;
        proxy.serverType = 1;
        return proxy;
    }

    public final void setWebViewSocksProxy(String proxyHost, int proxyPort) {
        // Set or clear the system properties for SOCKS proxy
        System.setProperty("socksProxyHost", proxyHost != null ? proxyHost : "");
        System.setProperty("socksProxyPort", proxyHost != null ? String.valueOf(proxyPort) : "");

        Log.i("xproxy", ">>>>>> change WebView proxy to " + proxyHost + ":" + proxyPort);

        // Notify all ProxyChangeListener instances in the app
        notifyProxyChangeListeners();
    }

    @SuppressWarnings({"rawtypes"})
    private void notifyProxyChangeListeners() {
        try {
            // Access android.app.Application.mLoadedApk
            Field loadedApkField = Class.forName("android.app.Application").getDeclaredField("mLoadedApk");
            loadedApkField.setAccessible(true);
            Object loadedApk = loadedApkField.get(context);

            // Access android.app.LoadedApk.mReceivers
            Field receiversField = Class.forName("android.app.LoadedApk").getDeclaredField("mReceivers");
            receiversField.setAccessible(true);
            ArrayMap receiversMap = (ArrayMap) receiversField.get(loadedApk);

            // Iterate over all receiver collections
            if (receiversMap != null) {
                for (Object collectionObj : receiversMap.values()) {
                    if (!(collectionObj instanceof ArrayMap)) continue;
                    ArrayMap receiverCollection = (ArrayMap) collectionObj;

                    for (Object receiver : receiverCollection.keySet()) {
                        if (receiver == null) continue;
                        Class<?> receiverClass = receiver.getClass();

                        // Notify only ProxyChangeListener instances
                        if (receiverClass.getName().contains("ProxyChangeListener")) {
                            receiverClass.getDeclaredMethod("onReceive", Context.class, Intent.class)
                                    .invoke(receiver, context, new Intent("android.intent.action.PROXY_CHANGE"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void m10382r(Proxy proxy) {
        m10385u(proxy);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("proxy_host", proxy.proxyHost);
            jsonObject.put("proxy_port", proxy.getProxyPort());
            jsonObject.put("base_port", proxy.basePort);
            jsonObject.put("config_id", proxy.configId);
            jsonObject.put("country", proxy.country);
            jsonObject.put("server_type", proxy.serverType);
            jsonObject.put("local_port", proxy.localPort);
            SharedPreferencesHelper.getInstance().putString("xproxy_current_config", jsonObject.toString());
            if (f7729b != null) {
                Log.i("xproxy", "Switch proxy to " + proxy.proxyHost + ":" + proxy.getProxyPort());
                f7729b.onSwichProxyTo(proxy.proxyHost, proxy.getProxyPort());
                f7735h = 2;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void m10383s() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m10376k();
        if (proxy == null) {
            proxy = m10380p("google-trans-proxy", "t.xbext.com", 9998);
        }
        C0445Jl.m2065b().m2069e(proxy);
        m10386v(proxy);
        f7735h = 2;
    }

    public final void m10385u(Proxy proxy) {
        this.proxy = proxy;
    }

    public void m10386v(Proxy proxy) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m10382r(proxy);
        m10375j(true);
    }

    @Override
    public void mo8468a() {
    }

    @Override
    public void mo8179c() {
    }

    @Override
    public void mo8180d() {
    }

    @Override
    public void mo8470f() {
    }

    public final void m10384t() {
    }
}
