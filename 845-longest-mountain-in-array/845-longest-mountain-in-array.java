class Solution {
    public int longestMountain(int[] nums) {
        int max = 0;
        
        for(int i=0; i<nums.length; i++){
            
            // Potential Peak Element
            if(i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                
                int curr = 1;
                
                int left = i - 1;
                while(left >= 0 && nums[left] < nums[left + 1]){
                    left--;
                    curr++;
                }
                
                int right = i + 1;
                while(right < nums.length && nums[right] < nums[right - 1]){
                    right++;
                    curr++;
                }
                
                max = Math.max(max, curr);
            }
            
        }
        
        return max;
    }
}