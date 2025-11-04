package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class AbstractC2274r6 {

    public FrameLayout f6877d;

    public Context f6878e;

    public final File f6879f;

    public final ArrayList f6874a = new ArrayList<>(3);

    public final Handler f6875b = new Handler(Looper.getMainLooper());

    public int f6876c = -1;

    public final boolean f6880g = true;

    public volatile boolean f6881h = false;

    public SharedPreferences f6882i = null;

    public c f6883j = null;

    public class a implements Runnable {

        public final ArrayList f6884l;

        public final Runnable f6885m;

        public a(ArrayList arrayList, Runnable runnable) {
            this.f6884l = arrayList;
            this.f6885m = runnable;
        }

        @Override
        public void run() {
            int iMin = Math.min(3, this.f6884l.size());
            for (int i = 0; i < iMin; i++) {
                d dVar = (d) this.f6884l.remove(0);
                try {
                    InterfaceC0345Hd interfaceC0345HdM9333l = dVar.m9333l();
                    if (interfaceC0345HdM9333l != null) {
                        f6877d.removeView(interfaceC0345HdM9333l.mo1695d());
                        interfaceC0345HdM9333l.mo1576g();
                    }
                    dVar.m9331j();
                    f6874a.remove(dVar);
                } catch (Throwable th) {
                    Log.w("ContentViewManager", "destroy tab failed: " + th);
                }
            }
            if (!this.f6884l.isEmpty()) {
                f6875b.post(this);
                return;
            }
            if (f6874a.isEmpty()) {
                f6876c = -1;
            } else {
                if (f6876c < 0 || f6876c >= f6874a.size()) {
                    f6876c = 0;
                }
                AbstractC2274r6 abstractC2274r6 = AbstractC2274r6.this;
                abstractC2274r6.m9298V(abstractC2274r6.f6876c);
            }
            f6881h = false;
            Runnable runnable = this.f6885m;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public class b implements Comparator {
        public b() {
        }

        @Override
        public int compare(d dVar, d dVar2) {
            return dVar.f6892e - dVar2.f6892e;
        }
    }

    public interface c {
        void mo6289a(InterfaceC0345Hd interfaceC0345Hd);

        void mo6294b();

        void mo6299c(InterfaceC0345Hd interfaceC0345Hd);

        void mo6304d();
    }

    public class d {

        public String f6888a = null;

        public boolean lock = false;

        public String f6890c = "";

        public int index = -1;

        public int f6892e = -1;

        public String f6894g = "";

        public String f6895h = "";

        public boolean f6896i = false;

        public ArrayList f6893f = new ArrayList<>();

        public d(String str) {
            this.f6888a = str;
            if (TextUtils.isEmpty(str)) {
                this.f6888a = System.currentTimeMillis() + "";
            }
        }

        public void m9322A(C1697en c1697en) {
            AbstractC2274r6 abstractC2274r6 = AbstractC2274r6.this;
            InterfaceC0345Hd interfaceC0345HdMo5705r = abstractC2274r6.mo5705r(abstractC2274r6.f6878e.getPackageName(), WebViewBrowserController.class.getName());
            if (interfaceC0345HdMo5705r instanceof WebViewBrowserController) {
                ((WebViewBrowserController) interfaceC0345HdMo5705r).m6792b1(this.f6888a, c1697en.f5460a, c1697en.f5461b);
                this.f6893f.add(interfaceC0345HdMo5705r);
                this.index = 0;
            }
        }

        public void m9323B(String str, SharedPreferences.Editor editor) throws Resources.NotFoundException {
            InterfaceC0345Hd interfaceC0345HdM9333l = m9333l();
            if (interfaceC0345HdM9333l instanceof WebViewBrowserController) {
                WebViewBrowserController webViewBrowserController = (WebViewBrowserController) interfaceC0345HdM9333l;
                this.f6894g = webViewBrowserController.mo1574c();
                this.f6895h = webViewBrowserController.mo1573b();
            }
            if (this.f6893f.isEmpty() && this.f6896i) {
                editor.putBoolean(str + ".lock", this.lock);
                return;
            }
            int size = this.f6893f.size();
            editor.putInt(str + ".size", size);
            editor.putInt(str + ".index", this.index);
            editor.putBoolean(str + ".lock", this.lock);
            for (int i = 0; i < size; i++) {
                InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(i);
                String str2 = str + ".v_" + i;
                interfaceC0345Hd.mo1585v(str2, editor);
                editor.putString(str2 + ".c" + i, interfaceC0345Hd.getClass().getName());
                editor.putString(str2 + ".pkg", interfaceC0345Hd.getPackageName());
                if (interfaceC0345Hd instanceof WebViewBrowserController) {
                    WebViewBrowserController webViewBrowserController2 = (WebViewBrowserController) interfaceC0345Hd;
                    String lastTitle = webViewBrowserController2.mo1574c();
                    String lastUrl = webViewBrowserController2.mo1573b();
                    if (lastTitle == null || lastTitle.length() == 0) {
                        lastTitle = lastUrl;
                    }
                    editor.putString(str2 + ".last_title", lastTitle);
                    editor.putString(str2 + ".last_url", lastUrl);
                }
            }
        }

        public void m9324C(boolean z) {
            this.lock = z;
        }

        public void m9325d(InterfaceC0345Hd interfaceC0345Hd) {
            m9327f(interfaceC0345Hd, true);
        }

        public void m9326e(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
            if (z) {
                m9331j();
            }
            m9325d(interfaceC0345Hd);
        }

        public void m9327f(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
            Log.i("tab", ">>>>>  add new tab:" + z);
            int iIndexOf = this.f6893f.indexOf(interfaceC0345Hd);
            int i = this.index;
            InterfaceC0345Hd interfaceC0345Hd2 = (i < 0 || i >= this.f6893f.size()) ? null : (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (iIndexOf < 0) {
                m9330i(this.index + 1);
                int size = this.f6893f.size();
                int i2 = this.index;
                if (i2 != size) {
                    for (int i3 = size - 1; i3 >= i2; i3--) {
                        InterfaceC0345Hd interfaceC0345Hd3 = (InterfaceC0345Hd) this.f6893f.remove(i3);
                        if (f6883j != null) {
                            f6883j.mo6299c(interfaceC0345Hd3);
                        }
                        interfaceC0345Hd3.mo1577k();
                    }
                }
                this.f6893f.add(interfaceC0345Hd);
            } else {
                InterfaceC0345Hd interfaceC0345Hd4 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                if (interfaceC0345Hd4 != null) {
                    interfaceC0345Hd4.mo1576g();
                }
                m9330i(iIndexOf);
            }
            if (z) {
                if (interfaceC0345Hd2 != null) {
                    interfaceC0345Hd2.mo1576g();
                }
                m9301Y(interfaceC0345Hd);
            }
        }

        public boolean m9328g() {
            int i = this.index;
            if (i < 0) {
                return false;
            }
            return ((InterfaceC0345Hd) this.f6893f.get(i)).mo1575e() || this.index < this.f6893f.size() - 1;
        }

        public boolean m9329h() {
            int i = this.index;
            if (i < 0) {
                return false;
            }
            return ((InterfaceC0345Hd) this.f6893f.get(i)).mo1586x() || this.index > 0;
        }

        public final void m9330i(int i) {
            this.index = i;
        }

        public void m9331j() {
            for (int i = 0; i < this.f6893f.size(); i++) {
                InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(i);
                f6877d.removeView(interfaceC0345Hd.mo1695d());
                if (f6883j != null) {
                    f6883j.mo6299c(interfaceC0345Hd);
                }
                interfaceC0345Hd.mo1577k();
            }
            this.f6893f.clear();
            this.index = -1;
        }

        public InterfaceC0345Hd m9332k(int i) {
            return (InterfaceC0345Hd) this.f6893f.get(i);
        }

        public InterfaceC0345Hd m9333l() {
            int i = this.index;
            if (i < 0 || i >= this.f6893f.size()) {
                return null;
            }
            return (InterfaceC0345Hd) this.f6893f.get(this.index);
        }

        public ArrayList m9334m() {
            ArrayList arrayList = new ArrayList<>();
            if (this.index < 0) {
                return arrayList;
            }
            for (int i = 0; i < this.f6893f.size(); i++) {
                arrayList.add((InterfaceC0345Hd) this.f6893f.get(i));
            }
            return arrayList;
        }

        public ArrayList m9335n() {
            return this.f6893f;
        }

        public int m9336o() {
            return this.index;
        }

        public String m9337p() {
            return this.f6894g;
        }

        public String m9338q() {
            return this.f6895h;
        }

        public String m9339r() {
            String str = this.f6888a;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("tab id not be set yet");
        }

        public void m9340s() {
            InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (interfaceC0345Hd.mo1586x()) {
                interfaceC0345Hd.mo1580n();
            } else if (m9329h()) {
                m9330i(this.index - 1);
                InterfaceC0345Hd interfaceC0345Hd2 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                interfaceC0345Hd.mo1576g();
                m9301Y(interfaceC0345Hd2);
            }
            if (f6883j != null) {
                f6883j.mo6294b();
            }
        }

        public void m9341t() {
            InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (interfaceC0345Hd.mo1575e()) {
                interfaceC0345Hd.mo1578l();
            } else if (m9328g()) {
                m9330i(this.index + 1);
                InterfaceC0345Hd interfaceC0345Hd2 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                interfaceC0345Hd.mo1576g();
                m9301Y(interfaceC0345Hd2);
            }
            if (f6883j != null) {
                f6883j.mo6304d();
            }
        }

        public boolean m9342u(InterfaceC0345Hd interfaceC0345Hd) {
            return this.f6893f.contains(interfaceC0345Hd);
        }

        public void m9343v() {
            if (this.f6896i) {
                this.f6896i = false;
                m9347z(this.f6888a, f6882i);
            }
        }

        public boolean m9344w() {
            return this.f6896i;
        }

        public boolean m9345x() {
            return this.lock;
        }

        public void m9346y(String str, SharedPreferences sharedPreferences) {
            this.f6896i = true;
            f6882i = sharedPreferences;
            int i = sharedPreferences.getInt(str + ".size", 0);
            int i2 = sharedPreferences.getInt(str + ".index", 0);
            this.lock = sharedPreferences.getBoolean(str + ".lock", false);
            int iMax = i > 0 ? (i2 < 0 || i2 >= i) ? Math.max(0, Math.min(i2, i - 1)) : i2 : 0;
            String str2 = str + ".v_" + iMax;
            this.f6894g = sharedPreferences.getString(str2 + ".last_title", "");
            this.f6895h = sharedPreferences.getString(str2 + ".last_url", "");
            this.index = iMax;
        }

        public boolean m9347z(String str, SharedPreferences sharedPreferences) {
            try {
                try {
                    int i = sharedPreferences.getInt(str + ".size", 0);
                    this.index = sharedPreferences.getInt(str + ".index", 0);
                    this.lock = sharedPreferences.getBoolean(str + ".lock", false);
                    String packageName = f6878e.getPackageName();
                    for (int i2 = 0; i2 < i; i2++) {
                        String str2 = str + ".v_" + i2;
                        String string = sharedPreferences.getString(str2 + ".c" + i2, "");
                        if (string.equals(WebViewBrowserController.class.getName())) {
                            InterfaceC0345Hd interfaceC0345HdMo5705r = mo5705r(packageName, string);
                            if (interfaceC0345HdMo5705r.mo1582r(str2, sharedPreferences)) {
                                this.f6893f.add(interfaceC0345HdMo5705r);
                            }
                        }
                    }
                    if (this.f6893f.size() != 0) {
                        if (this.index >= this.f6893f.size() - 1) {
                            this.index = this.f6893f.size() - 1;
                        }
                        return true;
                    }
                    this.index = -1;
                    if (-1 >= this.f6893f.size() - 1) {
                        this.index = this.f6893f.size() - 1;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.index < this.f6893f.size() - 1) {
                        return false;
                    }
                    this.index = this.f6893f.size() - 1;
                    return false;
                }
            } catch (Throwable th) {
                if (this.index >= this.f6893f.size() - 1) {
                    this.index = this.f6893f.size() - 1;
                }
                throw th;
            }
        }
    }

    public AbstractC2274r6(Context context, FrameLayout frameLayout) {
        this.f6877d = null;
        this.f6878e = null;
        this.f6877d = frameLayout;
        this.f6878e = context;
        this.f6879f = context.getDir("thumbnails", 0);
    }

    public d m9277A() {
        if (this.f6876c == -1 || this.f6874a.size() == 0) {
            return null;
        }
        return (d) this.f6874a.get(this.f6876c);
    }

    public final int m9278B() {
        return this.f6876c;
    }

    public ArrayList m9279C(int i) {
        if (i < 0 || i >= this.f6874a.size()) {
            return null;
        }
        return ((d) this.f6874a.get(i)).m9335n();
    }

    public final int m9280D() {
        return this.f6874a.size();
    }

    public int m9281E(String str) {
        int i = -1;
        for (int i2 = 0; i2 < this.f6874a.size(); i2++) {
            if (((d) this.f6874a.get(i2)).m9339r().equals(str)) {
                i = i2;
            }
        }
        return i;
    }

    public final d m9282F(int i) {
        return (d) this.f6874a.get(i);
    }

    public final String m9283G(int i) {
        if (i >= 0 && i < this.f6874a.size()) {
            return ((d) this.f6874a.get(i)).m9339r();
        }
        throw new IllegalStateException("invalid stack index[" + i + "]");
    }

    public int m9284H(InterfaceC0345Hd interfaceC0345Hd) {
        for (int i = 0; i < this.f6874a.size(); i++) {
            if (((d) this.f6874a.get(i)).m9342u(interfaceC0345Hd)) {
                return i;
            }
        }
        return -1;
    }

    public final int m9285I(String str) {
        for (int i = 0; i < this.f6874a.size(); i++) {
            if (((d) this.f6874a.get(i)).m9339r().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final ArrayList m9286J() {
        return this.f6874a;
    }

    public void m9287K() {
        if (m9277A() != null) {
            m9277A().m9340s();
        }
    }

    public void m9288L() {
        if (m9277A() != null) {
            m9277A().m9341t();
        }
    }

    public final boolean m9289M(InterfaceC0345Hd interfaceC0345Hd) {
        d dVarM9277A = m9277A();
        return dVarM9277A != null && dVarM9277A.m9333l() == interfaceC0345Hd;
    }

    public final void m9290N() {
        int size = this.f6874a.size();
        int i = this.f6876c;
        if (size > i + 1) {
            m9298V(i + 1);
        } else {
            m9298V(0);
        }
    }

    public final void m9291O() {
        int size = this.f6876c;
        if (size <= 0) {
            size = this.f6874a.size();
        }
        m9298V(size - 1);
    }

    public void m9292P(Runnable runnable) {
        ArrayList arrayList = new ArrayList<>(this.f6874a.size());
        for (int i = 0; i < this.f6874a.size(); i++) {
            d dVar = (d) this.f6874a.get(i);
            if (!dVar.lock) {
                arrayList.add(dVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (runnable != null) {
                this.f6875b.post(runnable);
            }
        } else {
            this.f6877d.removeAllViews();
            this.f6881h = true;
            this.f6875b.post(new a(arrayList, runnable));
        }
    }

    public final void m9293Q(int i) {
        int i2;
        int i3;
        if (this.f6874a.size() > 0) {
            if (i < 0 || i >= this.f6874a.size()) {
                throw new IllegalStateException("invalid tab index[" + i + "]");
            }
            boolean z = false;
            if (this.f6874a.size() != 1) {
                int i4 = this.f6876c;
                if (i == i4) {
                    if (i == this.f6874a.size() - 1) {
                        this.f6876c = i - 1;
                    } else if (i < this.f6874a.size() - 1) {
                        d dVar = (d) this.f6874a.get(i + 1);
                        d dVarM9277A = m9277A();
                        if (dVar.f6890c.equals(dVarM9277A.f6890c)) {
                            this.f6876c = i;
                        } else if (i > 0) {
                            int i5 = i - 1;
                            d dVar2 = (d) this.f6874a.get(i5);
                            if (dVar2.f6890c.equals(dVarM9277A.f6890c) || dVar2.m9339r().equals(dVarM9277A.f6890c)) {
                                this.f6876c = i5;
                            }
                        }
                    }
                    if (this.f6876c < 0) {
                        this.f6876c = 0;
                    }
                    z = true;
                } else {
                    i3 = i < i4 ? i4 - 1 : -1;
                }
                ((d) this.f6874a.remove(i)).m9331j();
                i2 = this.f6876c;
                if (i2 >= 0 || i2 >= this.f6874a.size() || !z) {
                    return;
                }
                m9298V(this.f6876c);
                return;
            }
            this.f6876c = i3;
            ((d) this.f6874a.remove(i)).m9331j();
            i2 = this.f6876c;
            if (i2 >= 0) {
            }
        }
    }

    public void m9294R(String str) {
        int iM9285I = m9285I(str);
        if (iM9285I >= 0) {
            m9293Q(iM9285I);
            return;
        }
        throw new IllegalStateException("not found stack with give stackid:" + str);
    }

    public boolean m9295S(SharedPreferences sharedPreferences) {
        boolean z;
        String string;
        ArrayList arrayList;
        AndroidSystemUtils.startTiming("restoreState");
        try {
            Log.i("save-state", "prepare restoreUserData data..........." + this.f6876c);
            if (this.f6876c < 0) {
                this.f6876c = sharedPreferences.getInt("current_stack_index", 0);
            }
            Log.i("save-state", "prepare restoreUserData data..........." + this.f6876c);
            string = sharedPreferences.getString("pref-tab-list", null);
        } catch (Exception e) {
            Log.i("save-state", this.f6876c + ">>>>restore failed" + e);
            e.printStackTrace();
            this.f6874a.clear();
            this.f6876c = -1;
        }
        if (TextUtils.isEmpty(string)) {
            z = false;
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                d dVar = new d(stringTokenizer.nextToken());
                if (i != this.f6876c) {
                    dVar.m9346y(dVar.f6888a, sharedPreferences);
                    arrayList = this.f6874a;
                } else if (dVar.m9347z(dVar.f6888a, sharedPreferences)) {
                    arrayList = this.f6874a;
                } else {
                    Log.i("save-state", ">>>>restore tab failed:" + dVar.f6888a);
                    i++;
                }
                arrayList.add(dVar);
                i++;
            }
            z = true;
        }
        AndroidSystemUtils.logElapsedTime();
        int i2 = this.f6876c;
        if (i2 < 0 || i2 >= this.f6874a.size()) {
            Log.i("save-state", this.f6876c + "invalid index ");
            if (this.f6874a.size() > 0) {
                this.f6876c = 0;
            } else {
                z = false;
            }
        }
        if (z) {
            try {
                m9298V(this.f6876c);
            } catch (Exception e2) {
                Log.i("save-state", this.f6876c + "####restore failed" + e2);
                return false;
            }
        }
        return z;
    }

    public void m9296T(ArrayList arrayList) {
        for (Object o : arrayList) {
            C1697en c1697en = (C1697en) o;
            d dVar = new d(null);
            dVar.m9322A(c1697en);
            this.f6874a.add(dVar);
        }
    }

    public void m9297U(SharedPreferences sharedPreferences) {
        AndroidSystemUtils.startTiming("saveState");
        int size = this.f6874a.size();
        int iM9278B = m9278B();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (iM9278B < 0 || iM9278B >= size) {
            iM9278B = 0;
        }
        editorEdit.putInt("current_stack_index", iM9278B).apply();
        editorEdit.putInt("num_tabs", size).apply();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.f6874a.get(i);
            WebViewBrowserController webViewBrowserController = (WebViewBrowserController) dVar.m9333l();
            if (webViewBrowserController == null || webViewBrowserController.mo5626h() != 8) {
                stringBuffer.append(i == 0 ? dVar.f6888a : "," + dVar.f6888a);
                dVar.m9323B(dVar.f6888a, editorEdit);
            }
        }
        editorEdit.putString("pref-tab-list", stringBuffer.toString());
        int i2 = this.f6876c;
        if (i2 >= 0 && i2 < this.f6874a.size()) {
            d dVar2 = (d) this.f6874a.get(this.f6876c);
            WebViewBrowserController webViewBrowserController2 = (WebViewBrowserController) dVar2.m9333l();
            String strMo1573b = webViewBrowserController2 != null ? webViewBrowserController2.mo1573b() : dVar2.m9338q();
            if (strMo1573b == null) {
                strMo1573b = "";
            }
            editorEdit.putString("last-active-tab-url", strMo1573b);
        }
        editorEdit.commit();
        Log.i("save-state", ">>>>>>>>> saveState finished>>>>>>");
        AndroidSystemUtils.logElapsedTime();
    }

    public final void m9298V(int i) {
        if (i >= 0 && i <= this.f6874a.size() - 1) {
            m9299W((d) this.f6874a.get(i));
            return;
        }
        throw new IllegalStateException("specify stack id not exist [" + i + "]");
    }

    public final void m9299W(d dVar) {
        int iIndexOf = this.f6874a.indexOf(dVar);
        if (iIndexOf >= 0) {
            dVar.m9343v();
            d dVarM9277A = m9277A();
            InterfaceC0345Hd interfaceC0345HdM9333l = dVarM9277A.m9333l();
            if (interfaceC0345HdM9333l instanceof WebViewBrowserController) {
                WebViewBrowserController webViewBrowserController = (WebViewBrowserController) interfaceC0345HdM9333l;
                dVarM9277A.f6894g = webViewBrowserController.mo1574c();
                dVarM9277A.f6895h = webViewBrowserController.mo1573b();
            }
            if (interfaceC0345HdM9333l != null) {
                interfaceC0345HdM9333l.mo1576g();
            }
            this.f6876c = iIndexOf;
            InterfaceC0345Hd interfaceC0345HdM9333l2 = dVar.m9333l();
            if (interfaceC0345HdM9333l2 != null) {
                m9301Y(interfaceC0345HdM9333l2);
            }
        }
    }

    public void m9300X(String str) {
        Iterator it = this.f6874a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.m9339r().equals(str)) {
                m9299W(dVar);
                return;
            }
        }
    }

    public final void m9301Y(InterfaceC0345Hd interfaceC0345Hd) {
        this.f6877d.removeAllViews();
        this.f6877d.addView(interfaceC0345Hd.mo1695d(), new FrameLayout.LayoutParams(-1, -1));
        interfaceC0345Hd.mo1584u();
        Log.i("ContentViewManager", ">>>>>>>>add view to continer " + interfaceC0345Hd.mo1695d());
        c cVar = this.f6883j;
        if (cVar != null) {
            cVar.mo6289a(interfaceC0345Hd);
        }
    }

    public void m9302Z(c cVar) {
        this.f6883j = cVar;
    }

    public final void m9303a0(ArrayList arrayList) {
        if (arrayList.size() != this.f6874a.size()) {
            ArrayList arrayList2 = new ArrayList<>(3);
            for (int i = 0; i < this.f6874a.size(); i++) {
                String strM9339r = ((d) this.f6874a.get(i)).m9339r();
                if (!m9315x(strM9339r, arrayList)) {
                    arrayList2.add(strM9339r);
                }
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                m9294R((String) arrayList2.get(i2));
            }
        } else {
            int i3 = -1;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) arrayList.get(i4);
                ((d) this.f6874a.get(m9285I((String) interfaceC0529Ld.mo2666e()))).f6892e = i4;
                if (interfaceC0529Ld.mo2682u()) {
                    i3 = i4;
                }
            }
            Collections.sort(this.f6874a, new b());
            this.f6876c = i3;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ((d) this.f6874a.get(i5)).lock = ((InterfaceC0529Ld) arrayList.get(i5)).mo2680s();
        }
    }

    public final void m9304l(int i) {
        d dVarM9277A = m9277A();
        InterfaceC0345Hd interfaceC0345HdM9333l = dVarM9277A.m9333l();
        if (interfaceC0345HdM9333l != null) {
            interfaceC0345HdM9333l.mo1576g();
        }
        InterfaceC0345Hd interfaceC0345HdM9332k = dVarM9277A.m9332k(i);
        if (interfaceC0345HdM9332k != null) {
            dVarM9277A.m9330i(i);
            m9301Y(interfaceC0345HdM9332k);
        }
    }

    public final void m9305m(InterfaceC0345Hd interfaceC0345Hd) {
        m9307o(interfaceC0345Hd, false);
    }

    public final void m9306n(InterfaceC0345Hd interfaceC0345Hd, int i) {
        d dVar = (d) this.f6874a.get(i);
        if (dVar != null) {
            dVar.m9326e(interfaceC0345Hd, false);
            return;
        }
        Log.w("ContentViewManager", "not found tab group with groud id:" + i);
    }

    public final void m9307o(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
        d dVarM9277A = m9277A();
        if (dVarM9277A != null) {
            dVarM9277A.m9326e(interfaceC0345Hd, z);
        } else {
            m9312u(interfaceC0345Hd, true);
            this.f6876c = 0;
        }
    }

    public boolean m9308p() {
        if (m9277A() != null) {
            return m9277A().m9329h();
        }
        return false;
    }

    public boolean m9309q() {
        if (m9277A() != null) {
            return m9277A().m9328g();
        }
        return false;
    }

    public abstract InterfaceC0345Hd mo5705r(String str, String str2);

    public final d m9310s(InterfaceC0345Hd interfaceC0345Hd) {
        return m9313v(interfaceC0345Hd, true, this.f6874a.size(), null);
    }

    public final d m9311t(InterfaceC0345Hd interfaceC0345Hd, String str) {
        int i = this.f6876c;
        return m9313v(interfaceC0345Hd, false, (i >= 0 && i < this.f6874a.size()) ? this.f6876c + 1 : this.f6874a.size(), str);
    }

    public final d m9312u(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
        int i = this.f6876c;
        return m9313v(interfaceC0345Hd, z, (i >= 0 && i < this.f6874a.size()) ? this.f6876c + 1 : this.f6874a.size(), null);
    }

    public final d m9313v(InterfaceC0345Hd interfaceC0345Hd, boolean z, int i, String str) {
        d dVar = new d(str);
        d dVarM9277A = m9277A();
        if (dVarM9277A != null) {
            dVar.f6890c = dVarM9277A.f6888a;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.f6874a.size()) {
            i = this.f6874a.size();
        }
        this.f6874a.add(i, dVar);
        Log.i("save-state", " current active index:" + this.f6876c + " active:" + z);
        if (z) {
            this.f6876c = i;
            m9305m(interfaceC0345Hd);
        } else {
            dVar.m9327f(interfaceC0345Hd, false);
        }
        Log.i("save-state", " >>current active index:" + this.f6876c);
        dVar.f6892e = i;
        return dVar;
    }

    public void m9314w() {
        for (int i = 0; i < this.f6874a.size(); i++) {
            ((d) this.f6874a.get(i)).m9331j();
        }
        this.f6874a.clear();
        this.f6876c = -1;
    }

    public final boolean m9315x(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(((InterfaceC0529Ld) it.next()).mo2666e())) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC0345Hd m9316y() {
        if (this.f6874a.isEmpty()) {
            return null;
        }
        int i = this.f6876c;
        if (i < 0 || i >= this.f6874a.size()) {
            this.f6876c = 0;
        }
        return ((d) this.f6874a.get(this.f6876c)).m9333l();
    }

    public InterfaceC0345Hd m9317z(int i) {
        if (i >= 0 && i < this.f6874a.size()) {
            return ((d) this.f6874a.get(i)).m9333l();
        }
        throw new IllegalStateException("invalid stack index[" + i + "]");
    }
}
