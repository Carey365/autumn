package algorithm.systemDesign.parkingLot;

public class ElectricParkingSpot extends ParkingSpot {
    public ElectricParkingSpot(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "ElectricParkingSpot{id='" + super.toString() + "'}";
    }
}

