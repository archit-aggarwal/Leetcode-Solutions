class Solution {
    public int findLength(int[] s1, int[] s2) {
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        
        int maxLen = 0;
        for(int i=s1.length-1; i>=0; i--){
            for(int j=s2.length-1; j>=0; j--){
                if(s1[i] == s2[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                
                // else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        
        return maxLen;
    }
}