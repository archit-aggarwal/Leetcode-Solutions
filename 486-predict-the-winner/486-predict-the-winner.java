class Solution {
    public int helper(int left, int right, int[] nums){
        if(left > right) return 0;
        if(left == right) return nums[left];
        
        int c1 = helper(left + 2, right, nums);
        int c2 = helper(left + 1, right - 1, nums);
        int c3 = helper(left, right - 2, nums);
        
        return Math.max(nums[left] + Math.min(c1, c2), nums[right] + Math.min(c2, c3));
    }
    
    public boolean PredictTheWinner(int[] nums) {
        int ascore = helper(0, nums.length - 1, nums);
        
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total = total + nums[i];
        }
        
        int bscore = total - ascore;
        
        if(ascore >= bscore) return true;
        return false;
    }
}