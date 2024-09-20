package algorithm.systemDesign.parkingLot;

public class Ticket {
    private String ticketId;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = generateTicketId();
        this.entryTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.spot = spot;
    }

    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}

