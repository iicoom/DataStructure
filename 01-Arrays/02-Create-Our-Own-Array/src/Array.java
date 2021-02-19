/**
 * Created by mxj on 2021/2/18 11:19 上午
 */
public class Array {
    // 类的成员变量设置为private属性 保护类的封装性
    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
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
    public void add(int index, int e) {

        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <=size");

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
    public void push(int e) {
        add(size, e);
    }

    /**
     * 向data最前面添加元素
     * @param e
     */
    public void shift(int e) {
        add(0, e);
    }
}
