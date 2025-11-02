package p000;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class C0791R9 implements Map, Serializable {

    public static final C0791R9 f2350l = new C0791R9();

    public boolean m3765a(Void r2) {
        AbstractC0116Ce.m476e(r2, "value");
        return false;
    }

    @Override
    public Void get(Object obj) {
        return null;
    }

    public Set m3767c() {
        return C0837S9.f2606l;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return m3765a((Void) obj);
        }
        return false;
    }

    public Set m3768d() {
        return C0837S9.f2606l;
    }

    public int m3769e() {
        return 0;
    }

    @Override
    public final /* bridge */ Set entrySet() {
        return m3767c();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public Collection m3770f() {
        return C0746Q9.f2208l;
    }

    @Override
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public final /* bridge */ Set keySet() {
        return m3768d();
    }

    @Override
    public /* bridge */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return m3769e();
    }

    public String toString() {
        return "{}";
    }

    @Override
    public final /* bridge */ Collection values() {
        return m3770f();
    }
}
