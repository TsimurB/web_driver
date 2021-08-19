package javathreads;

import static javathreads.ParkingManager.listOfAvailablePlaces;

public class ParkingPlace {

    public int placeNumber;
    private Car occupiedByCar;

    public ParkingPlace(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void occupy(Car car) {
        occupiedByCar = car;
        System.out.printf("Car '%s' has arrived at parking and occupied parking place '%s'%n",
                occupiedByCar.getCarNumber(), this.getPlaceNumber());
    }

    public void release() {
        System.out.printf("Car '%s' has left the parking place%n", occupiedByCar.getCarNumber());
        occupiedByCar = null;
        listOfAvailablePlaces.add(this);
    }
}
