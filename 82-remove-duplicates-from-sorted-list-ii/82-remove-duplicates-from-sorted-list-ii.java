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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode rhead = new ListNode(Integer.MIN_VALUE);
        ListNode rtail = rhead;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.next == null || curr.next.val != curr.val){
                // Only Occurence
                rtail.next = curr;
                curr = curr.next;
                rtail = rtail.next;
                rtail.next = null;
            } else {
                // Delete all occurences
                int temp = curr.val;
                while(curr != null && curr.val == temp){
                    curr = curr.next;
                }
            }
        }
        
        return rhead.next;
    }
}