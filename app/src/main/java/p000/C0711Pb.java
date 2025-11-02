package p000;

import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class C0711Pb extends AbstractC0757Qb {
    public static boolean m3543o(Transition transition) {
        return (AbstractC0757Qb.m3651e(transition.getTargetIds()) && AbstractC0757Qb.m3651e(transition.getTargetNames()) && AbstractC0757Qb.m3651e(transition.getTargetTypes())) ? false : true;
    }

    @Override
    public void mo3544a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override
    public void mo3545b(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override
    public boolean mo3546c(Object obj) {
        return obj instanceof Transition;
    }

    @Override
    public Object mo3547f(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override
    public void mo3548h(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override
    public void mo3549i(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo3549i(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m3543o(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i < size) {
            transition.addTarget((View) arrayList2.get(i));
            i++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }

    @Override
    public void mo3550k(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).addListener(new a(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override
    public void mo3551n(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            mo3549i(transitionSet, arrayList, arrayList2);
        }
    }

    public class a implements Transition.TransitionListener {

        public final Object f2122a;

        public final ArrayList f2123b;

        public final Object f2124c;

        public final ArrayList f2125d;

        public final Object f2126e;

        public final ArrayList f2127f;

        public a(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2122a = obj;
            this.f2123b = arrayList;
            this.f2124c = obj2;
            this.f2125d = arrayList2;
            this.f2126e = obj3;
            this.f2127f = arrayList3;
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override
        public void onTransitionStart(Transition transition) {
            Object obj = this.f2122a;
            if (obj != null) {
                C0711Pb.this.mo3549i(obj, this.f2123b, null);
            }
            Object obj2 = this.f2124c;
            if (obj2 != null) {
                C0711Pb.this.mo3549i(obj2, this.f2125d, null);
            }
            Object obj3 = this.f2126e;
            if (obj3 != null) {
                C0711Pb.this.mo3549i(obj3, this.f2127f, null);
            }
        }

        @Override
        public void onTransitionCancel(Transition transition) {
        }

        @Override
        public void onTransitionPause(Transition transition) {
        }

        @Override
        public void onTransitionResume(Transition transition) {
        }
    }
}
