class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int val = nums[i] % (n + 1);
            nums[val - 1] += (n + 1);
        }
        
        int missing = 0, repeating = 0;
        for(int i=0; i<n; i++){
            if(nums[i] / (n + 1) == 0) missing = (i + 1);
            if(nums[i] / (n + 1) == 2) repeating = (i + 1);
        }
        
        return new int[]{repeating, missing};
    }
}