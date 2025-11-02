package p000;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;
import p000.InterfaceC0667Od;

/* loaded from: classes.dex */
public abstract class AbstractBinderC1891iu extends AbstractBinderC2443us implements InterfaceC1984ku {
    public AbstractBinderC1891iu() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static InterfaceC1984ku asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1984ku ? (InterfaceC1984ku) iInterfaceQueryLocalInterface : new C2169ou(iBinder);
    }

    @Override
    public final boolean mo7274O(int i, Parcel parcel, Parcel parcel2, int i2) {
        InterfaceC2076mu c2261qu;
        InterfaceC2076mu c2261qu2 = null;
        InterfaceC2076mu c2261qu3 = null;
        InterfaceC2076mu c2261qu4 = null;
        InterfaceC2076mu c2261qu5 = null;
        InterfaceC2491vu c2675zu = null;
        InterfaceC2491vu c2675zu2 = null;
        InterfaceC2491vu c2675zu3 = null;
        InterfaceC2076mu c2261qu6 = null;
        InterfaceC2076mu c2261qu7 = null;
        InterfaceC2076mu c2261qu8 = null;
        InterfaceC2076mu c2261qu9 = null;
        InterfaceC2076mu c2261qu10 = null;
        InterfaceC2076mu c2261qu11 = null;
        InterfaceC2583xu c0178Du = null;
        InterfaceC2076mu c2261qu12 = null;
        InterfaceC2076mu c2261qu13 = null;
        InterfaceC2076mu c2261qu14 = null;
        InterfaceC2076mu c2261qu15 = null;
        switch (i) {
            case 1:
                InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                C0086Bu c0086Bu = (C0086Bu) AbstractC2351ss.m9598a(parcel, C0086Bu.CREATOR);
                long j = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                initialize(interfaceC0667OdM3418P, c0086Bu, j);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                boolean zM9605h = AbstractC2351ss.m9605h(parcel);
                boolean zM9605h2 = AbstractC2351ss.m9605h(parcel);
                long j2 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                logEvent(string, string2, bundle, zM9605h, zM9605h2, j2);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    c2261qu = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu = iInterfaceQueryLocalInterface instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface : new C2261qu(strongBinder);
                }
                long j3 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                logEventAndBundle(string3, string4, bundle2, c2261qu, j3);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                InterfaceC0667Od interfaceC0667OdM3418P2 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                boolean zM9605h3 = AbstractC2351ss.m9605h(parcel);
                long j4 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setUserProperty(string5, string6, interfaceC0667OdM3418P2, zM9605h3, j4);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zM9605h4 = AbstractC2351ss.m9605h(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu2 = iInterfaceQueryLocalInterface2 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface2 : new C2261qu(strongBinder2);
                }
                AbstractC2351ss.m9603f(parcel);
                getUserProperties(string7, string8, zM9605h4, c2261qu2);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu15 = iInterfaceQueryLocalInterface3 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface3 : new C2261qu(strongBinder3);
                }
                AbstractC2351ss.m9603f(parcel);
                getMaxUserProperties(string9, c2261qu15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j5 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setUserId(string10, j5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                long j6 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setConditionalUserProperty(bundle3, j6);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu14 = iInterfaceQueryLocalInterface4 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface4 : new C2261qu(strongBinder4);
                }
                AbstractC2351ss.m9603f(parcel);
                getConditionalUserProperties(string13, string14, c2261qu14);
                break;
            case 11:
                boolean zM9605h5 = AbstractC2351ss.m9605h(parcel);
                long j7 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setMeasurementEnabled(zM9605h5, j7);
                break;
            case 12:
                long j8 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                resetAnalyticsData(j8);
                break;
            case 13:
                long j9 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setMinimumSessionDuration(j9);
                break;
            case 14:
                long j10 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setSessionTimeoutDuration(j10);
                break;
            case 15:
                InterfaceC0667Od interfaceC0667OdM3418P3 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j11 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setCurrentScreen(interfaceC0667OdM3418P3, string15, string16, j11);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu13 = iInterfaceQueryLocalInterface5 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface5 : new C2261qu(strongBinder5);
                }
                AbstractC2351ss.m9603f(parcel);
                getCurrentScreenName(c2261qu13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu12 = iInterfaceQueryLocalInterface6 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface6 : new C2261qu(strongBinder6);
                }
                AbstractC2351ss.m9603f(parcel);
                getCurrentScreenClass(c2261qu12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    c0178Du = iInterfaceQueryLocalInterface7 instanceof InterfaceC2583xu ? (InterfaceC2583xu) iInterfaceQueryLocalInterface7 : new C0178Du(strongBinder7);
                }
                AbstractC2351ss.m9603f(parcel);
                setInstanceIdProvider(c0178Du);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu11 = iInterfaceQueryLocalInterface8 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface8 : new C2261qu(strongBinder8);
                }
                AbstractC2351ss.m9603f(parcel);
                getCachedAppInstanceId(c2261qu11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu10 = iInterfaceQueryLocalInterface9 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface9 : new C2261qu(strongBinder9);
                }
                AbstractC2351ss.m9603f(parcel);
                getAppInstanceId(c2261qu10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu9 = iInterfaceQueryLocalInterface10 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface10 : new C2261qu(strongBinder10);
                }
                AbstractC2351ss.m9603f(parcel);
                getGmpAppId(c2261qu9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu8 = iInterfaceQueryLocalInterface11 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface11 : new C2261qu(strongBinder11);
                }
                AbstractC2351ss.m9603f(parcel);
                generateEventId(c2261qu8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j12 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                beginAdUnitExposure(string17, j12);
                break;
            case 24:
                String string18 = parcel.readString();
                long j13 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                endAdUnitExposure(string18, j13);
                break;
            case 25:
                InterfaceC0667Od interfaceC0667OdM3418P4 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                long j14 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityStarted(interfaceC0667OdM3418P4, j14);
                break;
            case 26:
                InterfaceC0667Od interfaceC0667OdM3418P5 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityStopped(interfaceC0667OdM3418P5, j15);
                break;
            case 27:
                InterfaceC0667Od interfaceC0667OdM3418P6 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                long j16 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityCreated(interfaceC0667OdM3418P6, bundle5, j16);
                break;
            case 28:
                InterfaceC0667Od interfaceC0667OdM3418P7 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                long j17 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityDestroyed(interfaceC0667OdM3418P7, j17);
                break;
            case 29:
                InterfaceC0667Od interfaceC0667OdM3418P8 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityPaused(interfaceC0667OdM3418P8, j18);
                break;
            case 30:
                InterfaceC0667Od interfaceC0667OdM3418P9 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivityResumed(interfaceC0667OdM3418P9, j19);
                break;
            case 31:
                InterfaceC0667Od interfaceC0667OdM3418P10 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu7 = iInterfaceQueryLocalInterface12 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface12 : new C2261qu(strongBinder12);
                }
                long j20 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                onActivitySaveInstanceState(interfaceC0667OdM3418P10, c2261qu7, j20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu6 = iInterfaceQueryLocalInterface13 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface13 : new C2261qu(strongBinder13);
                }
                long j21 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                performAction(bundle6, c2261qu6, j21);
                break;
            case 33:
                int i3 = parcel.readInt();
                String string19 = parcel.readString();
                InterfaceC0667Od interfaceC0667OdM3418P11 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                InterfaceC0667Od interfaceC0667OdM3418P12 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                InterfaceC0667Od interfaceC0667OdM3418P13 = InterfaceC0667Od.a.m3418P(parcel.readStrongBinder());
                AbstractC2351ss.m9603f(parcel);
                logHealthData(i3, string19, interfaceC0667OdM3418P11, interfaceC0667OdM3418P12, interfaceC0667OdM3418P13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c2675zu3 = iInterfaceQueryLocalInterface14 instanceof InterfaceC2491vu ? (InterfaceC2491vu) iInterfaceQueryLocalInterface14 : new C2675zu(strongBinder14);
                }
                AbstractC2351ss.m9603f(parcel);
                setEventInterceptor(c2675zu3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c2675zu2 = iInterfaceQueryLocalInterface15 instanceof InterfaceC2491vu ? (InterfaceC2491vu) iInterfaceQueryLocalInterface15 : new C2675zu(strongBinder15);
                }
                AbstractC2351ss.m9603f(parcel);
                registerOnMeasurementEventListener(c2675zu2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c2675zu = iInterfaceQueryLocalInterface16 instanceof InterfaceC2491vu ? (InterfaceC2491vu) iInterfaceQueryLocalInterface16 : new C2675zu(strongBinder16);
                }
                AbstractC2351ss.m9603f(parcel);
                unregisterOnMeasurementEventListener(c2675zu);
                break;
            case 37:
                HashMap mapM9599b = AbstractC2351ss.m9599b(parcel);
                AbstractC2351ss.m9603f(parcel);
                initForTests(mapM9599b);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu5 = iInterfaceQueryLocalInterface17 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface17 : new C2261qu(strongBinder17);
                }
                int i4 = parcel.readInt();
                AbstractC2351ss.m9603f(parcel);
                getTestFlag(c2261qu5, i4);
                break;
            case 39:
                boolean zM9605h6 = AbstractC2351ss.m9605h(parcel);
                AbstractC2351ss.m9603f(parcel);
                setDataCollectionEnabled(zM9605h6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu4 = iInterfaceQueryLocalInterface18 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface18 : new C2261qu(strongBinder18);
                }
                AbstractC2351ss.m9603f(parcel);
                isDataCollectionEnabled(c2261qu4);
                break;
            case 41:
            case 47:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j22 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                clearMeasurementEnabled(j22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setConsent(bundle8, j23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                AbstractC2351ss.m9603f(parcel);
                setConsentThirdParty(bundle9, j24);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2261qu3 = iInterfaceQueryLocalInterface19 instanceof InterfaceC2076mu ? (InterfaceC2076mu) iInterfaceQueryLocalInterface19 : new C2261qu(strongBinder19);
                }
                AbstractC2351ss.m9603f(parcel);
                getSessionId(c2261qu3);
                break;
            case 48:
                Intent intent = (Intent) AbstractC2351ss.m9598a(parcel, Intent.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 49:
                Bundle bundle10 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                setDefaultEventParametersWithBackfill(bundle10);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
