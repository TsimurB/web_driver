package javathreads;

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
    }

    public boolean isOccupied() {
        return occupiedByCar != null;
    }
}
