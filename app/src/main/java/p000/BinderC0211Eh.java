package p000;

import android.os.IBinder;
import java.lang.reflect.Field;
import p000.InterfaceC0667Od;

public final class BinderC0211Eh extends InterfaceC0667Od.a {

    public final Object f525c;

    public BinderC0211Eh(Object obj) {
        this.f525c = obj;
    }

    public static Object m1040Q(InterfaceC0667Od interfaceC0667Od) throws SecurityException {
        if (interfaceC0667Od instanceof BinderC0211Eh) {
            return ((BinderC0211Eh) interfaceC0667Od).f525c;
        }
        IBinder iBinderAsBinder = interfaceC0667Od.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC1085Xi.m4801j(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }

    public static InterfaceC0667Od m1041R(Object obj) {
        return new BinderC0211Eh(obj);
    }
}
