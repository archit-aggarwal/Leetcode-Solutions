class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int val = nums[i] % (n + 1);
            if(val < n) nums[val] += (n + 1);
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] <= n) return i;
        }
        return n;
    }
}