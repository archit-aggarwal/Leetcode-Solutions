class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        
        int g = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) 
            g = gcd(numsDivide[i], g);
        
        for (int i = 0; i < nums.length; i++) 
            if (g % nums[i] == 0) return i;
        
        return -1;
    }
    
    public int gcd(int a, int b) { 
        return b==0 ? a : gcd(b, a % b); 
    }
}