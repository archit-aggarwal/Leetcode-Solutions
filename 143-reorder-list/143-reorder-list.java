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
    public ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        return prev;
    }
    public ListNode reverse(ListNode head) {
        ListNode left = null, curr = head;
        
        while(curr != null){
            ListNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        
        return left;
    }
    
    public void reorderList(ListNode left) {
        ListNode mid = getMiddle(left);
        ListNode right = reverse(mid.next);
        mid.next = null;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(left != null && right != null){
            tail.next = left;
            tail = tail.next;
            left = left.next;
            
            tail.next = right;
            tail = tail.next;
            right = right.next;
        }
        
        tail.next = right;
    }
}