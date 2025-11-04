package p000;

public final class TokenResult extends AbstractC0263Fn {

    public final String token;

    public final long tokenExpirationTimestamp;

    public final AbstractC0263Fn.b responseCode;

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
                return new TokenResult(this.f3019a, this.f3020b.longValue(), this.f3021c);
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

    public TokenResult(String str, long j, AbstractC0263Fn.b bVar) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = bVar;
    }

    @Override
    public AbstractC0263Fn.b mo1283b() {
        return this.responseCode;
    }

    @Override
    public String mo1284c() {
        return this.token;
    }

    @Override
    public long mo1285d() {
        return this.tokenExpirationTimestamp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0263Fn)) {
            return false;
        }
        AbstractC0263Fn abstractC0263Fn = (AbstractC0263Fn) obj;
        String str = this.token;
        if (str != null ? str.equals(abstractC0263Fn.mo1284c()) : abstractC0263Fn.mo1284c() == null) {
            if (this.tokenExpirationTimestamp == abstractC0263Fn.mo1285d()) {
                AbstractC0263Fn.b bVar = this.responseCode;
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
        String str = this.token;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        AbstractC0263Fn.b bVar = this.responseCode;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", responseCode=" + this.responseCode + "}";
    }
}
