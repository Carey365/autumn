package algorithm.systemDesign.parkingLot;


public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("City Center Parking");

        // 添加停车位
        parkingLot.addParkingSpot(ParkingSpotType.COMPACT, new CompactParkingSpot("C1"));
        parkingLot.addParkingSpot(ParkingSpotType.LARGE, new LargeParkingSpot("L1"));
        parkingLot.addParkingSpot(ParkingSpotType.ELECTRIC, new ElectricParkingSpot("E1"));

        // 停车
        Vehicle car1 = new Car("ABC123");
        Ticket ticket1 = parkingLot.parkVehicle(car1, ParkingSpotType.COMPACT);

        // 停车场状态
        parkingLot.displayStatus();

        // 车辆离场
        double fee1 = parkingLot.leaveVehicle(ticket1.getTicketId());
        System.out.println("Parking fee for car1: " + fee1);

        // 停车场状态
        parkingLot.displayStatus();
    }
}

