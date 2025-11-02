package p000;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0534Li {

    public File f1718a;

    public final C1364cb f1719b;

    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public C0534Li(C1364cb c1364cb) {
        this.f1719b = c1364cb;
    }

    public final File m2703a() {
        if (this.f1718a == null) {
            synchronized (this) {
                try {
                    if (this.f1718a == null) {
                        this.f1718a = new File(this.f1719b.m5872j().getFilesDir(), "PersistedInstallation." + this.f1719b.m5875n() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.f1718a;
    }

    public AbstractC0580Mi m2704b(AbstractC0580Mi abstractC0580Mi) throws JSONException, IOException {
        File fileCreateTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", abstractC0580Mi.mo2888d());
            jSONObject.put("Status", abstractC0580Mi.mo2891g().ordinal());
            jSONObject.put("AuthToken", abstractC0580Mi.mo2886b());
            jSONObject.put("RefreshToken", abstractC0580Mi.mo2890f());
            jSONObject.put("TokenCreationEpochInSecs", abstractC0580Mi.mo2892h());
            jSONObject.put("ExpiresInSecs", abstractC0580Mi.mo2887c());
            jSONObject.put("FisError", abstractC0580Mi.mo2889e());
            fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f1719b.m5872j().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (fileCreateTempFile.renameTo(m2703a())) {
            return abstractC0580Mi;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    public final JSONObject m2705c() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(m2703a());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public AbstractC0580Mi m2706d() throws IOException {
        JSONObject jSONObjectM2705c = m2705c();
        String strOptString = jSONObjectM2705c.optString("Fid", null);
        int iOptInt = jSONObjectM2705c.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String strOptString2 = jSONObjectM2705c.optString("AuthToken", null);
        String strOptString3 = jSONObjectM2705c.optString("RefreshToken", null);
        long jOptLong = jSONObjectM2705c.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObjectM2705c.optLong("ExpiresInSecs", 0L);
        return AbstractC0580Mi.m2885a().mo2908d(strOptString).mo2911g(a.values()[iOptInt]).mo2906b(strOptString2).mo2910f(strOptString3).mo2912h(jOptLong).mo2907c(jOptLong2).mo2909e(jSONObjectM2705c.optString("FisError", null)).mo2905a();
    }
}
