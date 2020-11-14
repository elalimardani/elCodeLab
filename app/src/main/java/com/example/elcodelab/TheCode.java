package com.example.elcodelab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TheCode extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_code);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentContainer, new HomeFragment());
        ft.commit();
    }



    //Camera Intent - With Permissions check and Request
    public void openSayCheese(View view){
        Intent intent = new Intent(this, SayCheese.class);
        startActivity(intent);
    }


    //Animations page
    public void openAnimations(View view){
        Intent intent = new Intent(this, Animations.class);
        startActivity(intent);
    }

    //GoogleMaps Intent
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


    //Data Sharing Intent
    public void galleryRequest(View view){
        Intent intent = new Intent(this, GalleryRequest.class);
        startActivity(intent);
    }

}