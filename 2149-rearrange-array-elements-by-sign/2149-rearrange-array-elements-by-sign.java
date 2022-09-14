class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        
        int even = 0, odd = 1;
        for(int val: nums){
            if(val >= 0){
                res[even] = val;
                even += 2;
            } else {
                res[odd] = val;
                odd += 2;
            }
        }
        
        return res;
    }
}