package p000;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class C0442Ji {

    public static final String f1425b = "Ji";

    public final PrintAttributes f1426a;

    public class a extends PrintDocumentAdapter.LayoutResultCallback {

        public final PrintDocumentAdapter f1427a;

        public final File f1428b;

        public final String f1429c;

        public class C2689a extends PrintDocumentAdapter.WriteResultCallback {
            public C2689a() {
            }

            @Override
            public void onWriteFinished(PageRange[] pageRangeArr) {
                super.onWriteFinished(pageRangeArr);
            }
        }

        public a(PrintDocumentAdapter printDocumentAdapter, File file, String str) {
            this.f1427a = printDocumentAdapter;
            this.f1428b = file;
            this.f1429c = str;
        }

        @Override
        public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z) {
            this.f1427a.onWrite(new PageRange[]{PageRange.ALL_PAGES}, C0442Ji.this.m2043b(this.f1428b, this.f1429c), new CancellationSignal(), new C2689a());
        }
    }

    public C0442Ji(PrintAttributes printAttributes) {
        this.f1426a = printAttributes;
    }

    public final ParcelFileDescriptor m2043b(File file, String str) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            file2.createNewFile();
            return ParcelFileDescriptor.open(file2, 805306368);
        } catch (Exception e) {
            Log.e(f1425b, "Failed to open ParcelFileDescriptor", e);
            return null;
        }
    }

    public void m2044c(PrintDocumentAdapter printDocumentAdapter, File file, String str) {
        printDocumentAdapter.onLayout(null, this.f1426a, null, new a(printDocumentAdapter, file, str), null);
    }
}
