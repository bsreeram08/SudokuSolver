package com.sree.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PrevSolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_solved);
        SharedPreferences sp = getSharedPreferences("USER",MODE_PRIVATE);
        ListView savedGridsListView = findViewById(R.id.ListViewSudokuGridItems);
        Map<String, ?> allEntries =sp.getAll();
        final ArrayList<String> data = new ArrayList<>();
        final ArrayList<String> date = new ArrayList<>();
        final ArrayList<String> time = new ArrayList<>();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            //Toast.makeText(getApplicationContext(),entry.getKey(),Toast.LENGTH_SHORT).show();
            String[] splitStr = entry.getKey().split("\\s+");
            date.add(splitStr[0]);
            time.add(splitStr[1]+" "+splitStr[2]);
            data.add(entry.getValue().toString());
        }
        SavedListViewAdapter adapter = new SavedListViewAdapter(this,date,time);
        savedGridsListView.setAdapter(adapter);
        savedGridsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(getApplicationContext(),DisplaySavedGrid.class);
                myIntent.putExtra("Date", date.get(position));
                myIntent.putExtra("Time", time.get(position));
                myIntent.putExtra("Data",data.get(position));
                startActivity(myIntent);
            }
        });
    }
}
