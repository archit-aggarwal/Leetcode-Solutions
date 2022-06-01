// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPrime(N));
        }
    }
}// } Driver Code Ends


class Solution{
    static int isPrime(int N){
        if(N <= 1) return 0;
        
        int sq = (int)Math.sqrt(N);
        
        for(int fact=2; fact<=sq; fact++){
            if(N % fact == 0){
                // Fact is a factor of N
                // N is Composite (not prime)
                return 0;
            }
        }
        
        return 1;
    }
}