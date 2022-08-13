class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastOcc = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(lastOcc.containsKey(nums[i]) == true && i - lastOcc.get(nums[i]) <= k) 
                return true;
            lastOcc.put(nums[i], i);
        }
        
        return false;
    }
}