class Solution {
public:
    int mySqrt(int x) {
        if(x <= 1) return x;
        
        // Linear Search = O(Root N) 
        // long ans = 1l;
        // while(ans * ans <= x){
        //     ans++;
        // }
        // return (int)(ans - 1);
        
        // Binary Search
        long left = 1l, right = x;
        long ans = 1l;
        
        while(left <= right){
            long mid = left + (right - left) / 2l;
            if(mid * mid <= x){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int)ans;
    }
};