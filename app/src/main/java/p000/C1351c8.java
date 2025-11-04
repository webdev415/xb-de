package p000;

import android.content.Context;
import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1351c8 implements InterfaceC1320bd, InterfaceC1366cd {

    public final InterfaceC2388tj f3925a;

    public final Context f3926b;

    public final InterfaceC2388tj f3927c;

    public final Set f3928d;

    public final Executor f3929e;

    public C1351c8(InterfaceC2388tj interfaceC2388tj, Set set, Executor executor, InterfaceC2388tj interfaceC2388tj2, Context context) {
        this.f3925a = interfaceC2388tj;
        this.f3928d = set;
        this.f3929e = executor;
        this.f3927c = interfaceC2388tj2;
        this.f3926b = context;
    }

    public static Component m5748f() {
        final C0167Dj c0167DjM715a = C0167Dj.m715a(InterfaceC1713f2.class, Executor.class);
        return Component.m1797f(C1351c8.class, InterfaceC1320bd.class, InterfaceC1366cd.class).m1813b(Dependency.m874i(Context.class)).m1813b(Dependency.m874i(C1364cb.class)).m1813b(Dependency.m876k(InterfaceC1171Zc.class)).m1813b(Dependency.m875j(InterfaceC2347so.class)).m1813b(Dependency.m873h(c0167DjM715a)).m1816e(new InterfaceC0604N5() {
            @Override
            public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                return C1351c8.m5749g(c0167DjM715a, interfaceC0466K5);
            }
        }).m1814c();
    }

    public static C1351c8 m5749g(C0167Dj c0167Dj, InterfaceC0466K5 interfaceC0466K5) {
        return new C1351c8((Context) interfaceC0466K5.mo2282a(Context.class), ((C1364cb) interfaceC0466K5.mo2282a(C1364cb.class)).m5875n(), interfaceC0466K5.m2286e(InterfaceC1171Zc.class), interfaceC0466K5.mo2284c(InterfaceC2347so.class), (Executor) interfaceC0466K5.mo2288g(c0167Dj));
    }

    public static C1921jd m5750i(Context context, String str) {
        return new C1921jd(context, str);
    }

    @Override
    public AbstractC1838hn mo5660a() {
        return AbstractC2485vo.m10404a(this.f3926b) ^ true ? AbstractC2346sn.m9593d("") : AbstractC2346sn.m9592c(this.f3929e, new Callable() {
            @Override
            public final Object call() {
                return this.f3493a.m5751h();
            }
        });
    }

    public final String m5751h() {
        String string;
        synchronized (this) {
            try {
                C1921jd c1921jd = (C1921jd) this.f3925a.get();
                List listM8162c = c1921jd.m8162c();
                c1921jd.m8161b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < listM8162c.size(); i++) {
                    AbstractC1967kd abstractC1967kd = (AbstractC1967kd) listM8162c.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", abstractC1967kd.mo3750c());
                    jSONObject.put("dates", new JSONArray((Collection) abstractC1967kd.mo3749b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public final Void m5752j() {
        synchronized (this) {
            ((C1921jd) this.f3925a.get()).m8166g(System.currentTimeMillis(), ((InterfaceC2347so) this.f3927c.get()).mo7876a());
        }
        return null;
    }

    public AbstractC1838hn m5753k() {
        return this.f3928d.size() <= 0 ? AbstractC2346sn.m9593d(null) : AbstractC2485vo.m10404a(this.f3926b) ^ true ? AbstractC2346sn.m9593d(null) : AbstractC2346sn.m9592c(this.f3929e, new Callable() {
            @Override
            public final Object call() {
                return this.f3853a.m5752j();
            }
        });
    }

    public C1351c8(final Context context, final String str, Set set, InterfaceC2388tj interfaceC2388tj, Executor executor) {
        this(new InterfaceC2388tj() {
            @Override
            public final Object get() {
                return C1351c8.m5750i(context, str);
            }
        }, set, executor, interfaceC2388tj, context);
    }
}
