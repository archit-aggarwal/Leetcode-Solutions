class Solution {
    List<String> res;
    public void helper(String src, HashMap<String, PriorityQueue<String>> adj){
        while(adj.get(src).size() > 0)
            helper(adj.get(src).poll(), adj);
        
        res.add(src);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> edge: tickets){
            
            if(adj.containsKey(edge.get(0)) == false)
                adj.put(edge.get(0), new PriorityQueue<>());
            if(adj.containsKey(edge.get(1)) == false)
                adj.put(edge.get(1), new PriorityQueue<>());
            
            adj.get(edge.get(0)).add(edge.get(1));
        }
        
        res = new ArrayList<>();
        helper("JFK", adj);
        Collections.reverse(res);
        return res;
    }
}