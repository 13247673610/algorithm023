public class HasCycleII {
	//hash��ʵ�֣�ʹ��hash��洢���ʹ��Ľڵ㣬�����;�ֱ����ʵ���˵���������л�����������ռ临�Ӷ���O(n)
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return null;
		ListNode slow = head;
		ListNode fast = fast;
		while(true){
			if(fast == null || fast.next == null) return null;
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		fast = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
    }
}