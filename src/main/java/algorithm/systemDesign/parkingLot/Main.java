package algorithm.systemDesign.parkingLot;


public class Main {
    public static void main(String[] args) {
        //initialize parkingLot
        ParkingLot parkingLot = new ParkingLot("City Center Parking");

        // add parking spot
        parkingLot.addParkingSpot(ParkingSpotType.COMPACT, new CompactParkingSpot("C1"));
        parkingLot.addParkingSpot(ParkingSpotType.LARGE, new LargeParkingSpot("L1"));
        parkingLot.addParkingSpot(ParkingSpotType.ELECTRIC, new ElectricParkingSpot("E1"));

        // add and park cars
        Vehicle car1 = new Car("ABC123");
        Vehicle eCar1 = new ElectricalCar("CDG798");
        Vehicle truck1 = new Truck("HKD654");
        Ticket ticket1 = parkingLot.parkVehicle(car1, ParkingSpotType.COMPACT);
        Ticket ticket2 = parkingLot.parkVehicle(eCar1, ParkingSpotType.ELECTRIC);
        Ticket ticket3 = parkingLot.parkVehicle(truck1, ParkingSpotType.LARGE);

        // display status
        parkingLot.displayStatus();

        // count parking fees
        double fee1 = parkingLot.leaveVehicle(ticket1.getTicketId());
        System.out.println("Parking fee for car1: " + fee1);
        double fee2 = parkingLot.leaveVehicle(ticket2.getTicketId());
        System.out.println("Parking fee for eCar1: " + fee2);
        double fee3 = parkingLot.leaveVehicle(ticket3.getTicketId());
        System.out.println("Parking fee for truck1: " + fee3);
        // display status
        parkingLot.displayStatus();
    }
}

