package p000;

import p000.AbstractC0263Fn;

/* loaded from: classes.dex */
public final class C1013W1 extends AbstractC0263Fn {

    public final String f3016a;

    public final long f3017b;

    public final AbstractC0263Fn.b f3018c;

    public static final class b extends a {

        public String f3019a;

        public Long f3020b;

        public AbstractC0263Fn.b f3021c;

        @Override
        public AbstractC0263Fn mo1286a() {
            String str = "";
            if (this.f3020b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new C1013W1(this.f3019a, this.f3020b.longValue(), this.f3021c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override
        public a mo1287b(AbstractC0263Fn.b bVar) {
            this.f3021c = bVar;
            return this;
        }

        @Override
        public a mo1288c(String str) {
            this.f3019a = str;
            return this;
        }

        @Override
        public a mo1289d(long j) {
            this.f3020b = Long.valueOf(j);
            return this;
        }
    }

    public C1013W1(String str, long j, AbstractC0263Fn.b bVar) {
        this.f3016a = str;
        this.f3017b = j;
        this.f3018c = bVar;
    }

    @Override
    public AbstractC0263Fn.b mo1283b() {
        return this.f3018c;
    }

    @Override
    public String mo1284c() {
        return this.f3016a;
    }

    @Override
    public long mo1285d() {
        return this.f3017b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0263Fn)) {
            return false;
        }
        AbstractC0263Fn abstractC0263Fn = (AbstractC0263Fn) obj;
        String str = this.f3016a;
        if (str != null ? str.equals(abstractC0263Fn.mo1284c()) : abstractC0263Fn.mo1284c() == null) {
            if (this.f3017b == abstractC0263Fn.mo1285d()) {
                AbstractC0263Fn.b bVar = this.f3018c;
                AbstractC0263Fn.b bVarMo1283b = abstractC0263Fn.mo1283b();
                if (bVar == null) {
                    if (bVarMo1283b == null) {
                        return true;
                    }
                } else if (bVar.equals(bVarMo1283b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3016a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f3017b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        AbstractC0263Fn.b bVar = this.f3018c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f3016a + ", tokenExpirationTimestamp=" + this.f3017b + ", responseCode=" + this.f3018c + "}";
    }
}
