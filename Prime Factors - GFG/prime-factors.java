// { Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        int[] temp = new int[N + 1];
        int idx = 0;
        
        // Prime Factorization
        for(int fact=2; fact<=N; fact++){
            
            // fact is a prime factor of N
            boolean isFactor = false;
            
            while(N % fact == 0){
                N = N / fact;
                isFactor = true;
            }
            
            if(isFactor == true){
                temp[idx] = fact;
                idx++;
            }
        }
        
        int[] res = new int[idx];
        for(int i=0; i<idx; i++){
            res[i] = temp[i];
        }
        return res;
    }
}