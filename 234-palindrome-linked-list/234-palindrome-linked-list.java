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
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        return slow;
    }
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
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddle(head);
        mid = reverseList(mid);
        
        while(head != null && mid != null){
            if(head.val != mid.val) return false;
            head = head.next; 
            mid = mid.next;
        }
        
        return true;
    }
}