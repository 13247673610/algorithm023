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
 // 1->2->3->4
 // 2->1->4->3
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //�ݹ�ⷨ
        if(head == null || head.next == null){
            return head;
        }
        //temp ��¼�������µ�ͷ�ڵ�
    //    ListNode temp = head.next;
    //    head.next = swapPairs(temp.next);
    //    temp.next = head;
    //    return temp;
        // ListNode temp = head.next;
        // head.next = swapPairs(temp.next);
        // temp.next = head;
        // return temp;

        //�����ⷨ
        ListNode prev = new ListNode(-1);
		//prevָ��һֱָ���µ�ͷ���
        prev.next = head;
		//temp��Ϊhead�Ĵ���
        ListNode temp = prev;
        while(temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return prev.next;
    }
}