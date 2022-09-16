class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int val: nums){
            if(val % 2 == 0) sum += val;
        }
        
        int[] res = new int[queries.length];
        int idx = 0;
        
        for(int[] q: queries){
            int oldVal = nums[q[1]];
            int newVal = nums[q[1]] + q[0];

            nums[q[1]] = newVal;
            if(oldVal % 2 == 0) sum -= oldVal;
            if(newVal % 2 == 0) sum += newVal;
            
            res[idx++] = sum;
        }
        
        return res;
    }
}