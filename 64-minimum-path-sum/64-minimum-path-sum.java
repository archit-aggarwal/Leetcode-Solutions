class Solution {
//     public int helper(int row, int col, int[][] grid, int[][] dp){
//         // Negative Base Case: Out of the Grid
//         if(row >= grid.length || col >= grid[0].length) 
//             return Integer.MAX_VALUE;
                
//         // Positive Base Case: Destination is Reached
//         if(row == grid.length - 1 && col == grid[0].length - 1)
//             return grid[row][col];
                
//         if(dp[row][col] != -1) return dp[row][col];

//         int horizontal = helper(row, col + 1, grid, dp); 
//         int vertical = helper(row + 1, col, grid, dp);
        
//         return dp[row][col] = Math.min(horizontal, vertical) + grid[row][col];
//     }
    
    public int minPathSum(int[][] grid) {
            int[] dp = new int[grid[0].length + 1];
            for(int j=0; j<=grid[0].length; j++){
                dp[j] = Integer.MAX_VALUE;
            }
            
            for(int i=grid.length-1; i>=0; i--){
                for(int j=grid[0].length-1; j>=0; j--){
                    if(i == grid.length - 1 && j == grid[0].length - 1){
                        dp[j] = grid[i][j];
                        continue;
                    }
                    
                    dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                }
            }
        
            return dp[0];
    }
}