class Solution {
    public int helper(int left, int right, int[] nums, int[][] dp){
        if(left > right) return 0;
        if(left == right) return nums[left];
        if(dp[left][right] != -1) return dp[left][right];
        
        return dp[left][right] = Math.max(nums[left] - helper(left + 1, right, nums, dp), 
                                          nums[right] - helper(left, right - 1, nums, dp));
    }
    
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[0].length; j++)
                dp[i][j] = -1;
        
        
        int diff = helper(0, nums.length - 1, nums, dp);
        if(diff >= 0) return true;
        return false;
    }
}