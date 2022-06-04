class Solution {
    public int catalan(int n, int[] dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = ans + catalan(i, dp) * catalan(n - 1 - i, dp);
        }
        
        return dp[n] = ans;
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return catalan(n, dp);
    }
}