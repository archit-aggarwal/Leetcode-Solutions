class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Boolean> present = new HashMap<>();
        for(int i=0; i<=nums.length; i++){
            present.put(i, false);
        }
        
        for(int i=0; i<nums.length; i++){
            present.put(nums[i], true);
        }
        
        for(int i=0; i<=nums.length; i++){
            if(present.get(i) == false){
                return i;
            }
        }
        
        return nums.length;
    }
}