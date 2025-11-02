package p000;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class C2169ou extends AbstractC2167os implements InterfaceC1984ku {
    public C2169ou(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override
    public final void beginAdUnitExposure(String str, long j) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeLong(j);
        m8984Q(23, parcelM8982O);
    }

    @Override
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        m8984Q(9, parcelM8982O);
    }

    @Override
    public final void clearMeasurementEnabled(long j) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeLong(j);
        m8984Q(43, parcelM8982O);
    }

    @Override
    public final void endAdUnitExposure(String str, long j) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeLong(j);
        m8984Q(24, parcelM8982O);
    }

    @Override
    public final void generateEventId(InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(22, parcelM8982O);
    }

    @Override
    public final void getCachedAppInstanceId(InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(19, parcelM8982O);
    }

    @Override
    public final void getConditionalUserProperties(String str, String str2, InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(10, parcelM8982O);
    }

    @Override
    public final void getCurrentScreenClass(InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(17, parcelM8982O);
    }

    @Override
    public final void getCurrentScreenName(InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(16, parcelM8982O);
    }

    @Override
    public final void getGmpAppId(InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(21, parcelM8982O);
    }

    @Override
    public final void getMaxUserProperties(String str, InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(6, parcelM8982O);
    }

    @Override
    public final void getUserProperties(String str, String str2, boolean z, InterfaceC2076mu interfaceC2076mu) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9602e(parcelM8982O, z);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        m8984Q(5, parcelM8982O);
    }

    @Override
    public final void initialize(InterfaceC0667Od interfaceC0667Od, C0086Bu c0086Bu, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        AbstractC2351ss.m9601d(parcelM8982O, c0086Bu);
        parcelM8982O.writeLong(j);
        m8984Q(1, parcelM8982O);
    }

    @Override
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        AbstractC2351ss.m9602e(parcelM8982O, z);
        AbstractC2351ss.m9602e(parcelM8982O, z2);
        parcelM8982O.writeLong(j);
        m8984Q(2, parcelM8982O);
    }

    @Override
    public final void logHealthData(int i, String str, InterfaceC0667Od interfaceC0667Od, InterfaceC0667Od interfaceC0667Od2, InterfaceC0667Od interfaceC0667Od3) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeInt(i);
        parcelM8982O.writeString(str);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od2);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od3);
        m8984Q(33, parcelM8982O);
    }

    @Override
    public final void onActivityCreated(InterfaceC0667Od interfaceC0667Od, Bundle bundle, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        parcelM8982O.writeLong(j);
        m8984Q(27, parcelM8982O);
    }

    @Override
    public final void onActivityDestroyed(InterfaceC0667Od interfaceC0667Od, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeLong(j);
        m8984Q(28, parcelM8982O);
    }

    @Override
    public final void onActivityPaused(InterfaceC0667Od interfaceC0667Od, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeLong(j);
        m8984Q(29, parcelM8982O);
    }

    @Override
    public final void onActivityResumed(InterfaceC0667Od interfaceC0667Od, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeLong(j);
        m8984Q(30, parcelM8982O);
    }

    @Override
    public final void onActivitySaveInstanceState(InterfaceC0667Od interfaceC0667Od, InterfaceC2076mu interfaceC2076mu, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC2076mu);
        parcelM8982O.writeLong(j);
        m8984Q(31, parcelM8982O);
    }

    @Override
    public final void onActivityStarted(InterfaceC0667Od interfaceC0667Od, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeLong(j);
        m8984Q(25, parcelM8982O);
    }

    @Override
    public final void onActivityStopped(InterfaceC0667Od interfaceC0667Od, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeLong(j);
        m8984Q(26, parcelM8982O);
    }

    @Override
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        parcelM8982O.writeLong(j);
        m8984Q(8, parcelM8982O);
    }

    @Override
    public final void setCurrentScreen(InterfaceC0667Od interfaceC0667Od, String str, String str2, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9600c(parcelM8982O, interfaceC0667Od);
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        parcelM8982O.writeLong(j);
        m8984Q(15, parcelM8982O);
    }

    @Override
    public final void setDataCollectionEnabled(boolean z) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9602e(parcelM8982O, z);
        m8984Q(39, parcelM8982O);
    }

    @Override
    public final void setMeasurementEnabled(boolean z, long j) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9602e(parcelM8982O, z);
        parcelM8982O.writeLong(j);
        m8984Q(11, parcelM8982O);
    }

    @Override
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, intent);
        m8984Q(48, parcelM8982O);
    }
}
