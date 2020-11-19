package com.example.elcodelab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class References extends AppCompatActivity {


    public static SharedPreferences sharedPreferences;
    private Button submitBtn;
    private EditText name;
    private RatingBar ratingBar;

    private RecyclerView recyclerView;

    private PersonAdapter adapter;

    private List<PersonReference> personReferencesList;


    public static final String KEY = "com.example.elcodelab_preferences";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        name = findViewById(R.id.personName);
        ratingBar = findViewById(R.id.ratingBar);
        submitBtn =  findViewById(R.id.buttonSubmit);
        recyclerView = findViewById(R.id.refAdapter);

        personReferencesList = loadInput(this);

        //if list is empty
        if(personReferencesList == null){
            personReferencesList = new ArrayList<>();
        }

        //implement recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter(this, personReferencesList);
        recyclerView.setAdapter(adapter);

        //listener for submit button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonReference personReference = new PersonReference(name.getText().toString(),ratingBar.getRating());
                personReferencesList.add(personReference);
                //saveInput(getApplicationContext(),personReferencesList);
                Gson gson = new Gson();
                String jsonString = gson.toJson(personReferencesList);

                sharedPreferences = getSharedPreferences(KEY, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY, jsonString);
                editor.apply();
                Collections.reverse(personReferencesList);
                adapter.setPersonReferenceList(personReferencesList);
            }
        });

        //


    }

    //method to save data into sharedPreferences:
    public static void saveInput(Context context, List<PersonReference> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY, jsonString);
        editor.apply();
    }


    //method to load data from sharedPreferences:
    public  static List<PersonReference> loadInput(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = sharedPreferences.getString(KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<PersonReference>>() {}.getType();
        List<PersonReference> personReferenceList = gson.fromJson(jsonString, type);
        return personReferenceList;
    }


}