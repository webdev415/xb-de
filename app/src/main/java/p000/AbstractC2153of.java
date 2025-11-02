package p000;

public abstract class AbstractC2153of {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class m8963a(InterfaceC2246qf interfaceC2246qf) {
        AbstractC0116Ce.m476e(interfaceC2246qf, "<this>");
        Class clsMo1674a = ((InterfaceC0373I4) interfaceC2246qf).mo1674a();
        if (!clsMo1674a.isPrimitive()) {
            AbstractC0116Ce.m474c(clsMo1674a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsMo1674a;
        }
        String name = clsMo1674a.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsMo1674a = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsMo1674a = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsMo1674a = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsMo1674a = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsMo1674a = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsMo1674a = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsMo1674a = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsMo1674a = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsMo1674a = Short.class;
                    break;
                }
                break;
        }
        AbstractC0116Ce.m474c(clsMo1674a, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsMo1674a;
    }
}
