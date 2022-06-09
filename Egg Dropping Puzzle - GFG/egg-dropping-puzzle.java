// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}


// } Driver Code Ends


class Solution 
{
    static int eggDrop(int floors, int eggs, int[][] dp){
        if(floors == 0) return 0;
        if(eggs == 1) return floors;
        if(dp[floors][eggs] != -1) return dp[floors][eggs];
        
        int min = floors;
        for(int i=1; i<=floors; i++){
            int eggBreak = eggDrop(i - 1, eggs - 1, dp);
            int eggSurvive = eggDrop(floors - i, eggs, dp);
            
            min = Math.min(min, 1 + Math.max(eggBreak, eggSurvive));
        }
        
        return dp[floors][eggs] = min;
    }
    
    static int eggDrop(int eggs, int floors) 
    {
         int[][] dp = new int[floors + 1][eggs + 1];
         for(int i=0; i<=floors; i++){
             for(int j=0; j<=eggs; j++){
                 dp[i][j] = -1;
             }
         }
         
         return eggDrop(floors, eggs, dp);
    }
}