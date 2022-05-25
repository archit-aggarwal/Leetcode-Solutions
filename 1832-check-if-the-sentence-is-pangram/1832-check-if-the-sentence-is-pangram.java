class Solution {
    public boolean checkIfPangram(String str) {
        if(str.length() < 26) return false;
        
        int[] freq = new int[26];
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i) - 'a';
            freq[idx]++;
        }
        
        for(int i=0; i<26; i++){
            if(freq[i] == 0){
                return false;
            }
        }
        
        return true;
    }
}