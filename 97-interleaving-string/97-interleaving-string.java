class Solution {
    public boolean memo(int i, int j, int k, String s1, String s2, String s3, Boolean[][] dp){
        // Positive Base Case
        if(k == s3.length()){
            // Result is empty
            return true;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        char ch1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char ch2 = (j < s2.length()) ? s2.charAt(j) : 'B';
        
        if(s3.charAt(k) == ch1 && memo(i + 1, j, k + 1, s1, s2, s3, dp) == true){
            return dp[i][j] = true;
        }
        
        if(s3.charAt(k) == ch2 && memo(i, j + 1, k + 1, s1, s2, s3, dp) == true){
            return dp[i][j] = true;
        }
    
        return dp[i][j] = false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return memo(0, 0, 0, s1, s2, s3, dp);
    }
}