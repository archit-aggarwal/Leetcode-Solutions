class Solution {
    public static int maxOfArray(int[] pages){
        int max = 0;
        for(int val: pages)
            max = Math.max(max, val);
        return max;
    }
    
    public static int sumOfArray(int[] pages){
        int sum = 0;
        for(int val: pages)
            sum += val;
        return sum;
    }

    public static boolean isPossible(int maxLoad, int[] pages, int students){
        int currLoad = pages[0], currStud = 1;
        for(int i=1; i<pages.length; i++){
            if(currLoad + pages[i] <= maxLoad){
                currLoad += pages[i];
            } else {
                currStud++;
                currLoad = pages[i];
            }
        }
        if(currStud > students) return false;
        return true;
    }
    
    public int shipWithinDays(int[] pages, int students) {
        int left = maxOfArray(pages), right = sumOfArray(pages), ans = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(mid, pages, students) == true){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}