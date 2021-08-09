package javathreads;

import java.util.concurrent.BlockingQueue;

public class MainParking {

    public static void main(String[] args) {
        BlockingQueue<CarPlace> blockingQueue = new ArrayBlockingQueue<>(10);
    }
}
