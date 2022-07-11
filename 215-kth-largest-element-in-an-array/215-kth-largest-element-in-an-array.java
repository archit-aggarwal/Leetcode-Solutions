class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) q.add(nums[i]);
        
        int idx = 0;
        while(q.size() > 0){
            nums[idx] = q.remove();
            idx++;
        }
        
        return nums[nums.length - k];
    }
}