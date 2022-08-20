/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void swap(ListNode a, ListNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    
    public void deleteNode(ListNode curr) {
        swap(curr, curr.next);
        curr.next = curr.next.next;
    }
}