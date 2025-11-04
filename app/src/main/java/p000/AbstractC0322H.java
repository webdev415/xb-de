package p000;

import java.util.AbstractList;
import java.util.List;

public abstract class AbstractC0322H extends AbstractList implements List {
    public abstract int mo1462d();

    public abstract Object mo1463f(int i);

    @Override
    public final /* bridge */ Object remove(int i) {
        return mo1463f(i);
    }

    @Override
    public final /* bridge */ int size() {
        return mo1462d();
    }
}
