package p000;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;

/* loaded from: classes.dex */
public abstract class AbstractC0532Lg {

    public static final b f1715a = new b(null);

    public static final class a extends AbstractC0532Lg {

        public final MeasurementManager f1716b;

        public a(MeasurementManager measurementManager) {
            AbstractC0116Ce.m476e(measurementManager, "mMeasurementManager");
            this.f1716b = measurementManager;
        }

        @Override
        public Object mo2684a(AbstractC0101C8 abstractC0101C8, InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.deleteRegistrations(m2694k(abstractC0101C8), new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s == AbstractC0208Ee.m1037c() ? objM5723s : C2116no.f6480a;
        }

        @Override
        public Object mo2685b(InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.getMeasurementApiStatus(new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s;
        }

        @Override
        public Object mo2686c(Uri uri, InputEvent inputEvent, InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.registerSource(uri, inputEvent, new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s == AbstractC0208Ee.m1037c() ? objM5723s : C2116no.f6480a;
        }

        @Override
        public Object mo2687d(Uri uri, InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.registerTrigger(uri, new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s == AbstractC0208Ee.m1037c() ? objM5723s : C2116no.f6480a;
        }

        @Override
        public Object mo2688e(AbstractC0770Qo abstractC0770Qo, InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.registerWebSource(m2695l(abstractC0770Qo), new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s == AbstractC0208Ee.m1037c() ? objM5723s : C2116no.f6480a;
        }

        @Override
        public Object mo2689f(AbstractC0815Ro abstractC0815Ro, InterfaceC2458v6 interfaceC2458v6) throws Throwable {
            C1347c4 c1347c4 = new C1347c4(AbstractC0162De.m705b(interfaceC2458v6), 1);
            c1347c4.m5726v();
            this.f1716b.registerWebTrigger(m2696m(abstractC0815Ro), new ExecutorC0486Kg(), AbstractC1880ii.m7966a(c1347c4));
            Object objM5723s = c1347c4.m5723s();
            if (objM5723s == AbstractC0208Ee.m1037c()) {
                AbstractC2459v7.m10326c(interfaceC2458v6);
            }
            return objM5723s == AbstractC0208Ee.m1037c() ? objM5723s : C2116no.f6480a;
        }

        public final DeletionRequest m2694k(AbstractC0101C8 abstractC0101C8) {
            AbstractC0394Ig.m1702a();
            throw null;
        }

        public final WebSourceRegistrationRequest m2695l(AbstractC0770Qo abstractC0770Qo) {
            AbstractC0440Jg.m1974a();
            throw null;
        }

        public final WebTriggerRegistrationRequest m2696m(AbstractC0815Ro abstractC0815Ro) {
            AbstractC0026Ag.m134a();
            throw null;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Context context) {
            AbstractC0116Ce.m476e(context, "context");
            Object systemService = context.getSystemService((Class<Object>) AbstractC0164Dg.m708a());
            AbstractC0116Ce.m475d(systemService, "context.getSystemService…:class.java\n            )");
            this(AbstractC0210Eg.m1039a(systemService));
        }
    }

    public static final class b {
        public b() {
        }

        public final AbstractC0532Lg m2697a(Context context) {
            AbstractC0116Ce.m476e(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            C2314s0 c2314s0 = C2314s0.f6991a;
            sb.append(c2314s0.m9459a());
            Log.d("MeasurementManager", sb.toString());
            if (c2314s0.m9459a() >= 5) {
                return new a(context);
            }
            return null;
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public abstract Object mo2684a(AbstractC0101C8 abstractC0101C8, InterfaceC2458v6 interfaceC2458v6);

    public abstract Object mo2685b(InterfaceC2458v6 interfaceC2458v6);

    public abstract Object mo2686c(Uri uri, InputEvent inputEvent, InterfaceC2458v6 interfaceC2458v6);

    public abstract Object mo2687d(Uri uri, InterfaceC2458v6 interfaceC2458v6);

    public abstract Object mo2688e(AbstractC0770Qo abstractC0770Qo, InterfaceC2458v6 interfaceC2458v6);

    public abstract Object mo2689f(AbstractC0815Ro abstractC0815Ro, InterfaceC2458v6 interfaceC2458v6);
}
