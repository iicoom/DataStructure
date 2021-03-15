/**
 * Created by mxj on 2021/2/20 10:31 下午
 *
 * ArrayStack 实现了 Stack 接口中的方法，需要用到 @Override 注解
 * 内部引入了支持泛型的 Array 类
 *
 * 分别定义了ArrayStack(int capacity)接受容积参数的 和无参ArrayStack() 构造函数
 * 本质上就是 使用Array类，并包装了Array类的一些方法
 */
public class ArrayStack<E> implements Stack<E> {
    // 引入 Array 类
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.push(e);
    }

    @Override
    public E pop() {
        return array.pop();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
         StringBuilder res = new StringBuilder();
         res.append("Stack: ");
         res.append('[');
         for (int i = 0; i < array.getSize(); i ++) {
             res.append(array.get(i));
             if (i < array.getSize() - 1)
                 res.append(", ");
         }
         res.append("] top");
         return res.toString();
    }
}
