/**
 * Created by mxj on 2021/3/27 4:15 下午
 *
 * ListNode 类具有
 * 1. val 属性为int类型；
 * 2. 有next属性 为ListNode类型；
 * 3. 有ListNode方法 接受一个int类型的参数x，并且可以给ListNode类的val属性赋值为x
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 用于自己调试：链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
