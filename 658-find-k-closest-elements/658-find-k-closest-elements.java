class Solution {
    public int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] >= target){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int target) {
        int right = lowerBound(arr, target);
        int left = right - 1;
        
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            int leftDist = (left == -1) ? Integer.MAX_VALUE : target - arr[left];
            int rightDist = (right == arr.length) ? Integer.MAX_VALUE : arr[right] - target;
            
            if(leftDist <= rightDist){
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        
        Collections.sort(res);
        return res;
    }
}