class Solution {
    public int[] sortedSquares(int[] arr) {
        
        int[] res = new int[arr.length];
        
        int left = 0, right = arr.length - 1, idx = arr.length - 1;
        
        while(left <= right){
            if(arr[left] * arr[left] >= arr[right] * arr[right]){
                res[idx] = arr[left] * arr[left];
                left++; 
                idx--;
            }  else {
                res[idx] = arr[right] * arr[right];
                right--;
                idx--;
            } 
        }
        
        return res;   
    }
}