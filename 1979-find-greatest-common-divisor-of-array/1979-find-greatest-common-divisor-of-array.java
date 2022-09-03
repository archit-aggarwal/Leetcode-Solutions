class Solution {
    public int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int val: nums){
            min = Math.min(min, val);
        }
        return min;
    }
    
    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int val: nums){
            max = Math.max(max, val);
        }
        return max;
    }
    
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);    
    }
    
    public int findGCD(int[] nums) {
        int a = findMin(nums);
        int b = findMax(nums);
        return gcd(a, b);
    }
}