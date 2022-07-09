class MyStack {
    Queue<Integer> q;
    
    public MyStack() {
        q = new LinkedList<>();    
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.add(q.remove());
        }
        
        return q.remove();
    }
    
    public int top() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.add(q.remove());
        }
        
        int front = q.remove();
        q.add(front);
        return front;
    }
    
    public boolean empty() {
        if(q.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */