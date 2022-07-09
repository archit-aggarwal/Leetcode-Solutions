// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    StringBuilder topo = new StringBuilder("");
    public void DFS(char src, ArrayList<Character>[] adj, boolean[] vis){
        if(vis[src - 'a'] == true) return;
        vis[src - 'a'] = true;
        
        for(Character nbr: adj[src - 'a']){
            DFS(nbr, adj, vis);
        }
        
        topo.append(src);
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<Character>[] adj = new ArrayList[26];
        for(int i=0; i<26; i++) adj[i] = new ArrayList<>();
        
        for(int i=0; i<N-1; i++){
            String a = dict[i], b = dict[i + 1];
            int j = 0;
            while(j < a.length() && j < b.length()){
                if(a.charAt(j) != b.charAt(j)){
                    adj[a.charAt(j) - 'a'].add(b.charAt(j));
                    break;
                }
                j++;
            }
        }
        
        boolean[] vis = new boolean[26];
        for(char ch='a'; ch<='z'; ch++) DFS(ch, adj, vis);
        return topo.reverse().toString();
    }
}