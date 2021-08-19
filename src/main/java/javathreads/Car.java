package javathreads;

import java.util.concurrent.ThreadLocalRandom;

import static javathreads.ParkingManager.getFreeParkingPlace;

public class Car implements Runnable {

    private final String carNumber;
    public static final int MILLIS_TO_WAIT_FOR_AVAILABLE_PARKING = 3000;
    private static final int MILLIS_TO_OCCUPY_PARKING_PLACE = 2000;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void launchParkingTask() {
        ParkingPlace parkingPlace = getFreeParkingPlace();
        if (parkingPlace == null) {
            System.out.printf(
                    "I'm car '%s', I am waited for %s millis, will find another place somewhere else %n",
                    getCarNumber(),
                    MILLIS_TO_WAIT_FOR_AVAILABLE_PARKING
            );
        } else {
            parkingPlace.occupy(this);
            parkForTime(MILLIS_TO_OCCUPY_PARKING_PLACE + addRandomNumberOfMillis(900, 2000));
            parkingPlace.release();
        }
    }

    public synchronized void parkForTime(int timeMillis) {
        try {
            wait(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
        System.out.printf("Car '%s' has been parked for '%s' millis %n", getCarNumber(), timeMillis);
    }

    private static int addRandomNumberOfMillis(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public void run() {
        launchParkingTask();
    }
}
