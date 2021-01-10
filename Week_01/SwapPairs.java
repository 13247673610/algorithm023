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
        //递归解法
        if(head == null || head.next == null){
            return head;
        }
        //temp 记录交换后新的头节点
    //    ListNode temp = head.next;
    //    head.next = swapPairs(temp.next);
    //    temp.next = head;
    //    return temp;
        // ListNode temp = head.next;
        // head.next = swapPairs(temp.next);
        // temp.next = head;
        // return temp;

        //迭代解法
        ListNode prev = new ListNode(-1);
		//prev指针一直指向新的头结点
        prev.next = head;
		//temp作为head的代理
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