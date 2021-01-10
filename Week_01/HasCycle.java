public class HasCycle {
	//hash��ʵ�֣�ʹ��hash��洢���ʹ��Ľڵ㣬�����;�ֱ����ʵ���˵���������л�����������ռ临�Ӷ���O(n)
    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head){
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head){
        //��check
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
