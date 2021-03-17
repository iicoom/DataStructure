/**
 * Created by mxj on 2021/3/16 8:26 上午
 *
 * Queue-队列
 * 1. 队列也是一种线性结构
 * 2. 相比于数组，队列的操作是数组的子集
 * 3. 只能从一端（尾端）添加元素，只能从（队首）取出元素
 * 4. 队列是一种先进先出的数据结构 First In First Out(FIFO)
 *
 * 5. 数组队列的复杂度分析
 * void enqueue(E) O(1) 均摊
 * E dequeue()     O(n)
 * E front()       O(1)
 * int getSize()   O(1)
 * boolean isEmpty() O(1)
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e){
        array.push(e);
    }

    @Override
    public E dequeue(){
        return array.unshift();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i ++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
