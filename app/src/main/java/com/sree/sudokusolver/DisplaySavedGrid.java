package com.sree.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class DisplaySavedGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_saved_grid);
        GridView displayGridView = findViewById(R.id.SudokuGridView_Saved);
        displayGridView.setNumColumns(9);
        List<String> list ;
        String Data_Combined = getIntent().getStringExtra("Data");
        String Date = getIntent().getStringExtra("Date");
        String Time = getIntent().getStringExtra("Time");
        String DatawithNull[] = Data_Combined.split("");
        String[] Data = Arrays.copyOfRange(DatawithNull, 1, DatawithNull.length);
        //Toast.makeText(getApplicationContext(),Data_Combined,Toast.LENGTH_LONG).show();
        list = Arrays.asList(Data);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.display_item_grid,list);
        displayGridView.setAdapter(adapter);
        TextView date,time;
        date = findViewById(R.id.saved_date);
        time = findViewById(R.id.saved_time);
        date.setText(Date);
        time.setText(Time);
        Button MainPage = findViewById(R.id.Savedgridmainpagebtn);
        MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
