package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.xbrowser.play.R;

public class GenQrCodeActivity extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_gen_qrcode);

        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");

        int dimension = (int) getResources().getDimension(R.dimen.gen_qrcode_size);

        try {
            final Bitmap bitmap = new BarcodeEncoder().encodeBitmap(intent.getStringExtra("text"), BarcodeFormat.QR_CODE, dimension, dimension);
            ImageView imageView = (ImageView) findViewById(R.id.gen_qrcode);
            imageView.setImageBitmap(bitmap);
            imageView.setClickable(true);
            imageView.setOnClickListener(view -> saveBitmapToGallery(bitmap, title));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, R.string.toast_save_qrcode, Toast.LENGTH_SHORT).show();
    }

    public final void saveBitmapToGallery(Bitmap bitmap, String str) {
        MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, str, "description");
        Toast.makeText(this, R.string.toast_image_had_saved_to_pictures, Toast.LENGTH_SHORT).show();
    }
}
