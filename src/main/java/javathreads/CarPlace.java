package javathreads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CarPlace {
    private final int PlaceNumber;
    private volatile boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void takePlace(boolean occupied) {
        this.occupied = occupied;
    }

    public CarPlace(int placeNumber) {
        this.PlaceNumber = placeNumber;
    }

    public void standing() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "carPlace {#" + PlaceNumber + '}';
    }
}
