class Solution {
    public int lowerBound(ArrayList<Integer> nums, int target){
        int low = 0, high = nums.size() - 1;
        int idx = nums.size();
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid - 1;
                idx = mid;
            }
        }
        
        return idx;
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> sorted = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int lb = lowerBound(sorted, nums[i]);
            if(lb == sorted.size()){
                sorted.add(nums[i]); 
                // Current Element larger than the largest
                // LIS of one length more
            } else {
                sorted.set(lb, nums[i]);
            }
        }
        
        return sorted.size(); // This Sorted Array has same size as LIS
    }
}