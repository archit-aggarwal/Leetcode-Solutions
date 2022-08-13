class Solution {
    public boolean isPossible(int[] stalls, int dist, int cows){
        int placedCows = 1, lastPlaced = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - lastPlaced >= dist){
                placedCows++;
                lastPlaced = stalls[i];
            }
        }
        
        if(placedCows < cows) return false;
        return true;
    }
    
    public int maxDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        
        int left = 1, right = stalls[stalls.length - 1] - stalls[0];
        int ans = 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(stalls, mid, cows) == true){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}