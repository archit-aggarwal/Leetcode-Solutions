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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail = oddHead, evenTail = evenHead;
        
        int idx = 0;
        while(head != null){
            if(idx % 2 == 0){
                evenTail.next = head;
                head = head.next;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                head = head.next;
                oddTail = oddTail.next;                
            }
            idx++;
        }
        
        evenTail.next = oddHead.next;
        oddTail.next = null;
        return evenHead.next;
    }
}