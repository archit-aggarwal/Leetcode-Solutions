//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.segregateElements(a, n);
            
            for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
            
            System.out.println();
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void approach1(int[] arr){
        int[] res = new int[arr.length]; 
        
        int left = 0;
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] >= 0){
                res[left] = arr[idx];
                left++;
            }
        }
        
        int right = arr.length - 1;
        for(int idx = arr.length - 1; idx >= 0; idx--){
            if(arr[idx] < 0){
                res[right] = arr[idx];
                right--;
            }
        }
        
        for(int idx = 0; idx < arr.length; idx++){
            arr[idx] = res[idx];
        }
    }
    
    public void segregateElements(int arr[], int n)
    {
        approach1(arr);
    }
}