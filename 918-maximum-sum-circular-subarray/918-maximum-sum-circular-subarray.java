class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        
        int prefSum = nums[0];
        int[] prefix = new int[nums.length];
        prefix[0] = prefSum;
        
        for(int i=1; i<nums.length; i++){
            prefSum += nums[i];
            prefix[i] = Math.max(prefix[i - 1], prefSum);
        }
        
        int suffixSum = nums[nums.length - 1];
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = suffixSum;
        
        for(int i=nums.length-2; i>=0; i--){
            suffixSum += nums[i];
            suffix[i] = Math.max(suffixSum, suffix[i + 1]);
        }
        
        for(int i=0; i<nums.length; i++){
            suffixSum = (i + 1 < nums.length) ? suffix[i + 1] : 0;
            maxSum = Math.max(maxSum, prefix[i] + suffixSum);
        }
        
        return maxSum;
    }
}