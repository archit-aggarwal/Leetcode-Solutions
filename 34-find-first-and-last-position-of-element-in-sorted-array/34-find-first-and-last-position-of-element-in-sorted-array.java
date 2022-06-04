class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        
        // First Occurence
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                ans[0] = mid;
                // Store the current occurence
                right = mid - 1;
                // continue the binary search to the left range
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Last Occurence
        left = 0; right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                ans[1] = mid;
                // Store the current occurence
                left = mid + 1;
                // continue the binary search to the right range
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}