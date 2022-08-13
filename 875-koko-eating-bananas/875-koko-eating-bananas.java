class Solution {
    public int maxOfArray(int[] piles){
        int max = 0;
        for(int pile: piles) max = Math.max(max, pile);
        return max;
    }
    
    public static boolean isPossible(long speed, int time, int[] piles){
        long currTime = 0;
        for(int pile: piles){
            currTime = currTime + (pile / speed);
            if(pile % speed != 0) currTime++;
        }
        
        if(currTime <= time) return true;
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int time) {
        long left = 1l, right = maxOfArray(piles), ans = right;
        
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(isPossible(mid, time, piles) == true){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return (int)ans;
    }
}