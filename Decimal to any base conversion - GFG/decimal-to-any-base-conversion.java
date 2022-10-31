//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int B=sc.nextInt();
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            String ans  = ob.getNumber(B,N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    public static char getRemainder(int remainder){
      if(remainder <= 9) return (char)(remainder + '0');
        
      if(remainder == 10) return 'A';
      if(remainder == 11) return 'B';
      if(remainder == 12) return 'C';
      if(remainder == 13) return 'D';
      if(remainder == 14) return 'E';
      return 'F'; 
    }
    
    static String getNumber(int base, int decimal){
        StringBuilder result = new StringBuilder();
        while(decimal > 0){
            int remainder = decimal % base;
            result.append(getRemainder(remainder));
            decimal = decimal / base;
        }    
        
        return result.reverse().toString(); 
    }
}