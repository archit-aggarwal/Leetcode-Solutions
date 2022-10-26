//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long merge(long[] arr, int left, int mid, int right){
        long[] res = new long[right - left + 1];
        int idx1 = left, idx2 = mid + 1, idx3 = 0;
        
        long invCount = 0;
        while(idx1 <= mid && idx2 <= right){
            if(arr[idx1] <= arr[idx2]){
                res[idx3] = arr[idx1];
                idx1++; idx3++;
            } else {
                invCount += (mid - idx1 + 1);
                res[idx3] = arr[idx2];
                idx2++; idx3++;
            }
        }

        while(idx1 <= mid){
            res[idx3] = arr[idx1];
            idx1++; idx3++;
        }

        while(idx2 <= right){
            res[idx3] = arr[idx2];
            idx2++; idx3++;
        }

        for(int idx = left; idx <= right; idx++){
            arr[idx] = res[idx - left];    
        }
        
        return invCount;
    }
    
    static long mergeSort(long nums[], int l, int r)
    {
        if(l == r) return 0;

        int mid = (l + r) / 2;
        long left = mergeSort(nums, l, mid);
        long right = mergeSort(nums, mid + 1, r);
        long curr = merge(nums, l, mid, r);
        return left + curr + right;
    }
    
    static long inversionCount(long nums[], long N) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}