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
    public ListNode reverseList(ListNode head) {
        ListNode left = null, curr = head;
        while(curr != null){
            ListNode right = curr.next;
            
            curr.next = left;
            left = curr;
            curr = right;
        }
        
        return left;
    }
}