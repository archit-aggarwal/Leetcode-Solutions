class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(stk.size() == 0 || stk.peek() != s.charAt(i)){
                stk.push(s.charAt(i));
            } else {
                stk.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        while(stk.size() > 0){
            sb.append(stk.pop());
        }
        
        return sb.reverse().toString();
    }
}