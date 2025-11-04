package p000;

import java.util.Map;

public abstract class AbstractC0230F implements Map.Entry {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return AbstractC0303Gh.m1398a(getKey(), entry.getKey()) && AbstractC0303Gh.m1398a(getValue(), entry.getValue());
    }

    @Override
    public abstract Object getKey();

    @Override
    public abstract Object getValue();

    @Override
    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(getKey());
        String strValueOf2 = String.valueOf(getValue());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
