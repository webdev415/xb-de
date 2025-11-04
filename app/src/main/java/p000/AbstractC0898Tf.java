package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class AbstractC0898Tf {
    public static boolean m4153a(List list, Object obj) {
        if (obj == AbstractC1131Yi.m4973i(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return AbstractC0622Ne.m3319b(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!AbstractC0303Gh.m1398a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int m4154b(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return m4155c(list, obj);
        }
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (AbstractC0303Gh.m1398a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int m4155c(List list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int m4156d(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return m4157e(list, obj);
        }
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (AbstractC0303Gh.m1398a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int m4157e(List list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static ArrayList m4158f() {
        return new ArrayList<>();
    }

    public static ArrayList m4159g(Iterator it) {
        ArrayList arrayListM4158f = m4158f();
        AbstractC0622Ne.m3318a(arrayListM4158f, it);
        return arrayListM4158f;
    }
}
