class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> vis = new TreeSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(i - k - 1 >= 0){
                // Remove the Element which is out of the window
                vis.remove((long)nums[i - k - 1]);
            }
            
            Long floor = vis.floor((long)nums[i]);
            Long ceil = vis.ceiling((long)nums[i]);
            
            if(floor != null && (long)nums[i] - floor <= t){
                return true;
            }
            
            if(ceil != null && ceil - (long)nums[i] <= t){
                return true;
            }
            
            vis.add((long)nums[i]);
        }
        
        return false;
    }
}