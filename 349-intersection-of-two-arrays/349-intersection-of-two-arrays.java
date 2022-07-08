class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq1 = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(freq1.containsKey(nums1[i]) == true){
                freq1.put(nums1[i], freq1.get(nums1[i]) + 1);
            } else {
                freq1.put(nums1[i], 1);
            }
        }
        
        HashMap<Integer, Integer> freq2 = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
           if(freq2.containsKey(nums2[i]) == true){
                freq2.put(nums2[i], freq2.get(nums2[i]) + 1);
            } else {
                freq2.put(nums2[i], 1);
            } 
        }
        
        ArrayList<Integer> common = new ArrayList<>();
        for(Integer key: freq1.keySet()){
            if(freq2.containsKey(key) == true){
                common.add(key);
            }
        }
        
        int[] res = new int[common.size()];
        for(int i=0; i<res.length; i++)
            res[i] = common.get(i);
        return res;
    }
}