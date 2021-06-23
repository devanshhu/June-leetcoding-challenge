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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // if left == right there are no changes in the list || list has <= 1 nodes
        if(left == right || head==null || head.next==null)
            return head;
        //fakeHead to return results 
        ListNode fakeHead = new ListNode(-1000);
        fakeHead.next = head;
        ListNode curr = fakeHead, prev = null;
        // Iterate & get to the first node from where reversal should begin 
        for(int i=0;i< left;i++){
            prev = curr;
            curr = curr.next;
        }
       
        // create tmp pointers
        ListNode tmpCurr = curr;
        ListNode tmpPrev = prev;
        
        //reverse list using regular reverseLinkedList logic
        for(int i=left;i<=right;i++){
            ListNode fwd = tmpCurr.next;
            tmpCurr.next = tmpPrev;
            tmpPrev = tmpCurr;
            tmpCurr = fwd;
        }
        
        // chain the lists correctly
        prev.next = tmpPrev;
        curr.next = tmpCurr;
    
        //return head of the original linked list
        return fakeHead.next;
    }
    
}