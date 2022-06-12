// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String backtrack(int l, int r, int[] nums, int[][] dp){
        if(l == r) return ("" + (char)('A' + l));
        
        for(int k=l; k<r; k++){
            int cost = dp[l][k] + (nums[l] * nums[k + 1] * nums[r + 1]) + dp[k + 1][r];
            if(cost == dp[l][r]){
                return '(' + backtrack(l, k, nums, dp) + backtrack(k + 1, r, nums, dp) + ')';
            }
        }
        
        return "";
    }
    
    static String matrixChainOrder(int nums[], int N){
        int[][] dp = new int[N][N];
        
        for(int gap=1; gap<N-1; gap++){
            for(int l=0, r=gap; r<N-1; l++, r++){
                
                int minCost = Integer.MAX_VALUE;
                for(int k=l; k<r; k++){
                    int cost = dp[l][k] + (nums[l] * nums[k + 1] * nums[r + 1]) + dp[k + 1][r];
                    minCost = Math.min(minCost, cost);
                }
                
                dp[l][r] = minCost;
            }
        }
        
        return backtrack(0, N-2, nums, dp);
    }
}