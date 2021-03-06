class Solution {
    public static class Pair{
        int maxSum = 0;
        int prefix = 0;
        int suffix = 0;
        int total = 0;
        
        Pair(int val){
            maxSum = prefix = suffix = total = val;
        }
    }
    
    public Pair helper(int left, int right, int[] nums){
        if(left == right){
            return new Pair(nums[left]);
        }
        
        int mid = left + (right - left) / 2;
        Pair lans = helper(left, mid, nums);
        Pair rans = helper(mid + 1, right, nums);
        
        Pair ans = new Pair(0);
        ans.total = lans.total + rans.total;
        ans.prefix = Math.max(lans.prefix, lans.total + rans.prefix);
        ans.suffix = Math.max(rans.suffix, rans.total + lans.suffix);
        ans.maxSum = Math.max(lans.suffix + rans.prefix, 
                         Math.max(lans.maxSum, rans.maxSum));
        return ans;
    }
    
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        return helper(0, nums.length - 1, nums).maxSum;
    }
}