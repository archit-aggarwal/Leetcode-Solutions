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
    public ListNode partition(ListNode curr, int pivot) {
        // Inplace and Stable
        ListNode leftHead = new ListNode(-1);
        ListNode leftTail = leftHead;
        
        ListNode rightHead = new ListNode(-1);
        ListNode rightTail = rightHead;
        
        while(curr != null){
            if(curr.val < pivot){
                leftTail.next = curr;
                leftTail = leftTail.next;
                curr = curr.next;
            } else {
                rightTail.next = curr;
                rightTail = rightTail.next;
                curr = curr.next;
            }
        }
        
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}