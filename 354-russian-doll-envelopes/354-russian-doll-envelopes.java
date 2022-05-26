class Solution {
    public int lowerBound(ArrayList<Integer> nums, int target){
        int low = 0, high = nums.size() - 1;
        int idx = nums.size();
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid - 1;
                idx = mid;
            }
        }
        
        return idx;
    }
    
    // If Lengths are different, then sort on length
    // Else, if they are same, then sort on breadth

    public int maxEnvelopes(int[][] envelops) {
        Arrays.sort(envelops, (int[] first, int[] second) -> {
            return (first[0] != second[0]) ? first[0] - second[0]
                : second[1] - first[1];
        });
        
        int n = envelops.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        
        for(int i=0; i<envelops.length; i++){
            int lb = lowerBound(sorted, envelops[i][1]);
            if(lb == sorted.size()){
                sorted.add(envelops[i][1]); 
                // Current Element larger than the largest
                // LIS of one length more
            } else {
                sorted.set(lb, envelops[i][1]);
            }
        }
        
        return sorted.size(); // This Sorted Array has same size as LIS
    }
}