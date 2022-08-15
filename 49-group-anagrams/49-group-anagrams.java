class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        // Key -> Sorted String, Value -> List of Anagrams
        
        for(String word: strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String parent = new String(arr);
            
            if(groups.containsKey(parent) == false){
                groups.put(parent, new ArrayList<>());
            }
            
            groups.get(parent).add(word);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(String key: groups.keySet()){
            res.add(groups.get(key));
        }
        return res;
    }
}