import java.time.LocalDateTime;

class ParkingTicket {
    private int ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private Gate entryGate;
    private LocalDateTime startTime;
    private boolean active;

    public ParkingTicket(int ticketId, Vehicle vehicle, ParkingSlot slot, Gate gate) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryGate = gate;
        this.startTime = LocalDateTime.now();
        this.active = true;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void closeTicket() {
        active = false;
    }
}