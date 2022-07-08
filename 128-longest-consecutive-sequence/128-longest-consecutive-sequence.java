class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(freq.containsKey(nums[i]) == true){
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        
        int max = 0;
        for(int i=0; i<nums.length; i++){
            // If a Starting Element of a Sequence -> Figure out sequence length
            if(freq.containsKey(nums[i] - 1) == false){
                int length = 0, ptr = nums[i];
                while(freq.containsKey(ptr) == true){
                    length++; ptr++;
                }
                max = Math.max(max, length);
            }
        }
        
        return max;
    }
}