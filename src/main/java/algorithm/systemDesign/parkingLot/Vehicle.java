package algorithm.systemDesign.parkingLot;

public abstract class Vehicle {
    private String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Vehicle{licensePlate='" + licensePlate + "'}";
    }
}

