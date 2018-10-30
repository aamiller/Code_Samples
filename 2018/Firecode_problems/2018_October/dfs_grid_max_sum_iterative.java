// DFS to find largest sum path from top left corner to bottom right of grid
// Iterative. Could also utilize a custom class instead of using stacks.

public static int matrixMaxSumDfs(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) { return 0; }
    int[] dimensions = new int[]{grid.length, grid[0].length};
    
    int currMaxSum = Integer.MIN_VALUE;
    
    Stack<Integer> nextRow = new Stack<>();
    Stack<Integer> nextCol = new Stack<>();
    Stack<Integer> currSum = new Stack<>();
    
    // Add first integer
    nextRow.push(0);
    nextCol.push(0);
    currSum.push(grid[0][0]);
    
    int row, col, sum;
    
    while (!nextRow.isEmpty()) {
        row = nextRow.pop();
        col = nextCol.pop();
        sum = currSum.pop();
        
        // If at bottom right corner
        if (row == dimensions[0] - 1 && col == dimensions[1] - 1) {
            currMaxSum = Math.max(currMaxSum, sum);
        } else {
            // Traverse right
            if (col + 1 < dimensions[1]) {
                nextRow.push(row);
                nextCol.push(col + 1);
                currSum.push(sum + grid[row][col + 1]);
            }
            
            // Traverse down
            if (row + 1 < dimensions[0]) {
                nextRow.push(row + 1);
                nextCol.push(col);
                currSum.push(sum + grid[row + 1][col]);
            }
        }
    }
    
    return currMaxSum;
}