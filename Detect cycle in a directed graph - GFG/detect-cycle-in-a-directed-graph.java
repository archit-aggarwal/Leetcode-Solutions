// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // -1 -> unvisited, 0 -> Same Path Visited (Preorder), 1 -> Diff Path (Visited)
    public boolean DFS(int src, ArrayList<ArrayList<Integer>> adj, int[] vis){
        if(vis[src] == 0) return true; // Node is visited twice in same paths
        if(vis[src] == 1) return false; // Node is visited twice in diff paths
        
        vis[src] = 0; // Preorder Visit (Same Path)
        for(Integer nbr: adj.get(src)){
            if(DFS(nbr, adj, vis) == true) return true;
        }
        vis[src] = 1; // Postorder Visit (Diff Path)
        return false;
    }
    
    public boolean BFS(int n, ArrayList<ArrayList<Integer>> adj){
        int[] incoming = new int[n];
        for(int src=0; src<adj.size(); src++){
            for(Integer nbr: adj.get(src)){
                incoming[nbr]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        // Multisource Breadth First Traversal
        for(int i=0; i<n; i++){
            if(incoming[i] == 0){
                q.add(i);
            }
        }
        
        
        int visited = 0;
        
        while(q.size() > 0){
            int src = q.remove();
            visited++;
            
            for(Integer nbr: adj.get(src)){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        if(visited == n) return false; 
        // If all nodes are part of topo sort, hence graph is directed acyclic.
        
        return true; // Cycle is found because some nodes were not visited
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        return BFS(V, adj);
    }
}