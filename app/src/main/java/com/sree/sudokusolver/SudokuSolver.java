package com.sree.sudokusolver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
class MyBundle implements Serializable {
    public int row;
    public int col;
    public boolean val;
    public MyBundle(int r,int c,boolean v){
        this.row=r;
        this.col=c;
        this.val=v;
    }
}
public class SudokuSolver implements Serializable{
    public int grid[][] = new int[9][9];
    public int[][] getGrid(){
        return grid;
    }
    public void setGrid(int grid[][]){
        for(int iterR=0;iterR<9;iterR++)
        {
            System.arraycopy(grid[iterR], 0, this.grid[iterR], 0, 9);
        }
    }
    public boolean inBox(int startRow, int startCol, int num)
    {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + startRow][col + startCol] == num)
                    return true;
        return false;
    }
    public boolean inCol(int col, int num)
    {
        for (int row = 0; row < 9; row++)
            if (grid[row][col] == num)
                return true;
        return false;
    }
    public boolean inRow(int row, int num)
    {
        for (int col = 0; col < 9; col++)
            if (grid[row][col] == num)
                return true;
        return false;
    }
    public boolean isSafe(int row, int col, int num)
    {
        return !inBox(row - row % 3, col - col % 3, num) && !inCol(col, num) && !inRow(row, num);
    }
    public MyBundle findUnAssignedGrid(int SearchRow,int SearchCol)
    {
        for (SearchRow=0; SearchRow < 9; SearchRow++)
            for (SearchCol=0; SearchCol < 9; SearchCol++)
                if (grid[SearchRow][SearchCol] == 0)
                {
                    return new MyBundle(SearchRow,SearchCol,true);
                }
        return new MyBundle(-1,-1,false);
    }
    public boolean sudokusolver()
    {
        int row=0,col=0;
        MyBundle mb = findUnAssignedGrid(row,col);
        if (!mb.val)
        {
            return true;
        }
        for (int num = 1; num < 10; num++)
        {
            if (isSafe(mb.row,mb.col, num))
            {
                grid[mb.row][mb.col] = num;
                if (sudokusolver())
                {
                    return true;
                }
                grid[mb.row][mb.col] = 0;
            }
        }
        return false;
    }
    /*
    public boolean findUnAssignedGrid()
    {
        for (; SearchRow < 9; SearchRow++)
            for (; SearchCol < 9; SearchCol++)
                if (grid[SearchRow][SearchCol] == 0)
                    return true;
        return false;
    }
    public boolean sudokusolver()
    {
        if (!findUnAssignedGrid())
        {
            return true;
        }
        for (int num = 1; num < 10; num++)
        {
            if (isSafe(SearchRow,SearchCol, num))
            {
                grid[SearchRow][SearchCol] = num;
                if (sudokusolver())
                {
                    return true;
                }
                grid[SearchRow][SearchCol] = 0;
            }
        }
        return false;
    }*/
    public boolean isValidRow(int row)
    {
        Set<Integer> s = new HashSet<>();
        for (int col = 0; col < 9; col++)
        {
            if (grid[row][col] != 0)
            {
                if (!s.add(grid[row][col]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidCol(int col)
    {
        Set<Integer> s = new HashSet<>();
        for (int row = 0; row < 9; row++)
        {
            if (grid[row][col] != 0)
            {
                if (!s.add(grid[row][col]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSubSquare()
    {
        for (int row = 0; row < 9; row = row + 3)
        {
            for (int col = 0; col < 9; col = col + 3)
            {
                Set<Integer> s = new HashSet<>();
                for (int r = row; r < row + 3; r++)
                {
                    for (int c = col; c < col + 3; c++)
                    {
                        if (grid[r][c] != 0)
                        {
                            if (!s.add(grid[r][c]))
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isProper()
    {
        for (int iter = 0; iter < 9; iter++)
        {
            if (!isValidRow(iter) || !isValidCol(iter))
            {
                return false;
            }
        }
        return isValidSubSquare();
    }

}
