class Solution {
    public int helper(int row, int col, int[][] grid, int[][] dp){
        // Negative Base Case: Out of the Grid
        if(row >= grid.length || col >= grid[0].length) 
            return Integer.MAX_VALUE;
                
        // Positive Base Case: Destination is Reached
        if(row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
                
        if(dp[row][col] != -1) return dp[row][col];

        int horizontal = helper(row, col + 1, grid, dp); 
        int vertical = helper(row + 1, col, grid, dp);
        
        return dp[row][col] = Math.min(horizontal, vertical) + grid[row][col];
    }
    
    public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length + 1][grid[0].length + 1];
            for(int i=0; i<=grid.length; i++){
                for(int j=0; j<=grid[0].length; j++){
                    dp[i][j] = -1;
                }
            }
            
            return helper(0, 0, grid, dp);
    }
}