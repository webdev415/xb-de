package p000;

public final class InstallationResponse extends AbstractC2383te {

    public final String uri;

    public final String fid;

    public final String refreshToken;

    public final AbstractC0263Fn authToken;

    public final AbstractC2383te.b responseCode;

    public static final class b extends a {

        public String f2577a;

        public String f2578b;

        public String f2579c;

        public AbstractC0263Fn f2580d;

        public AbstractC2383te.b f2581e;

        @Override
        public AbstractC2383te mo3975a() {
            return new InstallationResponse(this.f2577a, this.f2578b, this.f2579c, this.f2580d, this.f2581e);
        }

        @Override
        public a mo3976b(AbstractC0263Fn abstractC0263Fn) {
            this.f2580d = abstractC0263Fn;
            return this;
        }

        @Override
        public a mo3977c(String str) {
            this.f2578b = str;
            return this;
        }

        @Override
        public a mo3978d(String str) {
            this.f2579c = str;
            return this;
        }

        @Override
        public a mo3979e(AbstractC2383te.b bVar) {
            this.f2581e = bVar;
            return this;
        }

        @Override
        public a mo3980f(String str) {
            this.f2577a = str;
            return this;
        }
    }

    public InstallationResponse(String str, String str2, String str3, AbstractC0263Fn abstractC0263Fn, AbstractC2383te.b bVar) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = abstractC0263Fn;
        this.responseCode = bVar;
    }

    @Override
    public AbstractC0263Fn mo3970b() {
        return this.authToken;
    }

    @Override
    public String mo3971c() {
        return this.fid;
    }

    @Override
    public String mo3972d() {
        return this.refreshToken;
    }

    @Override
    public AbstractC2383te.b mo3973e() {
        return this.responseCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2383te)) {
            return false;
        }
        AbstractC2383te abstractC2383te = (AbstractC2383te) obj;
        String str = this.uri;
        if (str != null ? str.equals(abstractC2383te.mo3974f()) : abstractC2383te.mo3974f() == null) {
            String str2 = this.fid;
            if (str2 != null ? str2.equals(abstractC2383te.mo3971c()) : abstractC2383te.mo3971c() == null) {
                String str3 = this.refreshToken;
                if (str3 != null ? str3.equals(abstractC2383te.mo3972d()) : abstractC2383te.mo3972d() == null) {
                    AbstractC0263Fn abstractC0263Fn = this.authToken;
                    if (abstractC0263Fn != null ? abstractC0263Fn.equals(abstractC2383te.mo3970b()) : abstractC2383te.mo3970b() == null) {
                        AbstractC2383te.b bVar = this.responseCode;
                        AbstractC2383te.b bVarMo3973e = abstractC2383te.mo3973e();
                        if (bVar == null) {
                            if (bVarMo3973e == null) {
                                return true;
                            }
                        } else if (bVar.equals(bVarMo3973e)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String mo3974f() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AbstractC0263Fn abstractC0263Fn = this.authToken;
        int iHashCode4 = (iHashCode3 ^ (abstractC0263Fn == null ? 0 : abstractC0263Fn.hashCode())) * 1000003;
        AbstractC2383te.b bVar = this.responseCode;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.uri + ", fid=" + this.fid + ", refreshToken=" + this.refreshToken + ", authToken=" + this.authToken
                + ", responseCode=" + this.responseCode + "}";
    }
}
