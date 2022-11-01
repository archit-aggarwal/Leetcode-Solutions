//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
  
    String calc_Sum(int a[], int n, int b[], int m)
    {
        StringBuilder res = new StringBuilder();
        int p1 = n - 1, p2 = m - 1, carry = 0;
        
        while(p1 >= 0 || p2 >= 0 || carry > 0){
            int d1 = (p1 < 0) ? 0 : a[p1];
            int d2 = (p2 < 0) ? 0 : b[p2];
            
            int sum = d1 + d2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
            p1--; p2--;
        }
        
        // Deleting the leading zeros
        for(int idx = res.length() - 1; idx >= 0; idx--){
            if(res.charAt(idx) == '0') 
                res.deleteCharAt(idx);
            else break;
        }
        
        if(res.length() == 0) return "0";
        return res.reverse().toString();
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray_N = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray_N];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_N;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    String line2 = br.readLine();
		    String[] ele = line2.trim().split("\\s+");
		    int sizeOfArray_M = Integer.parseInt(ele[0]);
		    
		    int brr [] = new int[sizeOfArray_M];
		    
		    line2 = br.readLine();
		    String[] elements2 = line2.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray_M;i++){
		        brr[i] = Integer.parseInt(elements2[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    String res = obj.calc_Sum(arr, sizeOfArray_N, brr, sizeOfArray_M);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


            


// } Driver Code Ends