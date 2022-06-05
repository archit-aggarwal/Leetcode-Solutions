class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int total = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            total += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }
        
        int minSum = Integer.MAX_VALUE;
        currSum = 0;
        
        for(int i=0; i<nums.length; i++){
            currSum = Math.min(nums[i], currSum + nums[i]);
            minSum = Math.min(currSum, minSum);
        }
        
        if(maxSum > 0) 
            return Math.max(maxSum, total - minSum);
        else return maxSum;
    }
}