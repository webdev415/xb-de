package p000;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractC1669e5 {
    public static List m7387a(Object obj) {
        return Collections.singletonList(obj);
    }

    public static List m7388b(Object... objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(objArr)) : Collections.singletonList(objArr[0]) : Collections.emptyList();
    }
}
