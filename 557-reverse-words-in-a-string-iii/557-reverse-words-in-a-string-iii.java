class Solution {
    public String reverseWords(String input) {
        String output = "";
        
        int start = 0, end = 0;
        
        while(start < input.length()){
            
            while(end < input.length() && input.charAt(end) != ' '){
                end++;
            }
            
            for(int i=end-1; i>=start; i--){
                output = output + input.charAt(i);
            }
            
            if(end < input.length()){
                output = output + ' ';    
            }
            
            end++;
            start = end;
        }
        
        return output;
    }
}