class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void sortColors(int[] arr) {
        int left = 0, right = arr.length - 1, mid = 0;
        
        while(mid <= right){
            if(arr[mid] == 0){
                swap(arr, left, mid);
                left++; mid++;
            } else if(arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, right);
                right--; 
            }
        }
    }
}