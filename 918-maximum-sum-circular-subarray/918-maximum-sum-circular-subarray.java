class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int currMin = 0, currMax = 0;
        int total = 0;
        
        for(int i=0; i<nums.length; i++){
            currMin = Math.min(currMin + nums[i], nums[i]);
            currMax = Math.max(currMax + nums[i], nums[i]);
            
            minSum = Math.min(minSum, currMin);
            maxSum = Math.max(maxSum, currMax);
            total = total + nums[i];
        }
        
        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}