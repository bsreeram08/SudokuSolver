package com.sree.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newSolve,prevSOlve;
        final TextView SSolver = findViewById(R.id.text_view_id);
        final Random rn =new Random();
        SSolver.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    SSolver.setTextColor(Color.rgb(rn.nextInt(255),rn.nextInt(255),rn.nextInt(255)));
                    return true;
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    SSolver.setTextColor(Color.rgb(rn.nextInt(255),rn.nextInt(255),rn.nextInt(255)));
                    return true;
                }
                return false;
            }
        });/*
        final LinearLayout ll = findViewById(R.id.mainPageLL);
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    ll.setBackgroundColor(Color.rgb(rn.nextInt(255),rn.nextInt(255),rn.nextInt(255)));
                    return true;
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    ll.setBackgroundColor(Color.rgb(rn.nextInt(255),rn.nextInt(255),rn.nextInt(255)));
                    return true;
                }
                return false;
            }
        });*/
        newSolve = findViewById(R.id.newSolve);
        prevSOlve = findViewById(R.id.prevSolve);
        newSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"NewSolve",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this, Gird_InputPage.class);
                startActivity(myIntent);
            }
        });
        prevSOlve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"PrevSolve",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
