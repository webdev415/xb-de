package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class C2270r2 {

    public final Map f6862a = new HashMap<>();

    public int[] m9255a() {
        ArrayList arrayList = new ArrayList<>();
        int iIntValue = -1;
        for (Map.Entry entry : this.f6862a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
            } else if (((Integer) entry.getValue()).intValue() == iIntValue) {
            }
            arrayList.add(entry.getKey());
        }
        return AbstractC2156oi.m8965b(arrayList);
    }

    public void m9256b(int i) {
        Integer num = (Integer) this.f6862a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f6862a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
