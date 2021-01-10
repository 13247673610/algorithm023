/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
       //递归解法
       if(head == null || head.next == null) return head;
    //    ListNode temp = reverseList(head.next);
    //    head.next.next = head;
    //    head.next = null;
    //    return temp;
    //迭代解法
        ListNode curr = head;
        while(head.next != null){
            ListNode temp = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = temp;
        }
        return curr;
    }
}