class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Store Remainders
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        
        // Subarray with Sum Divisible by K => pref[r] % k == pref[l - 1] % k
        int count = 0, pref = 0;
        for(int val: nums){
            pref = pref + val;
            int remainder = (pref % k + k) % k;
            count = count + freq.getOrDefault(remainder, 0);
            freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}