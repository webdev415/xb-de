package p000;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC1763g5 {
    public static final Object[] m7691a(Object[] objArr, boolean z) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        if (z && AbstractC0116Ce.m472a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC0116Ce.m475d(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    public static List m7692b(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC0116Ce.m475d(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
