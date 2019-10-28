/**
 * Created by mxj on 2019/10/27 5:46 PM
 */

/**
 * 自定义一个Array类
 * 类的成员变量一般都是私有的，这样可以不破坏类的封装性
 * 用户只能访问类的方法接口
 */
public class Array {

    // 设置类的私有成员变量，data数组的元素只能为int型
    private int[] data;
    private int size;

    // 声明构造函数Array，需要传入参数即数组的容量，初始化一个容量为capacity的data数组
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 声明一个不需要传参的数组
    public Array() {
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组最后端为空的位置添加一个元素
    public void addLast(int e) {
//        if (data.length == size) {
//            throw new IllegalArgumentException("AddLast failed, Array is full!");
//        }
//
//        data[size] = e;
//        size++;
        add(size, e);
    }

    // 向数组头部添加一个元素
    public void addFirst(int e) {
        add(0, e);
    }

    // 在第index位置插入一个元素
    public void add(int index, int e) {
        if (data.length == size)
            throw new IllegalArgumentException("AddLast failed, Array is full!");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size!");

        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }

    // 获取index数组元素的值
    int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. index is Illegal!");
        return data[index];
    }

    // 修改数组index处的元素值
    int set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. index is Illegal!");
        return data[index] = e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity =%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
