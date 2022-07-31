class Solution {
    public static void countSort(int[] arr, int min, int max) {
        int[] freq = new int[max - min + 1];

        for(int i=0; i<arr.length; i++){
            int bucket = arr[i] - min;
            freq[bucket]++;
        }


        int idx = 0;
        for(int bucket=0; bucket<freq.length; bucket++){
            int val = bucket + min;
            while(freq[bucket]-- > 0){
                arr[idx] = val;
                idx++;
            }
        }
    }

    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        countSort(nums, min, max);
        return nums;
    }
}