class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            int lVal = (mid == 0) ? Integer.MAX_VALUE : arr[mid - 1];
            int rVal = (mid == arr.length - 1) ? Integer.MAX_VALUE : arr[mid + 1];
                
            if(arr[mid] < lVal && arr[mid] < rVal){
                return mid;
            } else if(arr[mid] > arr[right]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return 0;
    }
    
    public int binarySearch(int[] arr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivot = findMin(nums);
        
        int lval = binarySearch(nums, 0, pivot - 1, target);
        if(lval != -1) return lval;
        
        return binarySearch(nums, pivot, nums.length - 1, target);
    }
}