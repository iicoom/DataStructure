/**
 * Created by mxj on 2021/3/15 9:43 下午
 *
 * 在 SolutionAll 类中声明了 Array，ArrayStack 内部类 和 Stack 接口，供isValid调用
 */
public class SolutionAll {

    private class Array<E> {
        // 类的成员变量设置为private属性 保护类的封装性
        private E[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array, 完成对成员变量的赋值
        public Array(int capacity) {
            //  data = new E[capacity]; // 不能直接这样
            data = (E[])new Object[capacity]; // Object类是任意类的父类 然后再强制类型转换
            size = 0;
        }

        // 无参数的构造函数，默认数组的容量capacity=10
        public Array() {
            this(10);
        }

        // 获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        // 获取数组中元素个数
        public int getSize() {
            return size;
        }

        // 返回数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 给数组data中指定位置添加元素
         * @param index 位置
         * @param e 要添加的元素
         */
        public void add(int index, E e) {

//        if (size == data.length)
//            throw new IllegalArgumentException("Add failed. Array is full");

            if (index < 0 || index > size) // 这里 index > size 保证添加到data的元素是紧密排列的
                throw new IllegalArgumentException("Add failed. Require index >=0 and index <=size");

            if (size == data.length)
                resize(2 * data.length);

            for (int i = size - 1; i >= index; i --) {
                data[i+1] = data[i];
            }
            data[index] = e;
            size ++;
        }

        /**
         * 向data末尾添加元素
         * @param e 添加的目标元素
         */
        public void push(E e) {
            add(size, e);
        }

        /**
         * 向data最前面添加元素
         * @param e
         */
        public void shift(E e) {
            add(0, e);
        }

        /**
         * 获取data传入索引位置的元素
         * @param index
         * @return
         */
        E get(int index) {
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Get failed. index is Illegal");
            return data[index];
        }

        public E getLast() {
            return get(size-1);
        }

        public E getFirst() {
            return get(0);
        }

        /**
         * 设置data传入索引位置的元素
         * @param index
         * @param e
         */
        void set(int index, E e) {
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Get failed. index is Illegal");
            data[index] = e;
        }

        /**
         * 检测数组中是否存在传入的元素
         * @param e
         * @return
         */
        public boolean contains(E e) {
            for (int i = 0; i < size; i ++) {
                // if (data[i] == e) // 之前的值比较要改成引用比较
                if (data[i].equals(e))
                    return true;
            }
            return false;
        }

        /**
         * 查找传入元素在data中的索引
         * @param e
         * @return
         */
        public int find(E e) {
            for (int i = 0; i < size; i ++) {
                if (data[i].equals(e))
                    return i;
            }
            return -1;
        }

        /**
         * 从数组中删除指定位置的元素
         * @param index
         * @return
         */
        public E remove(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Add failed. Require index >=0 and index <=size");

            E ret = data[index];
            for (int i = index; i < size - 1; i ++) {
                data[i] = data[i + 1];
            }
            size --;
            data[size] = null; // loitering object != memory leak

//        if (size == data.length / 2)
            if (size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
            return ret;
        }

        /**
         * 删除数组中的第一个元素
         * @return
         */
        public E unshift() {
            return remove(0);
        }

        /**
         * 删除数组中最后一个元素
         * @return
         */
        public E pop() {
            return remove(size - 1);
        }

        /**
         * 如果数组中存在传入的元素则删除
         * 如果data中有重复元素 此方法只会删除第一个e
         * @param e
         */
        public void removeElement(E e) {
            int index = find(e);
            if (index != -1) {
                remove(index);
            }
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
            res.append("[");
            for (int i = 0; i < size; i ++) {
                res.append(data[i]);
                if (i != size - 1)
                    res.append(", ");
            }
            res.append("]");
            return res.toString();
        }

        /**
         * data 扩容
         * @param newCapacity 新容积
         */
        private void resize(int newCapacity) {
            E[] newData = (E[])new Object[newCapacity];
            for (int i = 0; i < size; i ++)
                newData[i] = data[i];
            data = newData;
        }
    }

    private interface Stack<E> {

        int getSize();
        boolean isEmpty();
        void push(E e);
        E pop();
        E peek();
    }

    private class ArrayStack<E> implements Stack<E> {
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

    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new SolutionAll()).isValid("()[]{}"));
        System.out.println((new SolutionAll()).isValid("()[{}"));
    }
}
