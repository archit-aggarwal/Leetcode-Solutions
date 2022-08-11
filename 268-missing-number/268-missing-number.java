class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums) set.add(val);
        
        for(int i=0; i<nums.length; i++){
            if(set.contains(i) == false){
                return i;
            }
        }
        
        return nums.length;
    }
}