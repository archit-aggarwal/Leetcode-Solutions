// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int N) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        int idx = s.length(), len = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            for(int j=s.length()-1; j>=0; j--){
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                
                if(ch1 == ch2 && i != j)
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                
                if(Math.min(i, j) + dp[i][j] >= Math.max(i, j)){
                    // Overlapping Substrings
                    dp[i][j] = 0;
                }
                
                if(dp[i][j] >= len){
                    idx = i;
                    len = dp[i][j];
                }
                
                // else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        if(len == 0) return "-1";
        return s.substring(idx, idx + len);
    }
};