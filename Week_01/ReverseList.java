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
       //�ݹ�ⷨ
       if(head == null || head.next == null) return head;
    //    ListNode temp = reverseList(head.next);
    //    head.next.next = head;
    //    head.next = null;
    //    return temp;
    //�����ⷨ
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