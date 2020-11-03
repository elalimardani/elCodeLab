package com.example.elcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.main_landscape);
        }else{
            setContentView(R.layout.activity_main);

            RateFragment rateFragment = new RateFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.rateFragment, rateFragment).addToBackStack(null).commit();

            checkOsVersion();
        }
    }


    public void toGirl(View view){
        Intent intent = new Intent(this, TheGirl.class);
        startActivity(intent);
    }

    public void toCode(View view){
        Intent intent = new Intent(this, TheCode.class);
        startActivity(intent);
    }

    public void toDesign(View view){
        Intent intent = new Intent(this, TheDesign.class);
        startActivity(intent);
    }

    public void toEducation(View view){
        Intent intent = new Intent(this, Education.class);
        startActivity(intent);
    }

    public void toReferences(View view){
        Intent intent = new Intent(this, References.class);
        startActivity(intent);
    }

    public void toConnect(View view){
        Intent intent = new Intent(this, Connect.class);
        startActivity(intent);
    }

    //check OS version
    public void checkOsVersion(){
        //check OS version
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            logger("OS version is lower than Oreo. ");
            Toast.makeText( this, "Time to update buddy!", Toast.LENGTH_LONG).show();
        }else{
            logger("OS version is supported. ");
            Toast.makeText(this, "Thank you for being such good sport!", Toast.LENGTH_LONG).show();
        }
    }



    //log method
    private void logger(String log){
        System.out.println(log + Build.VERSION.SDK_INT);
    }
    }