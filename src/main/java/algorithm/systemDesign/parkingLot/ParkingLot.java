package algorithm.systemDesign.parkingLot;

import java.util.*;

public class ParkingLot {
    private String name;
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;  // 每种类型的停车位列表
    private Map<String, Ticket> activeTickets;  // 正在使用的停车票

    public ParkingLot(String name) {
        this.name = name;
        this.parkingSpots = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    // 添加停车位
    public void addParkingSpot(ParkingSpotType type, ParkingSpot spot) {
        parkingSpots.computeIfAbsent(type, k -> new ArrayList<>()).add(spot);
    }

    // 分配空闲停车位
    public ParkingSpot findAvailableSpot(ParkingSpotType type) {
        List<ParkingSpot> spots = parkingSpots.get(type);
        if (spots == null) {
            return null;
        }
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;  // 无空闲车位
    }

    // 生成停车票
    public Ticket parkVehicle(Vehicle vehicle, ParkingSpotType type) {
        ParkingSpot spot = findAvailableSpot(type);
        if (spot == null) {
            System.out.println("No available spots for this vehicle type.");
            return null;
        }
        spot.park(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    // 车辆离开
    public double leaveVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket.");
            return -1;
        }
        ticket.getSpot().release();
        return calculateParkingFee(ticket);
    }

    // 计算停车费用
    private double calculateParkingFee(Ticket ticket) {
        long duration = System.currentTimeMillis() - ticket.getEntryTime();
        // 假设每小时收费10元
        return (duration / (1000 * 60 * 60)) * 10;
    }

    // 查看实时停车状态
    public void displayStatus() {
        for (Map.Entry<ParkingSpotType, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            System.out.println(entry.getKey() + " spots: ");
            for (ParkingSpot spot : entry.getValue()) {
                System.out.println(spot);
            }
        }
    }
}

