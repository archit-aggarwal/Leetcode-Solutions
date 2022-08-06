class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOcc = -1;
        
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                firstOcc = mid;
                right = mid - 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        
        int lastOcc = -1;
        left = 0; right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                lastOcc = mid;
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return new int[]{firstOcc, lastOcc};
    }
}