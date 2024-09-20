package algorithm.systemDesign.parkingLot;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "CompactParkingSpot{id='" + super.toString() + "'}";
    }
}

