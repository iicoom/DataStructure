/**
 * Created by mxj on 2019/10/27 5:46 PM
 */

/**
 * 自定义一个Array类
 * 类的成员变量一般都是私有的，这样可以不破坏类的封装性
 * 用户只能访问类的方法接口
 */
/*
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
*/

/**
 * 现在要把数组类改成支持泛型的形式
 */
public class Array<E> {

    // 设置类的私有成员变量，data数组的元素使用泛型声明后可以放置任意类型数据
    private E[] data;
    private int size;

    // 声明构造函数Array，需要传入参数即数组的容量，初始化一个容量为capacity的data数组
    public Array(int capacity) {
        data = (E[])new Object[capacity];  // 构造函数中data声明用到new Object强制类型转换
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
//  public void addLast(int e) {       // 由于add方法参数e 已经写成E 类型，此行也需要声明参数为E
    public void addLast(E e) {
        add(size, e);
    }

    // 向数组头部添加一个元素
//  public void addFirst(int e) {
    public void addFirst(E e) {        // 由于add方法参数e 已经写成E 类型，此行也需要声明参数为E
        add(0, e);
    }

    // 在第index位置插入一个元素
//  public void add(int index, int e) {
    public void add(int index, E e) {
        if (data.length == size)
            throw new IllegalArgumentException("AddLast failed, Array is full!");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size!");

        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];

        data[index] = e;               // 最上边的私有成员变量data已经声明为E类型，这里如果add参数仍为int e 此行将报错：Incompatible Types. Required: E, Found: int
        size ++;
    }

    // 获取index数组元素的值
//  int get(int index) {
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. index is Illegal!");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    // 修改数组index处的元素值
//  int set(int index, int e) {
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. index is Illegal!");
        data[index] = e;
    }

    // 查找数组中是否有元素e
//  public boolean contains(int e) {
    public boolean contains(E e) {
        for(int i = 0; i < size; i ++) {
//            if(data[i] == e)          // 现在data[i]和e 都是类对象了，比较需要用equals
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在，返回-1
//  public int find(int e) {
    public int find(E e) {
        for(int i = 0; i < size; i ++) {
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
//  public int remove(int index) {
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. index is Illegal!");
        E ret = data[index];
        for(int i = index + 1; i < size; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null;     // 改为泛型后，数组对象编程对象引用，不会被Java垃圾回收，此处手动清除引用（但此处非必要 loitering objects != memory leak）
        return ret;
    }

    // 删除数组中的第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast() {
        return remove(size-1);
    }

    // 删除元素
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
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
