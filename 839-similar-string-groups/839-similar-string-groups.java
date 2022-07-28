class Solution {
    public int rank[];
    public int parent[];
    
    public void union(int i, int j, String[] strs){
        if(similar(strs[i], strs[j]) == false)
            return;
        
        i = find(i);
        j = find(j);
        
        if(i == j) return;
        
        if(rank[i] >= rank[j]){
            rank[i] += rank[j];
            parent[j] = i;
        } else {
            rank[j] += rank[i];
            parent[i] = j;
        }
    }
    
    public int find(int i){
        if(parent[i] == -1) return i;
        return parent[i] = find(parent[i]);
    }
    
    public boolean similar(String a, String b){
        int count = 0;
        for(int k=0; k<a.length(); k++)
            if(a.charAt(k) != b.charAt(k))
                count++; 
        return (count <= 2) ? true : false;
    }
    
    public int numSimilarGroups(String[] strs) {
        rank = new int[strs.length];
        parent = new int[strs.length];
        Arrays.fill(parent, -1);
        
        for(int i=0; i<strs.length; i++)
            for(int j=i+1; j<strs.length; j++)
                union(i, j, strs);
        
        int groups = 0;
        for(int i=0; i<strs.length; i++)
            if(parent[i] == -1) groups++;
        return groups;
    }
}