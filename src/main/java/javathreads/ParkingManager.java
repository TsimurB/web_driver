package javathreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static javathreads.Car.MILLIS_TO_WAIT_FOR_AVAILABLE_PARKING;

public class ParkingManager {

    private static final int NUMBER_OF_PARKING_PLACES = 2;
    private static final int NUMBER_OF_CARS = 4;
    public static BlockingQueue<ParkingPlace> listOfAvailablePlaces = new ArrayBlockingQueue<ParkingPlace>(NUMBER_OF_PARKING_PLACES);

    public static void main(String[] args) {
        listOfAvailablePlaces.addAll(initParkingPlaces(NUMBER_OF_PARKING_PLACES));

        List<Car> listOfCars = initCars(NUMBER_OF_CARS);

        listOfCars.forEach(car -> {
            var thread = new Thread(car, String.format("Route for car '%s'", car.getCarNumber()));
            System.out.printf("%s has been created%n", thread.getName());
            thread.start();
        });
    }

    private static List<ParkingPlace> initParkingPlaces(int numberOfPlaces) {
        List<ParkingPlace> listOfPlaces = new ArrayList<>();
        for (int i = 0; i < numberOfPlaces; i++) {
            listOfPlaces.add(new ParkingPlace(i));
        }
        return listOfPlaces;
    }

    private static List<Car> initCars(int numberOfCars) {
        List<Car> listOfCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            listOfCars.add(new Car("Gomel-Texas " + i));
        }
        return listOfCars;
    }

    public static ParkingPlace getFreeParkingPlace() {
        try {
            return listOfAvailablePlaces.poll(MILLIS_TO_WAIT_FOR_AVAILABLE_PARKING, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
//        return listOfAvailablePlaces.stream()
//                .filter(e -> !e.isOccupied())
//                .findAny()
//                .orElse(null);
    }
}
