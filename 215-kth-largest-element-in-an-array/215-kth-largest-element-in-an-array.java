class Solution {
    public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> q = new PriorityQueue<>();
//         // Minimum Heap
        
//         for(int i=0; i<nums.length; i++) q.add(nums[i]);
        
//         // Heap Sort -> O(N log N)
//         int idx = 0;
//         while(q.size() > 0){
//             nums[idx] = q.remove();
//             idx++;
//         }
        
//         return nums[nums.length - k];
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        // Maximum Heap
        
        for(int i=0; i<nums.length; i++) q.add(nums[i]);
        
        for(int i=0; i<k-1; i++){
            q.remove();
        }
        
        return q.peek();
    }
}