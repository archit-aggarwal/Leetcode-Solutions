// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution {
    boolean isCelebrity(int idx, int[][] arr, int N){
        // ROW => 0s
        for(int i=0; i<N; i++){
            // We Know Someone -> We Cannot be a celebrity
            if(i != idx && arr[idx][i] == 1) return false;
        }
        
        // COL => 1s
        for(int i=0; i<N; i++){
            // Someone Does not Know us -> We Cannot be a Celebrity
            if(i != idx && arr[i][idx] == 0) return false;
        }
        
        return true;
    }
    
    int celebrity(int M[][], int N)
    {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            q.add(i); // Everyone is a potential celebrity
        }
        
        while(q.size() > 1){
            int row = q.remove();
            int col = q.remove();
            if(M[row][col] == 0){
                // row does not know col -> col is not a celebrity
                q.add(row);
            } else {
                // row knows col -> row is not a celebrity
                q.add(col);
            }
        }
        
        if(isCelebrity(q.peek(), M, N) == true){
            return q.remove();
        }
        
        return -1; // No Celebrity Found
    }
}