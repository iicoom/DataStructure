/**
 * Created by mxj on 2021/3/27 4:14 下午
 *
 * 删除链表中值为val的节点的解决方案
 * removeElements 中传入链表头节点和指定要删除的目标值
 *
 * 这个Solution只能提交LeetCode中执行，LeetCode提供了测试用例和ListNode类
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        // 传入的链表头节点不为空，即链表不为空
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 上面的方法会连续删除头节点为指定值得节点，直到链表为空
        if (head == null) return null;

        // 遇到头节点不为指定值得节点，记录头节点为prev,判断他的下一个节点 prev.next
        ListNode prev = head;
        while(prev.next != null) { // 如果链表中还有节点
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}
