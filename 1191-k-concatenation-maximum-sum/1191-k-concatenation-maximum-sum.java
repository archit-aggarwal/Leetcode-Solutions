class Solution {
    public static int m = 1000000007;
    
    public long add(long a, long b){
        return (a % m + b % m) % m;
    }
    
    public long kadane(int[] arr){
        long currSum = 0, maxSum = 0;
        for(int i=0; i< arr.length; i++){
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1){
            return (int)kadane(arr);
        }
        
        int[] twice = new int[arr.length * 2];
        long total = 0;
        
        for(int i=0; i<arr.length; i++){
            total += arr[i];
            twice[i] = twice[i + arr.length] = arr[i];
        }        
        
        if(total < 0) return (int)(kadane(twice) % m);
        return (int)((kadane(twice) + (k-2l) * total) % m);
    }
}