/**
 * Created by mxj on 2019/11/12 9:19 AM
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
