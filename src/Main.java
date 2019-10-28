/**
 * Created by mxj on 2019/10/28 1:41 PM
 */
public class Main {

    public static void main(String[] args) {

        Array arr = new Array(20);

        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(3, 12);
        System.out.println(arr);

        arr.addFirst(007);
        System.out.println(arr);

        arr.addLast(100);
        System.out.println(arr);
    }
}

/*
1.
如果Array类上边没有toString方法，就会打印出下面的结果：
Array@60e53b93

如果Array类有 @override toString, 打印结果如下：
Array: size = 11, capacity =20
[0,1,2,3,4,5,6,7,8,9,1011,]

2.
验证for循环 i 的最大值
0
1
2
3
4
5
6
7
8
9
Array: size = 10, capacity =20
[0,1,2,3,4,5,6,7,8,9]

3. 测试arr.add、arr.addFirst、 arr.addLast


 */