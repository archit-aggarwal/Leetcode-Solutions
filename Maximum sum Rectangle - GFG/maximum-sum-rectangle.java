// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kadane(int[] arr){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0; i< arr.length; i++){
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    
    int maximumSumRectangle(int R, int C, int mat[][]) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<R; i++){
            int[] pref = new int[C];
            for(int j=i; j<R; j++){
                for(int c=0; c<C; c++){
                    pref[c] += mat[j][c];
                }
                maxSum = Math.max(maxSum, kadane(pref));
            }
            
        }
        
        return maxSum;
    }
};