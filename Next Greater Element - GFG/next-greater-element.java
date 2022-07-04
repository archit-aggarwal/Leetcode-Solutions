// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] nge = new long[n];
        Arrays.fill(nge, -1);
        
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++){
            
            // Pop All Elements Smaller Than You
            while(stk.size() > 0 && arr[stk.peek()] < arr[i]){
                nge[stk.pop()] = arr[i];
            }
            
            // Push Ourself to Figure out our NGE
            stk.push(i);
        }
        
        return nge;
    } 
}