class Solution {
    int longest, counter;
    
    public void dfs(int src, boolean[] vis, 
                    HashMap<Integer, Integer> path, ArrayList<Integer>[] adj){
        if(vis[src] == true){
            if(path.containsKey(src) == true){
                longest = Math.max(longest, path.size() - path.get(src));
            }
            return;
        }
        
        vis[src] = true;
        path.put(src, counter);
        counter++;
        
        for(Integer nbr: adj[src]){
            dfs(nbr, vis, path, adj);
        }
    }
    
    public int longestCycle(int[] child) {
        int n = child.length;
        longest = -1; counter = 0;
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(child[i] != -1) adj[i].add(child[i]);
        }
        
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++)
            if(vis[i] == false){
                counter = 0;
                dfs(i, vis, new HashMap<>(), adj);
            }
        
        return longest;
    }
}