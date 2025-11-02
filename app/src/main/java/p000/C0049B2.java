package p000;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class C0049B2 {

    public static final String f113d = "B2";

    public final Context f114a;

    public boolean f115b = true;

    public boolean f116c = false;

    public C0049B2(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f114a = activity.getApplicationContext();
    }

    public static void m184c(MediaPlayer mediaPlayer) throws IllegalStateException {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    public static boolean m185d(MediaPlayer mediaPlayer, int i, int i2) throws IllegalStateException {
        Log.w(f113d, "Failed to beep " + i + ", " + i2);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer m186e() throws IllegalStateException, Resources.NotFoundException, IOException, IllegalArgumentException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public final void onCompletion(MediaPlayer mediaPlayer2) throws IllegalStateException {
                C0049B2.m184c(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                return C0049B2.m185d(mediaPlayer2, i, i2);
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f114a.getResources().openRawResourceFd(AbstractC0489Kj.f1579a);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th;
            }
        } catch (IOException e) {
            Log.w(f113d, e);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void m187f() {
        Vibrator vibrator;
        try {
            if (this.f115b) {
                m186e();
            }
            if (this.f116c && (vibrator = (Vibrator) this.f114a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m188g(boolean z) {
        this.f115b = z;
    }
}
