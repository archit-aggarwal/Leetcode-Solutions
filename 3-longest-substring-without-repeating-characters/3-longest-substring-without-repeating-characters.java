class Solution {
    public int lengthOfLongestSubstring(String input) {
        int left = 0, right = 0;
       int[] previous = new int[1000];
       Arrays.fill(previous, -1);
       
       // O(N)
       int maxLen = 0;
       while(right < input.length()){
          if(previous[input.charAt(right)] != -1){
            left = Math.max(left, previous[input.charAt(right)] + 1);
          }
          
          previous[input.charAt(right)] = right; // Including
          maxLen = Math.max(maxLen, right - left + 1); 
          right++;
       }
        
        return maxLen;
    }
}