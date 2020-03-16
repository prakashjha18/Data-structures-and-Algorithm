// Number of Islands
// Medium

// 4305

// 158

// Add to List

// Share
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input:
// 11110
// 11010
// 11000
// 00000

// Output: 1
// Example 2:

// Input:
// 11000
// 11000
// 00100
// 00011

// Output: 3

import java.io.*;
import java.util.*;

class NumberOfIslands {

    // Implement your solution by completing the below function
    public int numIslands(char[][] grid) {
        if( (grid == null)){
            return 0;
        }
        int row = grid.length;
        if(row ==0){
            return 0;
        }
        int col = grid[0].length;
        int res = 0;
        for(int i =0 ; i < row ; i++){
            for(int j =0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    res++;
                    updateGrid(grid, i, j);
                }
            }
        }  
        return res;
    }
    static void updateGrid(char [][] grid, int row, int col){
        if(row>=0 && row < grid.length && col >=0 && col <grid[0].length){
            if(grid[row][col] == '1'){
                grid[row][col] = 0;
                updateGrid(grid, row+1,col);
                updateGrid(grid, row-1,col);
                updateGrid(grid, row,col+1);
                updateGrid(grid, row,col-1);
            }            
        }else{
            return;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        char[][] grid = new char[rows][columns];

        for (int i = 0; i < rows; ++i) {
            String s = scanner.next();
            for (int j = 0; j < columns; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }
        scanner.close();
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}
