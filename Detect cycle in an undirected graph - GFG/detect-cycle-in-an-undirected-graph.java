// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    public boolean DFS(int src, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] parent){
        parent[src] = par;
        if(vis[src] == true){
            
            int ptr = src;
            do{
               System.out.print(ptr);
               ptr = parent[ptr];
            } while(ptr != src);
            
            System.out.println(src);
            
            return true;
        }
        
        vis[src] = true;
        for(Integer nbr: adj.get(src)){
            if(nbr != par && DFS(nbr, src, adj, vis, parent) == true) 
                return true;
        }
        
        return false;
    }
    
    public static class Pair{
        int src;
        int par;
        
        Pair(int src, int par){
            this.src = src;
            this.par = par;
        }
    }
    
    public boolean BFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        
        while(q.size() > 0){
            Pair front = q.remove();
            src = front.src;
            int par = front.par;
            
            if(vis[src] == true) return true; // Cycle Detected
            vis[src] = true;
            
            for(Integer nbr: adj.get(src)){
                if(nbr != par) q.add(new Pair(nbr, src));
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(vis[i] == false && BFS(i, adj, vis) == true) return true;
        }
        
        return false;
    }
}