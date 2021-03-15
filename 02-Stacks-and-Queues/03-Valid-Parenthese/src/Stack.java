/**
 * Created by mxj on 2021/3/15 9:35 下午
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
