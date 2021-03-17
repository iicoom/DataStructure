/**
 * Created by mxj on 2021/3/16 8:24 上午
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
