package com.sree.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class GridDisplayPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_display_page);
        SudokuSolver sudokuSolver = (SudokuSolver) getIntent().getSerializableExtra("sudukuSolver");
        int [][]SolutionGrid = sudokuSolver.getGrid();
        GridView displayGridView = findViewById(R.id.SudokuGridView);
        displayGridView.setNumColumns(9);
        List<String> list = new ArrayList<>();
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
    }
}
