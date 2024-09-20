package algorithm.systemDesign.parkingLot;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "LargeParkingSpot{id='" + super.toString() + "'}";
    }
}

