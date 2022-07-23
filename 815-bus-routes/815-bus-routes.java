class Solution {
    public static class Pair implements Comparable<Pair>{
        int busStop; // NODE
        int busColor; // COLOR (EDGE)
        int busChanges;
        
        Pair(int busStop, int busColor, int busChanges){
            this.busStop = busStop;
            this.busColor = busColor;
            this.busChanges = busChanges;
        }
        
        public int compareTo(Pair other){
            return this.busChanges - other.busChanges;
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
        
        // Loop on All Buses (Routes)
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
        // for(int i=0; i<adj[source].size(); i++){
        //     q.add(new Pair(source, adj[source].get(i).busColor, 1));
        // }
        
        int[][] vis = new int[n + 1][routes.length + 1];
        for(int i=0; i<=n; i++){
         for(int j=0; j<=routes.length; j++)
             vis[i][j] = -1;
        }
        
        if(adj[source].size() == 0) return -1; // No Bus from Source
        
        while(q.size() > 0){
            Pair top = q.remove();
            if(top.busStop == target) return top.busChanges;
            
            if(vis[top.busStop][top.busColor] != -1) continue;
            vis[top.busStop][top.busColor] = top.busChanges;
            
            for(Pair nbr: adj[top.busStop]){
                if(top.busColor == nbr.busColor){
                    q.add(new Pair(nbr.busStop, nbr.busColor, top.busChanges));
                } else {
                    q.add(new Pair(nbr.busStop, nbr.busColor, top.busChanges + 1));
                }
            }
        }
        
        return -1;
    }
}