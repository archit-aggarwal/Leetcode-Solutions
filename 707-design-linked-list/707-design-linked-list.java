// Single ListNode
class ListNode {
    int val; // Data
    ListNode next; 
    
    ListNode(int val){
        this.val = val;    
    }
}

// Collection of ListNodes
class MyLinkedList {
    ListNode head, tail;
    int size = 0;
    
    // O(N)
    public ListNode getNode(int index){
        if(index < 0 || index >= size){
            return null;
        }
        
        ListNode curr = head;
        for(int i=0; i<index; i++){
            curr = curr.next;
        }
        
        return curr;
    }
    
    // O(N) in Worst Case
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        
        return getNode(index).val;
    }
    
    // O(1)
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        
        if(size == 0){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        
        size++;
    }
    
    // O(1)
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if(size == 0){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) 
            return;
        
        if(index == 0){
            addAtHead(val);
            return;
        }
        
        if(index == size){
            addAtTail(val);
            return;
        }
        
        ListNode newNode = new ListNode(val);
        ListNode prev = getNode(index - 1);
        
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
    
    // O(1)
    public void removeFirst(){
        if(size == 0) return;
        if(size == 1){
            head = tail = null;
            size = 0; 
            return;
        }
        
        head = head.next;
        size--;
    }
    
    // O(N)
    public void removeLast(){
        if(size == 0) return;
        if(size == 1){
            head = tail = null;
            size = 0;
            return;
        }
        
        ListNode prev = getNode(size - 2);
        prev.next = null;
        tail = prev;
        size--;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        
        if(index == 0) removeFirst();
        else if(index == size - 1) removeLast();
        else {
            ListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            size--;
        }
    }
}
