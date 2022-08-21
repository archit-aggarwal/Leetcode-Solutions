/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode approach1(ListNode head, int n){
        int size = getSize(head);
        
        if(size == n) return head.next;
        
        int count = 0;
        ListNode prev = head;
        while(count < size - n - 1){
            prev = prev.next;
            count++;
        }
        prev.next = prev.next.next;
        return head;
    }
    
    public ListNode approach2(ListNode head, int n){
        ListNode slow = head, fast = head;
        
        int count = 0;
        while(count < n){
            count++;
            fast = fast.next;
        }
        
        if(fast == null) return head.next;
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return approach2(head, n);
    }
}