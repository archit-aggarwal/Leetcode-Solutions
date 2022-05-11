// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    public int perfectSum(int arr[],int n, int target) 
	{ 
	    int[][] dp = new int[n + 1][target + 1];
	    dp[0][0] = 1; // Empty Subset to form 0 Target
	    
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=target; j++){
	            int no = dp[i - 1][j]; // No Call
	            int yes = (j >= arr[i - 1]) ? dp[i - 1][j - arr[i - 1]] : 0;
	            
	            dp[i][j] = (no + yes) % 1000000007;
	        }
	    }
	    
	    return dp[n][target];
	} 
}