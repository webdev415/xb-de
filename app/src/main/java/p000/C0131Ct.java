package p000;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C0131Ct {

    public static final Method f323b = m533e();

    public static final Method f324c = m532d();

    public final JobScheduler f325a;

    public C0131Ct(JobScheduler jobScheduler) {
        this.f325a = jobScheduler;
    }

    public static int m530a() {
        Method method = f324c;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(UserHandle.class, null);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    public static int m531c(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) AbstractC1131Yi.m4973i((JobScheduler) context.getSystemService("jobscheduler"));
        return (f323b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) ? jobScheduler.schedule(jobInfo) : new C0131Ct(jobScheduler).m534b(jobInfo, str, m530a(), str2);
    }

    public static Method m532d() {
        try {
            return UserHandle.class.getDeclaredMethod("myUserId", null);
        } catch (NoSuchMethodException unused) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No myUserId method available");
            }
            return null;
        }
    }

    public static Method m533e() {
        try {
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            return null;
        }
    }

    public final int m534b(JobInfo jobInfo, String str, int i, String str2) {
        Method method = f323b;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(this.f325a, jobInfo, str, Integer.valueOf(i), str2);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.f325a.schedule(jobInfo);
    }
}
