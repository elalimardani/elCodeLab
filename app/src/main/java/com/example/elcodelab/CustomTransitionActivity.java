package com.example.elcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomTransitionActivity extends AppCompatActivity{
    boolean colorSwitch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_transition);
    }

    public void goBack(View view){

        finish();
    }

    public void customTransition(View view){
        Transition transition = new CustomTransition();
        transition.setDuration(1500);

        ViewGroup root = findViewById(R.id.rootContainer);
        TextView textView = findViewById(R.id.textView);

        TransitionManager.beginDelayedTransition(root, transition);
        if(!colorSwitch){
            textView.setTextColor(Color.argb(255,2,151,155));
            textView.setTextSize(25);
        }else {
            textView.setTextColor(Color.TRANSPARENT);
            textView.setTextSize(10);
        } this.colorSwitch = !this.colorSwitch;

    }
}