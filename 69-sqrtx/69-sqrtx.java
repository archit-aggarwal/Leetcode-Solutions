class Solution {
    public int mySqrt(int x) {
        // Approach 1
        // return (int)Math.pow(x, 0.5);
        
        // Approach 2
        // return (int)Math.sqrt(x);
        
        // Approach 3:
        // 
        if(x == 0 || x == 1) return x;
        
        int left = 1, right = x, ans = 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if((long)mid * mid <= x){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}