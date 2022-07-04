// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                
                int count = 0;
                while(stk.peek() != '('){
                    stk.pop();
                    count++;
                }
                stk.pop(); // Pop Opening Braces
                if(count == 0 || count == 1) return 1;
                
            } else {
                stk.push(s.charAt(i));
            }
        }
        
        return 0;
    }
}
        
