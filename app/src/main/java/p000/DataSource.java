package p000;

import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public abstract class DataSource implements InterfaceC2183p7 {

    public String dataSourceName;

    public String url;

    public String f6664c;

    public Context f6665d;

    public SoftReference f6666e;

    public ArrayList f6667f;

    public boolean f6668g;

    public DataSource() {
        this(false);
    }

    @Override
    public void mo9036a(String str) {
        this.url = str;
    }

    @Override
    public String mo8842b() {
        String str = this.dataSourceName;
        return str == null ? this.f6664c : str;
    }

    @Override
    public int mo9037c() {
        return 1;
    }

    @Override
    public void mo9038d(String str) {
        this.dataSourceName = str;
    }

    @Override
    public String mo9039e() {
        return this.url;
    }

    @Override
    public String mo61f() {
        String str = this.f6664c;
        return str == null ? getClass().getName() : str;
    }

    @Override
    public ArrayList mo9040g() {
        if (this.f6668g) {
            return this.f6667f;
        }
        SoftReference softReference = this.f6666e;
        if (softReference != null) {
            return (ArrayList) softReference.get();
        }
        return null;
    }

    @Override
    public boolean mo9041h(Object obj, int i) {
        try {
            ArrayList arrayListMo62j = mo62j(obj, i);
            if (arrayListMo62j == null) {
                return false;
            }
            if (this.f6668g) {
                this.f6667f = arrayListMo62j;
                return true;
            }
            this.f6666e = new SoftReference(arrayListMo62j);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void mo9042i(Context context) {
        this.f6665d = context;
    }

    public abstract ArrayList mo62j(Object obj, int i);

    public Context m9087k() {
        return this.f6665d;
    }

    public void m9088l(String str) {
        this.f6664c = str;
    }

    public String toString() {
        return ((("============= datasource ==============\n  dataSourceType:" + this.f6664c + "\n") + "  dataSourceName:" + this.dataSourceName + "\n") + "  url:" + this.url + "\n") + "=============== end ================= \n";
    }

    public DataSource(boolean z) {
        this.dataSourceName = null;
        this.url = null;
        this.f6664c = null;
        this.f6665d = null;
        this.f6666e = null;
        this.f6667f = null;
        this.f6668g = z;
    }
}
