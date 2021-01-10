public class HasCycleII {
	//hash表实现，使用hash表存储访问过的节点，如果中途又被访问到，说明此链表有环，但是这个空间复杂度是O(n)
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