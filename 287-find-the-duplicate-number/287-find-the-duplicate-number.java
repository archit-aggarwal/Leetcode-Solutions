class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int val = nums[i] % (n + 1);
            nums[val - 1] += (n + 1);
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] / (n + 1) >= 2) 
                return (i + 1);
        }
        return (n + 1);
    }
}