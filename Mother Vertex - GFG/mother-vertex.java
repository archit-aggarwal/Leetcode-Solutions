// { Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    int[] topo;
    int idx;
    void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        if(visited[src] == true) return;
        visited[src] = true;
        
        for(Integer nbr: adj.get(src))
            DFS(nbr, adj, visited);
            
        topo[idx--] = src;
    }
    
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        boolean[] vis = new boolean[V];
        topo = new int[V]; idx = V - 1;
        for(int i=0; i<V; i++) DFS(0, adj, vis);
        
        Arrays.fill(vis, false);
        idx = V - 1;
        
        DFS(topo[0], adj, vis);
        for(int i=0; i<V; i++){
            if(vis[i] == false) return -1;
        }
        return topo[0];
    }
}