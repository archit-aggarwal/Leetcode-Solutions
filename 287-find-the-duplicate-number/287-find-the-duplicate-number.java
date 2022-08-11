class Solution {
    public int approach1(int[] nums){
        // Approach 1: Indexing Based Hashing
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            int val = nums[i] % (n + 1);
            nums[val - 1] += (n + 1);
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] / (n + 1) > 1)
                return i + 1;
        }
        
        return n;
    }
    
    public int approach2(int[] nums){
        // Approach 2: Floyd Cycle
        int slow = 0, fast = 0;
        
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    public int findDuplicate(int[] nums) {
        return approach1(nums);
    }
}