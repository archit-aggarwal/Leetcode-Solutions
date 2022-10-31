//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //testcases
        int t =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //size of array
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            long arr[] = new long[(int)n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[(int)i]  =Integer.parseInt(st[(int)i]);
                
           //calling arrange() function
           new Solution().arrange(arr, n);
           
           //printing the elements 
           for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void approach1(long arr[], int n){
        long[] inv = new long[n];
        
        for(int idx = 0; idx < n; idx++){
            inv[idx] = arr[(int)arr[idx]];
        }
        
        for(int idx = 0; idx < n; idx++){
            arr[idx] = inv[idx];
        }
    }
    
    static void approach2(long arr[], int n){
        for(int idx = 0; idx < n; idx++){
            long oldVal = arr[idx] % n;
            long newVal = arr[(int)arr[idx]] % n;
            arr[idx] = oldVal + newVal * n; 
        }
        
        for(int idx = 0; idx < n; idx++){
            arr[idx] = arr[idx] / n;
        }
    }
    
    static void arrange(long arr[], int n)
    {
        // approach1(arr, n);
        approach2(arr, n);
    }
}