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
    
    public ListNode helper(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        
        int mid = left + (right - left) / 2;
        
        ListNode leftHead = helper(lists, left, mid);
        ListNode rightHead = helper(lists, mid + 1, right);
        
        return sortedMerge(leftHead, rightHead);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);    
    }
}