class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        // return (int)Math.sqrt(x);
        long left = 1l, right = x;
        long ans = 1l;
        
        while(left <= right){
            long mid = left + (right - left) / 2l;
            // int mid = (left + right) / 2;
            
            if(mid * mid <= x){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int)ans;
    }
}