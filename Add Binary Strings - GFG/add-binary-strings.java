//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        int p1 = A.length() - 1;
        int p2 = B.length() - 1;
        int carry = 0;
        
        StringBuilder res = new StringBuilder();
        while(p1 >= 0 || p2 >= 0 || carry > 0){
            int d1 = (p1 < 0) ? 0 : A.charAt(p1) - '0';
            int d2 = (p2 < 0) ? 0 : B.charAt(p2) - '0';
            
            int sum = d1 + d2 + carry;
            res.append(sum % 2);
            carry = sum / 2;
            p1--; p2--;
        }
        
        // delete the leading zeros
        for(int idx = res.length() - 1; idx >= 0; idx--){
            if(res.charAt(idx) == '0') 
                res.deleteCharAt(idx);
            else break;
        }
        
        if(res.length() == 0) return "0";
        return res.reverse().toString();
    }
}