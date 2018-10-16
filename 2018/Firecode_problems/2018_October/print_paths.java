// Print paths on a board where you can
// only go down or to the right.

import java.util.*;
import java.util.streams.*;

public ArrayList<String> printPaths(char[][] board){
    ArrayList<String> paths = new ArrayList<>();
    String build = "";
    helper(paths, "", 0, 0, board);
    return paths;
}

public void helper(ArrayList<String> paths, String currPath, int row, int col, char[][] board) {
    // Mark where we are on the string
    if (board.length > row && board[0].length > col) {
        currPath = currPath + board[row][col];   
    }
    
    // If at the end of the board, found a path
    if (board.length == row + 1 && board[0].length == col + 1) {
        paths.add(currPath);
    } else {
        // Explore right
        if (board.length > row) {
            helper(paths, currPath, row + 1, col, board);
        }
        
        // Explore down
        if (board[0].length > col) {
            helper(paths, currPath, row, col + 1, board);
        }
    }
}