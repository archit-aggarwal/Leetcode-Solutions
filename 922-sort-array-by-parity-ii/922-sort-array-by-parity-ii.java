class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int even = 0, odd = 1, n = arr.length;
        
        while(even < n && odd < n){
            while(even < n && arr[even] % 2 == 0) even += 2;
            while(odd < n && arr[odd] % 2 == 1) odd += 2;
            
            if(even < n && odd < n){
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
            }
        }
        
        return arr;
    }
}