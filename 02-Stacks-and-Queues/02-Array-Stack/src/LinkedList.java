/**
 * Created by mxj on 2021/3/18 9:19 下午
 *
 * 链表：真正的动态数据结构-最简单的动态数据结构
 * 更深入的理解引用（或者指针）
 * 更深入的理解递归
 * 辅助组成其他数据结构
 *
 * 数据存储在“节点”中
 * 优点：真正的动态，不需要处理固定容量的问题
 * 缺点：丧失了随机访问的能力
 *
 * 时间复杂度分析：
 * 添加操作：
 * addLast(e)   O(n)
 * addFirst(e)  O(1)
 * add(index, e) O(n/2) = O(n)
 *
 * 删除操作：
 * removeLast(e)  O(n)
 * removeFirst(e) O(1)
 * remove(index, e) O(n/2) = O(n)
 *
 * 查找操作：
 * get(index)  O(n)
 * contains(e) O(n)
 *
 * 增删改查都是O(n)级别，如果只对链表头进行操作时O(1)
 *
 * 由此可见链表的优势：只对链表头进行增删查操作，动态数据结构，相比于数组不会浪费内存
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next; // 数据连接作用 最后一个节点存储的next为null

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是常用的操作
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);

        size ++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获取链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size -1);
    }

    // 设置链表中index节点的元素
    public void set(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 判断链表中是否包含元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
//        for (int i = 0; i < size; i ++) {
//            if (cur.e == e) return true;
//            cur = cur.next;
//        }
        while (cur != null){
            if (cur.e.equals(e)) return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中移除指定位置的元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");

        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    // 从链表中移除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个
    public E removeLast() {
        return remove(size-1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }

}
