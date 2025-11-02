package p000;

import p000.AbstractC2383te;

/* loaded from: classes.dex */
public final class C0829S1 extends AbstractC2383te {

    public final String f2572a;

    public final String f2573b;

    public final String f2574c;

    public final AbstractC0263Fn f2575d;

    public final AbstractC2383te.b f2576e;

    public static final class b extends a {

        public String f2577a;

        public String f2578b;

        public String f2579c;

        public AbstractC0263Fn f2580d;

        public AbstractC2383te.b f2581e;

        @Override
        public AbstractC2383te mo3975a() {
            return new C0829S1(this.f2577a, this.f2578b, this.f2579c, this.f2580d, this.f2581e);
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

    public C0829S1(String str, String str2, String str3, AbstractC0263Fn abstractC0263Fn, AbstractC2383te.b bVar) {
        this.f2572a = str;
        this.f2573b = str2;
        this.f2574c = str3;
        this.f2575d = abstractC0263Fn;
        this.f2576e = bVar;
    }

    @Override
    public AbstractC0263Fn mo3970b() {
        return this.f2575d;
    }

    @Override
    public String mo3971c() {
        return this.f2573b;
    }

    @Override
    public String mo3972d() {
        return this.f2574c;
    }

    @Override
    public AbstractC2383te.b mo3973e() {
        return this.f2576e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2383te)) {
            return false;
        }
        AbstractC2383te abstractC2383te = (AbstractC2383te) obj;
        String str = this.f2572a;
        if (str != null ? str.equals(abstractC2383te.mo3974f()) : abstractC2383te.mo3974f() == null) {
            String str2 = this.f2573b;
            if (str2 != null ? str2.equals(abstractC2383te.mo3971c()) : abstractC2383te.mo3971c() == null) {
                String str3 = this.f2574c;
                if (str3 != null ? str3.equals(abstractC2383te.mo3972d()) : abstractC2383te.mo3972d() == null) {
                    AbstractC0263Fn abstractC0263Fn = this.f2575d;
                    if (abstractC0263Fn != null ? abstractC0263Fn.equals(abstractC2383te.mo3970b()) : abstractC2383te.mo3970b() == null) {
                        AbstractC2383te.b bVar = this.f2576e;
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
        return this.f2572a;
    }

    public int hashCode() {
        String str = this.f2572a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f2573b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2574c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AbstractC0263Fn abstractC0263Fn = this.f2575d;
        int iHashCode4 = (iHashCode3 ^ (abstractC0263Fn == null ? 0 : abstractC0263Fn.hashCode())) * 1000003;
        AbstractC2383te.b bVar = this.f2576e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f2572a + ", fid=" + this.f2573b + ", refreshToken=" + this.f2574c + ", authToken=" + this.f2575d + ", responseCode=" + this.f2576e + "}";
    }
}
