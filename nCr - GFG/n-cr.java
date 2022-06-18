// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int rows, int cols)
    {
        if(cols > rows) return 0;
        if(rows == 0 || rows == cols || cols == 0) return 1;
        
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int n=1; n<=rows; n++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // nC0
            
            for(int k=1; k<n; k++){
                // nCk = n-1Ck-1 + n-1Ck
                int nCk = (prev.get(k) + prev.get(k - 1)) % 1000000007;;
                curr.add(nCk);
            }
            
            curr.add(1); // nCn
            prev = curr;
        }
        
        return prev.get(cols);
    }
}