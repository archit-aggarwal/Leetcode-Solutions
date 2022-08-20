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
    public ListNode approach1(ListNode head){
        int size = getSize(head);
        return getNode(head, size / 2);
    }
    
    public int getSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode getNode(ListNode head, int n){
        for(int idx=0; idx<n; idx++){
            head = head.next;
        }    
        return head;
    }
    
    public ListNode approach2(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        return slow;
    }
    
    public ListNode middleNode(ListNode head) {
        return approach2(head);
    }
}