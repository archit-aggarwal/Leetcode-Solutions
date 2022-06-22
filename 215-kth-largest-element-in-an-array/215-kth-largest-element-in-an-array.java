class Solution {
    public int partition(int[] arr, int l, int r){
        int j = l;
        for(int i=l; i<=r; i++){
            if(arr[i] <= arr[r]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j - 1;
    }
    
    public int quickSelect(int[] arr, int l, int r, int k){
        if(l == r) return arr[l];
        
        int pivot = partition(arr, l, r);
        if(pivot == arr.length - k) return arr[pivot];
        if(pivot > arr.length - k) return quickSelect(arr, l, pivot - 1, k);
        return quickSelect(arr, pivot + 1, r, k);
    }
    
    public int findKthLargest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }
}