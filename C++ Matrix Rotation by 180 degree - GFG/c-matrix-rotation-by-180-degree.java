// { Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.rotate(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void rotate(int[][] mat)
    {
        int row = mat.length, col = mat[0].length; 
        
        // Step 1: Row by Row Reversal
        for(int i=0; i<row; i++){
            
            int left = 0, right = col - 1;
            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                
                left++; right--;
            }
            
        }
        
        // Step 2: Column by Column Reversal
        for(int j=0; j<col; j++){
            
            int left = 0, right = row - 1;
            while(left < right){
                int temp = mat[left][j];
                mat[left][j] = mat[right][j];
                mat[right][j] = temp;
                
                left++; right--;
            }
            
        }
        
        
    }
}