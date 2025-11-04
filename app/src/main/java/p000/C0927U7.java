package p000;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class C0927U7 implements InterfaceC0652O7 {

    public Collection f2824a;

    public Map f2825b;

    public String f2826c;

    public int f2827d;

    public C0927U7() {
    }

    @Override
    public C0606N7 mo3383a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.f2825b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.f2824a;
        if (collection != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = this.f2826c;
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, str);
        }
        QRCodeReader QRCodeReader = new QRCodeReader();
        QRCodeReader.m5923f(enumMap);
        int i = this.f2827d;
        return i != 0 ? i != 1 ? i != 2 ? new C0606N7(QRCodeReader) : new C0945Ug(QRCodeReader) : new C0392Ie(QRCodeReader) : new C0606N7(QRCodeReader);
    }

    public C0927U7(Collection collection) {
        this.f2824a = collection;
    }

    public C0927U7(Collection collection, Map map, String str, int i) {
        this.f2824a = collection;
        this.f2825b = map;
        this.f2826c = str;
        this.f2827d = i;
    }
}
