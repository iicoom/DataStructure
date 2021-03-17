import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE)); // 生成一个从0到Int的最大值之间的一个随机数
        for (int i = 0; i < opCount; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime -startTime) / 1000000000.0;
    }
    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time:" + time1 + "s");

        LoopQueue<Integer> LoopQueue = new LoopQueue<>();
        double time2 = testQueue(LoopQueue, opCount);
        System.out.println("LoopQueue, time:" + time2 + "s");
    }
}
//ArrayQueue, time:5.096521021s
//LoopQueue, time:0.01879446s