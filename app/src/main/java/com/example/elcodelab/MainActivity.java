package com.example.elcodelab;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<PersonReference> personReferencesList;
    private PersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.main_landscape);
        }else{
            setContentView(R.layout.activity_main);

            checkOsVersion();

            recyclerView = findViewById(R.id.refAdapter);
            personReferencesList = References.loadInput(this);

            //if list is empty
            if(personReferencesList == null){
                personReferencesList = new ArrayList<>();
            }

            //implement recyclerView
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            adapter = new PersonAdapter(this, personReferencesList);
            recyclerView.setAdapter(adapter);
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