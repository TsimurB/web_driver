package javathreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue<Boolean> bq = new ArrayBlockingQueue<>(10);
        for (int i = 1; i < 51; i++) {
            new Producer(i, bq).start();
        }
        for (int j = 1; j < 51; j++) {
            new Consumer(j, bq).start();
        }
    }
}
