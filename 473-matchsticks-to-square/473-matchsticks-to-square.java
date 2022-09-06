class Solution {
    int sum = 0;
    
    public int count(int[] set){
        int count = 0;
        for(int i=0; i<4; i++){
            if(set[i] == sum) count++;
        }
        return count;
    }
    
    public boolean helper(int[] set, int i, Integer[] arr){
        if(i == arr.length) return count(set) == 0;
        if(arr.length - i < count(set)) return false;
        
        for(int j=0; j<4; j++){
            if(set[j] >= arr[i]){
                set[j] -= arr[i];
                if(helper(set, i + 1, arr) == true) return true;
                set[j] += arr[i];
            }
        }
        
        return false;
    }
    
    public boolean makesquare(int[] arr) {
        for(int val: arr) sum += val;
        if(arr.length < 4 || sum % 4 != 0) 
            return false;
        
        Integer[] nums = new Integer[arr.length];
        for(int i=0; i<arr.length; i++) nums[i] = arr[i];
        Arrays.sort(nums, Collections.reverseOrder());
        
        sum = sum / 4;
        int[] set = {sum, sum, sum, sum};
        
        return helper(set, 0, nums);
    }   
}