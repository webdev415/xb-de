package p000;

import p000.AbstractC0580Mi;
import p000.C0534Li;

public final class C0921U1 extends AbstractC0580Mi {

    public final String f2799b;

    public final C0534Li.a f2800c;

    public final String f2801d;

    public final String f2802e;

    public final long f2803f;

    public final long f2804g;

    public final String f2805h;

    public static final class b extends a {

        public String f2806a;

        public C0534Li.a f2807b;

        public String f2808c;

        public String f2809d;

        public Long f2810e;

        public Long f2811f;

        public String f2812g;

        public b() {
        }

        @Override
        public AbstractC0580Mi mo2905a() {
            String str = "";
            if (this.f2807b == null) {
                str = " registrationStatus";
            }
            if (this.f2810e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f2811f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new C0921U1(this.f2806a, this.f2807b, this.f2808c, this.f2809d, this.f2810e.longValue(), this.f2811f.longValue(), this.f2812g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override
        public a mo2906b(String str) {
            this.f2808c = str;
            return this;
        }

        @Override
        public a mo2907c(long j) {
            this.f2810e = Long.valueOf(j);
            return this;
        }

        @Override
        public a mo2908d(String str) {
            this.f2806a = str;
            return this;
        }

        @Override
        public a mo2909e(String str) {
            this.f2812g = str;
            return this;
        }

        @Override
        public a mo2910f(String str) {
            this.f2809d = str;
            return this;
        }

        @Override
        public a mo2911g(C0534Li.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f2807b = aVar;
            return this;
        }

        @Override
        public a mo2912h(long j) {
            this.f2811f = Long.valueOf(j);
            return this;
        }

        public b(AbstractC0580Mi abstractC0580Mi) {
            this.f2806a = abstractC0580Mi.mo2888d();
            this.f2807b = abstractC0580Mi.mo2891g();
            this.f2808c = abstractC0580Mi.mo2886b();
            this.f2809d = abstractC0580Mi.mo2890f();
            this.f2810e = Long.valueOf(abstractC0580Mi.mo2887c());
            this.f2811f = Long.valueOf(abstractC0580Mi.mo2892h());
            this.f2812g = abstractC0580Mi.mo2889e();
        }
    }

    public C0921U1(String str, C0534Li.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.f2799b = str;
        this.f2800c = aVar;
        this.f2801d = str2;
        this.f2802e = str3;
        this.f2803f = j;
        this.f2804g = j2;
        this.f2805h = str4;
    }

    @Override
    public String mo2886b() {
        return this.f2801d;
    }

    @Override
    public long mo2887c() {
        return this.f2803f;
    }

    @Override
    public String mo2888d() {
        return this.f2799b;
    }

    @Override
    public String mo2889e() {
        return this.f2805h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0580Mi)) {
            return false;
        }
        AbstractC0580Mi abstractC0580Mi = (AbstractC0580Mi) obj;
        String str3 = this.f2799b;
        if (str3 != null ? str3.equals(abstractC0580Mi.mo2888d()) : abstractC0580Mi.mo2888d() == null) {
            if (this.f2800c.equals(abstractC0580Mi.mo2891g()) && ((str = this.f2801d) != null ? str.equals(abstractC0580Mi.mo2886b()) : abstractC0580Mi.mo2886b() == null) && ((str2 = this.f2802e) != null ? str2.equals(abstractC0580Mi.mo2890f()) : abstractC0580Mi.mo2890f() == null) && this.f2803f == abstractC0580Mi.mo2887c() && this.f2804g == abstractC0580Mi.mo2892h()) {
                String str4 = this.f2805h;
                String strMo2889e = abstractC0580Mi.mo2889e();
                if (str4 == null) {
                    if (strMo2889e == null) {
                        return true;
                    }
                } else if (str4.equals(strMo2889e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String mo2890f() {
        return this.f2802e;
    }

    @Override
    public C0534Li.a mo2891g() {
        return this.f2800c;
    }

    @Override
    public long mo2892h() {
        return this.f2804g;
    }

    public int hashCode() {
        String str = this.f2799b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f2800c.hashCode()) * 1000003;
        String str2 = this.f2801d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2802e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f2803f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f2804g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f2805h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override
    public a mo2898n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f2799b + ", registrationStatus=" + this.f2800c + ", authToken=" + this.f2801d + ", refreshToken=" + this.f2802e + ", expiresInSecs=" + this.f2803f + ", tokenCreationEpochInSecs=" + this.f2804g + ", fisError=" + this.f2805h + "}";
    }
}
