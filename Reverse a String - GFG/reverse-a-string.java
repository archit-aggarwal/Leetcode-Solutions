// { Driver Code Starts
// Initial template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.revStr(S));
        }
    }
}// } Driver Code Ends


class Solution {
    static String revStr(String str) {
        // O(N ^ 2) Time
        // String res = "";
        // for(int i=str.length() - 1; i>=0; i--){
        //     res = res + str.charAt(i);
        // }
        // return res;
        
        // O(N) Time
        char[] arr = new char[str.length()];
        int left = 0, right = str.length() - 1;
        while(left < str.length()){
            arr[left] = str.charAt(right);
            left++; right--;
        }
        String res = new String(arr);
        return res;
    }
}