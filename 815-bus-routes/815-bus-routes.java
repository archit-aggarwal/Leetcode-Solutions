class Solution {
    public static class Pair implements Comparable<Pair>{
        int Stop; // NODE
        int Color; // COLOR (EDGE)
        int Changes;
        
        Pair(int Stop, int Color, int Changes){
            this.Stop = Stop;
            this.Color = Color;
            this.Changes = Changes;
        }
        
        public int compareTo(Pair other){
            return this.Changes - other.Changes;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        
        int n = 0;
        for(int[] route: routes)
            for(int stop: route)
                n = Math.max(n, stop);
        
        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for(int i=0; i<=n; i++) adj[i] = new ArrayList<>();
        
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                int src = routes[i][j];
                int dest = routes[i][(j + 1) % routes[i].length];
                
                adj[src].add(new Pair(dest, i, 0));
                adj[dest].add(new Pair(src, i, 0));
            }
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(source, routes.length, 0));
        
        int[][] vis = new int[n + 1][routes.length + 1];
        for(int i=0; i<=n; i++)
            for(int j=0; j<=routes.length; j++)
             vis[i][j] = -1;
        
        while(q.size() > 0){
            Pair top = q.remove();
            if(top.Stop == target) return top.Changes;
            
            if(vis[top.Stop][top.Color] != -1) continue;
            vis[top.Stop][top.Color] = top.Changes;
            
            for(Pair nbr: adj[top.Stop]){
                if(top.Color == nbr.Color){
                    q.add(new Pair(nbr.Stop, nbr.Color, top.Changes));
                } else {
                    q.add(new Pair(nbr.Stop, nbr.Color, top.Changes + 1));
                }
            }
        }
        
        return -1;
    }
}