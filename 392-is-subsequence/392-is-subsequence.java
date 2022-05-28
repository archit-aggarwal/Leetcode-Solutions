class Solution {
    public boolean isSubsequence(String required, String actual) {
        if(required.length() == 0) return true;
        int ptr = 0;
        
        for(int i=0; i<actual.length(); i++){
            if(required.charAt(ptr) == actual.charAt(i)){
                ptr++;
            } 
            
            if(ptr == required.length()) return true;
        }
        
        return false;
    }
}