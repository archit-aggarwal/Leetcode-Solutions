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
    public ListNode sortedMerge(ListNode head1, ListNode head2) {
           ListNode head = new ListNode(-1);
           ListNode tail = head;

           while(head1 != null && head2 != null){
               if(head1.val <= head2.val){
                   tail.next = head1;
                   tail = tail.next;
                   head1 = head1.next;
               } else {
                   tail.next = head2;
                   tail = tail.next;
                   head2 = head2.next;
               }
           }

           if(head1 != null) tail.next = head1;
           else tail.next = head2;

           return head.next;
     } 
    
    public ListNode getMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return prev;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        mid.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        
        return sortedMerge(left, right);
    }
}