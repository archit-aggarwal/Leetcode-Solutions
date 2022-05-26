class Solution {
    public int firstUniqChar(String s) {
        // Brute Force - Time - O(N * N)
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
            
//             boolean isUnique = true;
//             for(int j=0; j<s.length(); j++){
//                 if(i != j && s.charAt(j) == ch){
//                     isUnique = false;
//                 }
//             }
            
//             if(isUnique == true) return i;
//         }
        
//         return -1;
        
        
        int[] freq = new int[26];
        
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }
        
        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(freq[idx] == 1) return i;
        }
        
        return -1;
    }
}