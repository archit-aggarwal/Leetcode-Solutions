class Solution {
    // Merge 2 Sorted Arrays -> O(N + M)
    public int[] merge(int[] arr1, int[] arr2){
        int[] res = new int[arr1.length + arr2.length];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;
        
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] <= arr2[ptr2]){
                res[ptr3] = arr1[ptr1];
                ptr1++; ptr3++;
            } else {
                res[ptr3] = arr2[ptr2];
                ptr2++; ptr3++;
            }
        }
        
        while(ptr1 < arr1.length){
            res[ptr3] = arr1[ptr1];
            ptr1++; ptr3++;
        }
        
        while(ptr2 < arr2.length){
            res[ptr3] = arr2[ptr2];
            ptr2++; ptr3++;
        }
        
        return res;
  }
    
    public int[] sortArray(int left, int right, int[] nums){
        if(left > right) return new int[0];
        if(left == right) return new int[]{nums[left]};
        
        int mid = left + (right - left) / 2;
        
        int[] lres = sortArray(left, mid, nums);
        int[] rres = sortArray(mid + 1, right, nums);
        
        return merge(lres, rres);
    }
    
    public int[] sortArray(int[] nums) {
        return sortArray(0, nums.length - 1, nums);
    }
}