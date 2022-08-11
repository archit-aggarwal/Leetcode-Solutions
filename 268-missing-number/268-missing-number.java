class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Visited Each Element Present in Array
        for(int i=0; i<nums.length; i++){
            int val = nums[i] % (n + 1);
            if(val < n) nums[val] += (n + 1);
        }
        
        // Find Missing Element
        for(int i=0; i<nums.length; i++){
            if(nums[i] < n + 1) return i;
        }
        
        return n; 
        // If all boxes are visited, then n itself is the answer
    }
}