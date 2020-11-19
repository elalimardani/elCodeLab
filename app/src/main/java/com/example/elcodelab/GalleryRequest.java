package com.example.elcodelab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_request);
    }

    public void requestFiles(View view){
        Intent  mRequestFileIntent = new Intent(Intent.ACTION_PICK);
        mRequestFileIntent.setType("image/*");
        startActivityForResult(mRequestFileIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!=RESULT_OK){
            return;
        }else {
            Uri returnUri = data.getData();
            String mimeType = getContentResolver().getType(returnUri);
            //textView.setText(mimeType + " : " + returnUri.toString());

            TextView textViewName = findViewById(R.id.textViewName);
            TextView textViewType = findViewById(R.id.textViewType);
            TextView textViewSize = findViewById(R.id.textViewSize);
            ImageView imageView = findViewById(R.id.imageView);

            Cursor returnCursor = getContentResolver().query(returnUri, null, null, null, null);

            int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
            int sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);
            Bitmap imageFile = null;
            if(returnUri!=null) {
                try {
                    imageFile = MediaStore.Images.Media.getBitmap(this.getContentResolver(), returnUri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            returnCursor.moveToFirst();
            textViewType.setText("File Type: " + mimeType);
            textViewName.setText("File Name:\n" + returnCursor.getString(nameIndex));
            textViewSize.setText("File Size: " + Long.toString(returnCursor.getLong(sizeIndex)));
            imageView.setImageBitmap(imageFile);
        }
    }


}