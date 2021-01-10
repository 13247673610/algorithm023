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
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        //递归 + 反转链表
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        for(int i = 0 ; i < k ; i++){
            if(tail == null) return head;
            tail = tail.next;
        }
		//反转一组
        ListNode newHead = reverse(head,tail);
		//指向返回下一组已经反转好的链表
        head.next = reverseKGroup(tail,k);
        return newHead;
       
    }
    public static ListNode reverse(ListNode head,ListNode tail){
        //curr 记录的是每次反转后新链表的头节点
        ListNode curr = head;
        while(head.next != tail){
            ListNode temp = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = temp;
        }
       return curr;
    }
}