class Solution {
    public int kSimilarity(String A, String B) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(A);
        visited.add(A);
        int level = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curNode = queue.poll();
                if (curNode.equals(B)) return level;
                
                for (String neighbour : getNeighbours(curNode, B)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }

        return -1;
    }
    
    private List<String> getNeighbours(String S, String B) { 
        List<String> result = new ArrayList<>();
        char[] arr = S.toCharArray(); 
        
        int i = 0;
        while(i < arr.length && arr[i] == B.charAt(i)) { i++; }
                
        for (int j = i + 1; j < arr.length; j++) { 
            if (arr[j] == B.charAt(i)) {
                swap(arr, i, j);             
                result.add(new String(arr));
                swap(arr, i, j);
            }
        }     
        
        return result;
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}