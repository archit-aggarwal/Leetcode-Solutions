class Solution {
    public int strStr(String actual, String required) {
        for(int i=0; i<= actual.length()-required.length(); i++){
            if(actual.substring(i, i + required.length()).equals(required) == true){
                return i;
            } 
        }
        
        return -1;
    }
}