package p000;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* loaded from: classes.dex */
public interface InterfaceC1984ku extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(InterfaceC2076mu interfaceC2076mu);

    void getAppInstanceId(InterfaceC2076mu interfaceC2076mu);

    void getCachedAppInstanceId(InterfaceC2076mu interfaceC2076mu);

    void getConditionalUserProperties(String str, String str2, InterfaceC2076mu interfaceC2076mu);

    void getCurrentScreenClass(InterfaceC2076mu interfaceC2076mu);

    void getCurrentScreenName(InterfaceC2076mu interfaceC2076mu);

    void getGmpAppId(InterfaceC2076mu interfaceC2076mu);

    void getMaxUserProperties(String str, InterfaceC2076mu interfaceC2076mu);

    void getSessionId(InterfaceC2076mu interfaceC2076mu);

    void getTestFlag(InterfaceC2076mu interfaceC2076mu, int i);

    void getUserProperties(String str, String str2, boolean z, InterfaceC2076mu interfaceC2076mu);

    void initForTests(Map map);

    void initialize(InterfaceC0667Od interfaceC0667Od, C0086Bu c0086Bu, long j);

    void isDataCollectionEnabled(InterfaceC2076mu interfaceC2076mu);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, InterfaceC2076mu interfaceC2076mu, long j);

    void logHealthData(int i, String str, InterfaceC0667Od interfaceC0667Od, InterfaceC0667Od interfaceC0667Od2, InterfaceC0667Od interfaceC0667Od3);

    void onActivityCreated(InterfaceC0667Od interfaceC0667Od, Bundle bundle, long j);

    void onActivityDestroyed(InterfaceC0667Od interfaceC0667Od, long j);

    void onActivityPaused(InterfaceC0667Od interfaceC0667Od, long j);

    void onActivityResumed(InterfaceC0667Od interfaceC0667Od, long j);

    void onActivitySaveInstanceState(InterfaceC0667Od interfaceC0667Od, InterfaceC2076mu interfaceC2076mu, long j);

    void onActivityStarted(InterfaceC0667Od interfaceC0667Od, long j);

    void onActivityStopped(InterfaceC0667Od interfaceC0667Od, long j);

    void performAction(Bundle bundle, InterfaceC2076mu interfaceC2076mu, long j);

    void registerOnMeasurementEventListener(InterfaceC2491vu interfaceC2491vu);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(InterfaceC0667Od interfaceC0667Od, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setDefaultEventParametersWithBackfill(Bundle bundle);

    void setEventInterceptor(InterfaceC2491vu interfaceC2491vu);

    void setInstanceIdProvider(InterfaceC2583xu interfaceC2583xu);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, InterfaceC0667Od interfaceC0667Od, boolean z, long j);

    void unregisterOnMeasurementEventListener(InterfaceC2491vu interfaceC2491vu);
}
