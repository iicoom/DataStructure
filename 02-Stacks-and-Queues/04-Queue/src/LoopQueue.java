/**
 * Created by mxj on 2021/3/17 8:02 上午
 *
 * data = (E[])new Object[capacity + 1];
 * 1. new Object[capacity + 1] 初始化数组 开辟 capacity + 1 的空间
 * 2. (E[])new Object[capacity + 1] 强制类型转换 使开辟的数组可以存放任意类型的数据
 */
public class LoopQueue<E> implements Queue<E> {

    // 成员变量
    private E[] data;
    private int front, tail;
    private int size;

    // 有参构造函数
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    // 无参构造函数，调用的this 就是上边的有参构造函数
    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void enqueue(E e){

        if ((tail + 1) % data.length == front) { // 队列已满
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length]; // 1. 注意原队列中元素相对于i有front偏移 2. 且有index可能大于数组最后一个位置
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
