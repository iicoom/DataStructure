public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i ++) {
            arr.push(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.shift(-1);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.unshift();
        System.out.println(arr);
    }
}
