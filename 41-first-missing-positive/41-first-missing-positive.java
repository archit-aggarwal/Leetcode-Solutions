class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Discard Numbers <= 0 or > n + 1
        for(int i=0; i<n; i++){
            if(nums[i] <= 0 || nums[i] >= n + 1){
                nums[i] = 0;
            }
        }
        
        // Visit Each Element
        for(int i=0; i<nums.length; i++){
            int val = nums[i] % (n + 1);
            if(val != 0) nums[val - 1] += (n + 1);
        }
        
        // Missing Positive
        for(int i=0; i<nums.length; i++){
            if(nums[i] < n + 1) return (i + 1);
        }
        
        return n + 1;
    }
}