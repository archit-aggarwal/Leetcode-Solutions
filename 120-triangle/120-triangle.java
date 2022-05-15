class Solution {
    public int helper(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size() - 1){
            // Entire Last Row is the Destination
            return triangle.get(row).get(col);
        }
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int down = helper(triangle, row + 1, col, dp);
        int rightdown = helper(triangle, row + 1, col + 1, dp);
        
        return dp[row][col] = (triangle.get(row).get(col) + Math.min(down, rightdown));
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];  
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(triangle, 0, 0, dp);
    }
}