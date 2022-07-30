class Solution {
    public int partition(int[] arr, int left, int right, int pivot){
        int low = left, high = left;

        while(high <= right){

            if(arr[high] > pivot){
                high++;
            } else {
                swap(arr, high, low);
                low++; high++;
            }
        }
        
        return low - 1;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void randomize(int[] nums, int left, int right){
        int randomIdx = (int)(Math.random()*(right-left+1)+left);
        swap(nums, randomIdx, right);
    }
    
    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return; // Array of 0 or 1 element -> Already Sorted
        
        randomize(nums, left, right);
        int pivot = partition(nums, left, right, nums[right]);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}