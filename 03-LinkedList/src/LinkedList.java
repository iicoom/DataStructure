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
}
