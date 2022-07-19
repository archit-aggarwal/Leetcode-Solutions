class Solution {
    public int helper(int curr, int total, int j1, int j2, int[] dp){
        if(curr < 0 || curr > j1 + j2) return 0;
        if(curr == total) return dp[curr] = 1;
        if(dp[curr] != -1) return dp[curr];

        dp[curr] = 0;
        
        if(helper(curr + j1, total, j1, j2, dp) == 1) 
            return dp[curr] = 1;

        if(helper(curr - j1, total, j1, j2, dp) == 1) 
            return dp[curr] = 1;

        if(helper(curr + j2, total, j1, j2, dp) == 1) 
            return dp[curr] = 1;

        if(helper(curr - j2, total, j1, j2, dp) == 1) 
            return dp[curr] = 1;

        return dp[curr] = 0;
    }
    
    public boolean canMeasureWater(int j1, int j2, int total) {
        if(j1 + j2 < total) return false;
        int[] dp = new int[j1 + j2 + 1];
        Arrays.fill(dp, -1);
        return (helper(0, total, j1, j2, dp) == 1) ? true : false; 
    }
}