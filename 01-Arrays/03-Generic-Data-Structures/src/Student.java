/**
 * Created by mxj on 2021/2/21 12:03 下午
 */
public class Student {

    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<Student> arr = new Array<>();
        arr.push(new Student("Alice", 100));
        arr.push(new Student("Bob", 66));
        arr.push(new Student("Charlie", 88));
        System.out.println(arr);
    }
}
