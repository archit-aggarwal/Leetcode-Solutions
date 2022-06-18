// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int K = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int C = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.printf("%.6f\n" , ob.waterOverflow(K,R,C));
        }
    }
}// } Driver Code Ends


class Solution {
    static double waterOverflow(int K, int R, int C) {
        double[][] pascal = new double[501][501];
        pascal[0][0] = K;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<=i; j++){
                if(pascal[i][j] > 1.0){
                    pascal[i + 1][j] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i + 1][j + 1] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i][j] = 1.0;
                }
            }
        }
        
        return pascal[R - 1][C - 1];
    }
}