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
        //�ݹ� + ��ת����
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        for(int i = 0 ; i < k ; i++){
            if(tail == null) return head;
            tail = tail.next;
        }
		//��תһ��
        ListNode newHead = reverse(head,tail);
		//ָ�򷵻���һ���Ѿ���ת�õ�����
        head.next = reverseKGroup(tail,k);
        return newHead;
       
    }
    public static ListNode reverse(ListNode head,ListNode tail){
        //curr ��¼����ÿ�η�ת���������ͷ�ڵ�
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