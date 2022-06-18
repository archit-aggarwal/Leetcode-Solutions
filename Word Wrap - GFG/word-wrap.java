// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int helper(int idx, int rem, int len, int[] nums, int[][] dp){
        if(idx == nums.length) return 0;
        if(dp[idx][rem] != -1) return dp[idx][rem];
        
        int newRem = (rem == len) ? rem - nums[idx] : rem - nums[idx] - 1;
        int sameLine = (nums[idx] < rem) ? helper(idx + 1, newRem, len, nums, dp)
                        : Integer.MAX_VALUE;
        
        int diffLine = (rem * rem) + helper(idx + 1, len - nums[idx], len, nums, dp);
        return dp[idx][rem] = Math.min(sameLine, diffLine);
    }
    
    public int solveWordWrap (int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[0].length; j++)
                dp[i][j] = -1;
                
        return helper(0, k, k, nums, dp);
    }
}