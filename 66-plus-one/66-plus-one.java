class Solution {
    public int[] plusOne(int[] arr) {
        int idx;
        for(idx = arr.length - 1; idx >= 0 && arr[idx] == 9; idx--){
            arr[idx] = 0;
        }
        
        if(idx == -1){
            int[] res = new int[arr.length + 1];
            res[0] = 1;
            return res;
        }
        
        arr[idx]++;
        return arr;
    }
}