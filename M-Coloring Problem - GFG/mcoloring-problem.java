// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    public boolean canColor(int src, boolean graph[][], int color, int[] vis){
        // If any neighbour have same color as my color, hence it cannot happen
        for(int nbr=0; nbr<graph.length; nbr++){
            if(graph[src][nbr] == true && vis[nbr] == color) return false;
        }
        return true;
    }
    
    public boolean helper(int idx, boolean graph[][], int color, int[] vis){
        if(idx == graph.length) return true;
        
        for(int c=0; c<color; c++){
            if(canColor(idx, graph, c, vis) == true){
                vis[idx] = c;
                if(helper(idx + 1, graph, color, vis) == true) 
                    return true;
                vis[idx] = -1;
            }
        }
        
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        return helper(0, graph, m, vis);
    }
}