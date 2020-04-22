package com.sree.sudokusolver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GridDisplayPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_display_page);
        final SharedPreferences sp = getSharedPreferences("USER",MODE_PRIVATE);
        SudokuSolver sudokuSolver = (SudokuSolver) getIntent().getSerializableExtra("sudukuSolver");
        int [][]SolutionGrid = sudokuSolver.getGrid();
        GridView displayGridView = findViewById(R.id.SudokuGridView);
        displayGridView.setNumColumns(9);
        final List<String> list = new ArrayList<>();
        for (int iterR = 0; iterR < 9; iterR++) {
            for (int iterC = 0; iterC < 9; iterC++) {
                list.add(String.valueOf(SolutionGrid[iterR][iterC]));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.display_item_grid,list);
        displayGridView.setAdapter(adapter);
        Button MainPage = findViewById(R.id.mainPageBtn);
        MainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(myIntent);
            }
        });
        final Button saveGrid = findViewById(R.id.SaveSudokuGrid);
        saveGrid.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                String dateTime =  java.text.DateFormat.getDateTimeInstance().format(new Date());
                String data = String.join("",list);
                editor.putString(dateTime,data);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();
                saveGrid.setText("Saved");
                saveGrid.setEnabled(false);
            }
        });
    }
}
