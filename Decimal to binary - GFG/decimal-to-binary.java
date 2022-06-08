// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int dec) {
	    String bin = "";
	    
	    while(dec > 0){
	        int bit = dec % 2;
	        bin = bin + bit;
	        dec = dec / 2;
	    }
	    
	    // Printing Remainders or Bits in Reverse Order
	    for(int i=bin.length() - 1; i>=0; i--){
	        System.out.print(bin.charAt(i));
	    }
	}
}