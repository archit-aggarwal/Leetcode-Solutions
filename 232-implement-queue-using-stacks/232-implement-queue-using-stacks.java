class MyQueue {
    Stack<Integer> stk;
    
    public MyQueue() {
        stk = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        Stack<Integer> reverse = new Stack<>();
        while(stk.size() > 0){
            reverse.push(stk.pop());
        }
        
        int front = reverse.pop();
        while(reverse.size() > 0){
            stk.push(reverse.pop());
        }
        
        return front;
    }
    
    public int peek() {
        Stack<Integer> reverse = new Stack<>();
        while(stk.size() > 0){
            reverse.push(stk.pop());
        }
        
        int front = reverse.peek();
        while(reverse.size() > 0){
            stk.push(reverse.pop());
        }
        
        return front;
    }
    
    public boolean empty() {
        if(stk.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */