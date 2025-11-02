package p000;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class AbstractC2643z7 {

    public static final String f8175a = "z7";

    public static final Pattern f8176b = Pattern.compile(",");

    public static Map m10991a(Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (decodeHintType != DecodeHintType.CHARACTER_SET && decodeHintType != DecodeHintType.NEED_RESULT_POINT_CALLBACK && decodeHintType != DecodeHintType.POSSIBLE_FORMATS) {
                String strName = decodeHintType.name();
                if (extras.containsKey(strName)) {
                    if (decodeHintType.m36c().equals(Void.class)) {
                        obj = Boolean.TRUE;
                    } else {
                        obj = extras.get(strName);
                        if (!decodeHintType.m36c().isInstance(obj)) {
                            Log.w(f8175a, "Ignoring hint " + decodeHintType + " because it is not assignable from " + obj);
                        }
                    }
                    enumMap.put((EnumMap) decodeHintType, (DecodeHintType) obj);
                }
            }
        }
        Log.i(f8175a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
