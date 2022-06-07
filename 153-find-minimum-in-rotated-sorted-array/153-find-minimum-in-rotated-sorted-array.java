class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(mid >= 1 && nums[mid - 1] > nums[mid]){
                // Pivot Element is at Mid
                return nums[mid];
            }
            else if(nums[mid] >= nums[0]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Corner Case: Sorted Array without Rotations
        return nums[0];
    }
}