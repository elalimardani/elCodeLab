package com.example.elcodelab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

import java.math.BigDecimal;

public class TheCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_code);
    }

    public void openMaps(View view){
        //generate random location
        //these params can be changed to limit the radius
        double MaxLat = 90;
        double MinLat = -90;
        double MaxLon = 180;
        double MinLon = -180;

        BigDecimal dbLon = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lonVal = dbLon.setScale(4, BigDecimal.ROUND_HALF_UP).toString();

        BigDecimal dbLat = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String latVal = dbLat.setScale(4, BigDecimal.ROUND_HALF_UP).toString();

        String stringToParse =  "geo:"+  latVal +", " + lonVal;
        Uri location = Uri.parse(stringToParse);

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(location);
        intent.setPackage("com.google.android.apps.maps");

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }


    public void galleryRequest(View view){
        Intent intent = new Intent(this, GalleryRequest.class);
        startActivity(intent);
    }

}