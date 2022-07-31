class Solution {
    public String frequencySort(String arr) {
        int[] freq = new int[130];
        for(int i=0; i<arr.length(); i++){
            int bucket = arr.charAt(i);
            freq[bucket]++;
        }
        
        ArrayList<Character>[] buckets = new ArrayList[arr.length() + 1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Character>();
        } 
        
        for(int i=0; i<freq.length; i++){
            buckets[freq[i]].add((char)i);
        }
        
        
        StringBuilder res = new StringBuilder("");
        for(int i=buckets.length-1; i>0; i--){
            for(Character ch: buckets[i]){
                for(int f=0; f<i; f++)
                    res.append(ch);
            }
        }
        
        return res.toString();
    }
}