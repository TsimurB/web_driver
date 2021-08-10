package javathreads;

import java.util.concurrent.BlockingQueue;

public class Parking {
    private BlockingQueue<CarPlace> blockingQueue;

    public Parking(BlockingQueue<CarPlace> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
}
