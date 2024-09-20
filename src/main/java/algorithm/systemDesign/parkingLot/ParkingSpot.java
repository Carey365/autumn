package algorithm.systemDesign.parkingLot;

public abstract class ParkingSpot {
    private String id;
    private boolean available;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id) {
        this.id = id;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.available = false;
    }

    public void release() {
        this.parkedVehicle = null;
        this.available = true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{id='" + id + "', available=" + available + '}';
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}

