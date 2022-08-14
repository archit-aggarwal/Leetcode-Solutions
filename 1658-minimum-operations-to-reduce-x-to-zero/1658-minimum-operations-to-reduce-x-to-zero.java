class Solution {
    public long total(int[] nums){
        long sum = 0;
        for(long val: nums) sum += val;
        return sum;
    }
    
    public int minOperations(int[] nums, int x) {
        HashMap<Long, Long> fo = new HashMap<>();
        fo.put(0l, -1l);
        
        long largest = -1, pref = 0, target = total(nums) - x;
        if(target == 0) return nums.length;
        if(target < 0) return -1;
        
        for(int i=0; i<nums.length; i++){
            pref = pref + nums[i];
            
            if(fo.containsKey(pref - target) == true){
                largest = Math.max(largest, i - fo.get(pref - target));
            }
            
            if(fo.containsKey(pref) == false)
                fo.put(pref, (long)i);
        }
        
        if(largest == -1) return -1;
        return (nums.length - (int)largest);
    }
}