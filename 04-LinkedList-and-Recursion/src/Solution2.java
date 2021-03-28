/**
 * Created by mxj on 2021/3/27 4:46 下午
 *
 * 使用虚拟头节点解决之前的问题
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        // 是dummyHead成为传入的head之前的节点
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) { // 如果链表中还有节点
            if (prev.next.val == val) {
                prev = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}
