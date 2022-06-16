class Solution {
    int[][] moves = {{+1, +2}, {+1, -2}, {-1, +2}, {-1, -2}, 
                     {+2, +1}, {+2, -1}, {-2, +1}, {-2, -1}};
    
    public double helper(int n, int k, int r, int c, double[][][] dp){
        if(k == 0) return 1.0;
        if(dp[r][c][k] != -1.0) return dp[r][c][k];
        
        double prob = 0.0;
        for(int m=0; m<8; m++){
            int nr = r + moves[m][0];
            int nc = c + moves[m][1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                prob = prob + ((1.0 / 8.0) * helper(n, k - 1, nr, nc, dp));
            }
        }
        
        return dp[r][c][k] = prob;
    }
    
    public double knightProbability(int n, int k, int r, int c) {
        double[][][] dp = new double[n + 1][n + 1][k + 1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=k; l++){
                    dp[i][j][l] = -1.0;
                }
            }
        }
        
        return helper(n, k, r, c, dp);
    }
}