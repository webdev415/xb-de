package p000;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractC0172Do {

    public final ScriptMap f430a;

    public final ScriptMap f431b;

    public final ScriptMap f432c;

    public AbstractC0172Do(ScriptMap scriptMap, ScriptMap c2453v12, ScriptMap c2453v13) {
        this.f430a = scriptMap;
        this.f431b = c2453v12;
        this.f432c = c2453v13;
    }

    public abstract void mo736A(byte[] bArr);

    public void m737B(byte[] bArr, int i) {
        mo772w(i);
        mo736A(bArr);
    }

    public abstract void mo738C(CharSequence charSequence);

    public void m739D(CharSequence charSequence, int i) {
        mo772w(i);
        mo738C(charSequence);
    }

    public abstract void mo740E(int i);

    public void m741F(int i, int i2) {
        mo772w(i2);
        mo740E(i);
    }

    public abstract void mo742G(Parcelable parcelable);

    public void m743H(Parcelable parcelable, int i) {
        mo772w(i);
        mo742G(parcelable);
    }

    public abstract void mo744I(String str);

    public void m745J(String str, int i) {
        mo772w(i);
        mo744I(str);
    }

    public void m746K(InterfaceC0264Fo interfaceC0264Fo, AbstractC0172Do abstractC0172Do) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            m754e(interfaceC0264Fo.getClass()).invoke(null, interfaceC0264Fo, abstractC0172Do);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    public void m747L(InterfaceC0264Fo interfaceC0264Fo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0264Fo == null) {
            mo744I(null);
            return;
        }
        m749N(interfaceC0264Fo);
        AbstractC0172Do abstractC0172DoMo751b = mo751b();
        m746K(interfaceC0264Fo, abstractC0172DoMo751b);
        abstractC0172DoMo751b.mo750a();
    }

    public void m748M(InterfaceC0264Fo interfaceC0264Fo, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mo772w(i);
        m747L(interfaceC0264Fo);
    }

    public final void m749N(InterfaceC0264Fo interfaceC0264Fo) {
        try {
            mo744I(m752c(interfaceC0264Fo.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(interfaceC0264Fo.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public abstract void mo750a();

    public abstract AbstractC0172Do mo751b();

    public final Class m752c(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f432c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f432c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method m753d(String str) throws NoSuchMethodException, SecurityException {
        Method method = (Method) this.f430a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0172Do.class.getClassLoader()).getDeclaredMethod("read", AbstractC0172Do.class);
        this.f430a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method m754e(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = (Method) this.f431b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsM752c = m752c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM752c.getDeclaredMethod("write", cls, AbstractC0172Do.class);
        this.f431b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean m755f() {
        return false;
    }

    public abstract boolean mo756g();

    public boolean m757h(boolean z, int i) {
        return !mo762m(i) ? z : mo756g();
    }

    public abstract byte[] mo758i();

    public byte[] m759j(byte[] bArr, int i) {
        return !mo762m(i) ? bArr : mo758i();
    }

    public abstract CharSequence mo760k();

    public CharSequence m761l(CharSequence charSequence, int i) {
        return !mo762m(i) ? charSequence : mo760k();
    }

    public abstract boolean mo762m(int i);

    public InterfaceC0264Fo m763n(String str, AbstractC0172Do abstractC0172Do) {
        try {
            return (InterfaceC0264Fo) m753d(str).invoke(null, abstractC0172Do);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract int mo764o();

    public int m765p(int i, int i2) {
        return !mo762m(i2) ? i : mo764o();
    }

    public abstract Parcelable mo766q();

    public Parcelable m767r(Parcelable parcelable, int i) {
        return !mo762m(i) ? parcelable : mo766q();
    }

    public abstract String mo768s();

    public String m769t(String str, int i) {
        return !mo762m(i) ? str : mo768s();
    }

    public InterfaceC0264Fo m770u() {
        String strMo768s = mo768s();
        if (strMo768s == null) {
            return null;
        }
        return m763n(strMo768s, mo751b());
    }

    public InterfaceC0264Fo m771v(InterfaceC0264Fo interfaceC0264Fo, int i) {
        return !mo762m(i) ? interfaceC0264Fo : m770u();
    }

    public abstract void mo772w(int i);

    public abstract void mo774y(boolean z);

    public void m775z(boolean z, int i) {
        mo772w(i);
        mo774y(z);
    }

    public void m773x(boolean z, boolean z2) {
    }
}
