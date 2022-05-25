// { Driver Code Starts
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
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String input)
    {
        String output = "";
        int start = 0, end = 0;
        
        // Exploring Each Word
        while(start < input.length()){
            
            // Taking the End Pointer to the next Space or End of String
            while(end < input.length() && input.charAt(end) != '.'){
                end++;
            }
            
            // Inserting the word in reverse order [end - 1, start]
            for(int i=end-1; i>=start; i--){
                output = output + input.charAt(i);
            }
            
            // Adding Space after every word but not for the last word
            if(end < input.length()){
                output = output + '.';    
            }
            
            // Going to the next word
            end++;
            start = end;
        }
        
        return output;
    }
}