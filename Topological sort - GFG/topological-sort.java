// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    static int[] BFS(int n, ArrayList<ArrayList<Integer>> adj){
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
        
        
        int[] order = new int[n];
        int idx = 0;
        
        while(q.size() > 0){
            int src = q.remove();
            order[idx++] = src;
            
            for(Integer nbr: adj.get(src)){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        return order;
    }
    
    static int[] topo;
    static int idx;
    static void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        if(vis[src] == true) return;
        vis[src] = true;
        
        for(Integer nbr: adj.get(src)){
            DFS(nbr, adj, vis);
        }
        
        topo[idx--] = src;
    }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) 
    {
        idx = n - 1;
        topo = new int[n];
        boolean[] vis = new boolean[n];
        
        // Multisource DFS
        for(int i=0; i<n; i++) DFS(i, adj, vis);
        
        return topo;
    }
}
