class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int val = nums[i] % (n + 1);
            nums[val - 1] += (n + 1);
        }
        
        int missing = -1, duplicate = -1;
        
        for(int i=0; i<n; i++){
            if(nums[i] / (n + 1) > 1) duplicate = (i + 1);
            if(nums[i] <= n) missing = (i + 1);
        }
        
        return new int[]{duplicate, missing};
    }
}