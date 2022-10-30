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
    public void twoTraversalExtraSpace(int[] arr){
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
    
    public void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
    
    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < 0) continue;
            
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < 0){
                    swap(arr, j, j + 1);
                } else break;
            }
        }
    }
    
    public void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }    
    }
    
    public void merge(int[] arr, int left, int mid, int right){
        int p1 = left; // p1 is first negative element in left array
        while(p1 <= mid && arr[p1] >= 0) p1++;
        
        int p2 = mid + 1; // p2 is first negative element in right array
        while(p2 <= right && arr[p2] >= 0) p2++;
        
        reverse(arr, p1, mid);
        reverse(arr, mid + 1, p2 - 1);
        reverse(arr, p1, p2 - 1);
    }
    
    public void mergeSort(int[] arr, int left, int right){
        if(left == right) return;
        
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    
    public void segregateElements(int arr[], int n) {
        // approach1(arr);
        // approach2(arr);
        mergeSort(arr, 0, n - 1);
    }
}