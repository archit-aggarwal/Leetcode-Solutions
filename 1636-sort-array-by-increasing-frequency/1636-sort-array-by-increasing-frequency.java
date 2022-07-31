class Solution {
    public int[] frequencySort(int[] arr) {
        // 1. Build the Frequency Array
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        // 2. Fill the Frequency Array
        int[] freq = new int[max - min + 1];
        for(int i=0; i<arr.length; i++){
            int bucket = arr[i] - min;
            freq[bucket]++;
        }
        
        // 3. Build the Buckets Array 
        ArrayList<Integer>[] buckets = new ArrayList[arr.length + 1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<>();
        } 
        
        // 4. Fill the Buckets Array
        for(int i=0; i<freq.length; i++){
            int val = i + min;
            buckets[freq[i]].add(val);
        }
        
        int idx = 0;
        
        // increasing order based on frequency
        for(int i=1; i<buckets.length; i++){
            // Decreasing order for equal elements
            for(int j=buckets[i].size() - 1; j>=0; j--){
                for(int f=0; f<i; f++){
                    arr[idx] = buckets[i].get(j);
                    idx++;
                }
            }
        }
        
        return arr;
    }
}