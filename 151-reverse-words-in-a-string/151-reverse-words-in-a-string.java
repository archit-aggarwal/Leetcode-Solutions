class Solution {
    public String reverseWords(String s) {
        String output = "";
        
        s = s.trim();
        int start = s.length() - 1, end = s.length() - 1;
        
        // Iterate on Each Word
        while(end >= 0){
            
            // Finding the next space from right to left
            while(start >= 0 && s.charAt(start) != ' '){
                start--;
            }
            
            // Insert the word from [start + 1, end]
            for(int i=start+1; i<=end; i++){
                output = output + s.charAt(i);
            }
            
            // Insert Space for every word except the first word
            if(start >= 0 && start < end){
                output = output + ' ';
            }
            
            // First Word is Achieved when start == -1
            start--;
            end = start;
        }
        
        return output;
    }
}