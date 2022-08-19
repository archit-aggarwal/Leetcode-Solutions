class Solution {
    public int majorityElement(int[] nums) {
        int majority = Integer.MIN_VALUE, freq = 0;
        for(int val: nums){
            if(freq <= 0) majority = val;
            
            if(val == majority) freq++;
            else freq--;
        }
        
        return majority;
    }
}