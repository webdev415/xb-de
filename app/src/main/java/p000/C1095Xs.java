package p000;

import java.io.File;

public final class C1095Xs implements InterfaceC1187Zs {
    @Override
    public final String mo4853a(File file, String str, AbstractC1844ht abstractC1844ht) {
        return mo4855c(new File(file, str).getPath(), abstractC1844ht);
    }

    @Override
    public final String mo4855c(String str, AbstractC1844ht abstractC1844ht) {
        return mo4854b(str, abstractC1844ht, EnumC1336bt.RAW_FILE_IO_TYPE);
    }

    @Override
    public final String mo4856d(File file, String str) {
        return mo4853a(file, str, AbstractC1844ht.f5771a);
    }

    @Override
    public final String mo4857g(String str) {
        return mo4855c(str, AbstractC1844ht.f5771a);
    }

    @Override
    public final String mo4854b(String str, AbstractC1844ht abstractC1844ht, EnumC1336bt enumC1336bt) {
        return str;
    }
}
