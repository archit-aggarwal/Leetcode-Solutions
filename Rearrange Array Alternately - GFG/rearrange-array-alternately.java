//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    public static void minMaxForm(long arr[], int n){
        long[] sorted = new long[n];
        for(int idx = 0; idx < n; idx++) sorted[idx] = arr[idx];
        
        int left = 0, right = arr.length - 1;
        
        for(int idx = 0; idx < n; idx++){
            if(idx % 2 == 1){
                arr[idx] = sorted[left];
                left++;
            } else {
                arr[idx] = sorted[right];
                right--;
            }
        }
    }
    
    public static void rearrange(long arr[], int n){
        minMaxForm(arr, n);
    }
    
}


