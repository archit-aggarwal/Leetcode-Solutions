class Solution {
    public int majorityElement(int[] nums) {
        int majority = Integer.MIN_VALUE, freq = 1;
        for(int val: nums){
            if(val == majority) freq++;
            else freq--;
            
            if(freq == 0){
                majority = val;
                freq = 1;
            }
        }
        
        return majority;
    }
}