package p000;

import java.util.List;

/* loaded from: classes.dex */
public enum DecodeHintType {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(InterfaceC0903Tk.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);


    public final Class f36l;

    DecodeHintType(Class cls) {
        this.f36l = cls;
    }

    public Class m36c() {
        return this.f36l;
    }
}
