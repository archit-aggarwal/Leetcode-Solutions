class Solution {
    public boolean isAnagram(int[] freq){
        for(int i=0; i<26; i++){
            if(freq[i] != 0) return false;
        }    
        return true;
    }
    
    public List<Integer> findAnagrams(String a, String b) {
        int[] freq = new int[26];
        for(int i=0; i<b.length(); i++)
            freq[b.charAt(i) - 'a']++;
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<a.length(); i++){
            freq[a.charAt(i) - 'a']--;
            
            if(i >= b.length()) 
                freq[a.charAt(i - b.length()) - 'a']++; 
            if(isAnagram(freq) == true) 
                res.add(i - b.length() + 1);
        }
        
        return res;
    }
}