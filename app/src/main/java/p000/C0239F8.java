package p000;

import java.util.Arrays;
import java.util.List;

public class C0239F8 extends C0285G8 {

    public final List f650l;

    public C0239F8(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f650l = list;
    }
}
