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
        ListNode rhead = new ListNode(Integer.MAX_VALUE);
        ListNode rtail = rhead;
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val != rtail.val){
                // First Occurence
                rtail.next = curr;
                curr = curr.next;
                rtail = rtail.next;
                rtail.next = null;
            } else {
                curr = curr.next;
            }
        }
        
        return rhead.next;
    }
    
}