class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        int[] freq = new int[max - min + 1];
        for(int i=0; i<arr.length; i++){
            int bucket = arr[i] - min;
            freq[bucket]++;
        }
        
        ArrayList<Integer>[] buckets = new ArrayList[arr.length + 1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<>();
        } 
        
        for(int i=0; i<freq.length; i++){
            int val = i + min;
            buckets[freq[i]].add(val);
        }
        
        int[] res = new int[k];
        int i = 0, j = buckets.length - 1;
        while(j >= 0 && i < k){
            for(int val: buckets[j]){
                res[i] = val;
                i++;
            }
            j--;
        }
        return res;
    }
}