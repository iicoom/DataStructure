/**
 * Created by mxj on 2021/2/20 10:29 下午
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
