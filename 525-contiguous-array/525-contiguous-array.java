class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);
        
        int zeros = 0, ones = 0, largest = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) zeros++;
            else ones++;
            
            if(freq.containsKey(zeros - ones) == false){
                freq.put(zeros - ones, i);
            }
            
            largest = Math.max(largest, i - freq.get(zeros - ones));
        }
                               
        return largest;
    }
}