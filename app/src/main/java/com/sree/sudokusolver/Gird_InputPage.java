package com.sree.sudokusolver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class Gird_InputPage extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gird__input_page);
        final Boolean[] checkGrid = {true};
        final SudokuSolver sudokuSolver = new SudokuSolver();
        final GridLayout sudokuGridView = findViewById(R.id.SudokuGridView);
        sudokuGridView.setColumnCount(9);
        sudokuGridView.setRowCount(9);
        GridLayout.LayoutParams grLayoutParams = new GridLayout.LayoutParams();
        grLayoutParams.height=ViewGroup.LayoutParams.WRAP_CONTENT;
        Util util = new Util();
        grLayoutParams.width=ViewGroup.LayoutParams.WRAP_CONTENT;
        final int [][]ids = new int[][] {
                {R.id.rc00,R.id.rc01,R.id.rc02,R.id.rc03,R.id.rc04,R.id.rc05,R.id.rc06,R.id.rc07,R.id.rc08},
                {R.id.rc10,R.id.rc11,R.id.rc12,R.id.rc13,R.id.rc14,R.id.rc15,R.id.rc16,R.id.rc17,R.id.rc18},
                {R.id.rc20,R.id.rc21,R.id.rc22,R.id.rc23,R.id.rc24,R.id.rc25,R.id.rc26,R.id.rc27,R.id.rc28},
                {R.id.rc30,R.id.rc31,R.id.rc32,R.id.rc33,R.id.rc34,R.id.rc35,R.id.rc36,R.id.rc37,R.id.rc38},
                {R.id.rc40,R.id.rc41,R.id.rc42,R.id.rc43,R.id.rc44,R.id.rc45,R.id.rc46,R.id.rc47,R.id.rc48},
                {R.id.rc50,R.id.rc51,R.id.rc52,R.id.rc53,R.id.rc54,R.id.rc55,R.id.rc56,R.id.rc57,R.id.rc58},
                {R.id.rc60,R.id.rc61,R.id.rc62,R.id.rc63,R.id.rc64,R.id.rc65,R.id.rc66,R.id.rc67,R.id.rc68},
                {R.id.rc70,R.id.rc71,R.id.rc72,R.id.rc73,R.id.rc74,R.id.rc75,R.id.rc76,R.id.rc77,R.id.rc78},
                {R.id.rc80,R.id.rc81,R.id.rc82,R.id.rc83,R.id.rc84,R.id.rc85,R.id.rc86,R.id.rc87,R.id.rc88}};
        for(int iterR=0;iterR<9;iterR++){
            for(int iterC=0;iterC<9;iterC++){
                EditText editText = new EditText(this);
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setWidth(Util.pxFromDp(getApplicationContext(), (float) 44.44));
                editText.setHeight(Util.pxFromDp(getApplicationContext(), (float) 44.44));
                editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(1)});
                editText.setLayoutParams(grLayoutParams);
                editText.setId(ids[iterR][iterC]);
                sudokuGridView.addView(editText,new GridLayout.LayoutParams(GridLayout.spec(iterR,GridLayout.CENTER),GridLayout.spec(iterC,GridLayout.CENTER)));
            }
        }
        final int[][] gridData = new int[9][9];
        final Button GridOption = findViewById(R.id.GridOption);
        GridOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //StringBuilder s = new StringBuilder();
                if(checkGrid[0]){
                    for(int iterR=0;iterR<9;iterR++){
                        for(int iterC=0;iterC<9;iterC++){
                            EditText getVal = findViewById(ids[iterR][iterC]);
                            if(getVal.getText().toString().equals(""))
                            {
                                gridData[iterR][iterC]=0;
                            }
                            else{
                                gridData[iterR][iterC]=Integer.parseInt(getVal.getText().toString());
                            }
                            //s.append(gridData[iterR][iterC]);
                        }
                        //s.append("\n");
                    }
                    sudokuSolver.setGrid(gridData);
                    if(sudokuSolver.isProper()){
                        checkGrid[0] =false;
                        GridOption.setText("Solve Sudoku");
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Input Not Proper",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    sudokuSolver.sudokusolver();
                    Intent myIntent = new Intent(Gird_InputPage.this,GridDisplayPage.class);
                    myIntent.putExtra("sudukuSolver", sudokuSolver);
                    startActivity(myIntent);
                }
            }
        });
    }

}
