// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}// } Driver Code Ends




class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i=0; i<line.length(); i++){
            char ch = line.charAt(i);
            
            if(freq.containsKey(ch) == true){
                int oldFreq = freq.get(ch);
                freq.put(ch, oldFreq + 1);
            } else {
                freq.put(ch, 1);
            }
        }
        
        char ans = 'a';
        int max = 0;
        
        for(Character key: freq.keySet()){
            int value = freq.get(key);
            
            if((value > max) || (value == max && key < ans)){
                ans = key;
                max = value;
            }
        }
        
        return ans;
    }
    
}