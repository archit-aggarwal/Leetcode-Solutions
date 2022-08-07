class Solution {
    public int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            int lVal = (mid == 0) ? Integer.MAX_VALUE : arr[mid - 1];
            int rVal = (mid == arr.length - 1) ? Integer.MAX_VALUE : arr[mid + 1];
                
            if(arr[mid] < lVal && arr[mid] < rVal){
                return arr[mid];
            } else if(arr[mid] > arr[right]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return arr[0];
    }
}