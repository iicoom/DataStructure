public class Main {

    public static void main(String[] args) {
	// write your code here
        Array arr = new Array(20);
        for (int i = 0; i < 10; i ++) {
            arr.push(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.shift(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}
