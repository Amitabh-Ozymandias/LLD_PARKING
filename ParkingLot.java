import java.util.*;

class ParkingLot {

    private List<Floor> floors;
    private SlotAllocationService allocationService;
    private BillingService billingService;
    private PaymentService paymentService;
    private int ticketCounter = 1;

    public ParkingLot() {
        floors = new ArrayList<>();
        allocationService = new SlotAllocationService();
        billingService = new BillingService();
        paymentService = new PaymentService();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public ParkingTicket generateParkingTicket(Vehicle vehicle, Gate gate) {

        for (Floor floor : floors) {
            if (floor.getFloorId() == gate.getFloorId()) {

                ParkingSlot slot = allocationService.assignNearestSlot(floor, vehicle);

                if (slot != null) {
                    return new ParkingTicket(ticketCounter++, vehicle, slot, gate);
                }
            }
        }

        return null;
    }

    public void generateBill(ParkingTicket ticket) {

        double amount = billingService.generateBill(ticket);

        paymentService.processPayment(amount);

        ticket.getSlot().release();

        ticket.closeTicket();
    }

    public void showStatus() {

        for (Floor floor : floors) {
            System.out.println("Floor " + floor.getFloorId());

            for (ParkingSlot slot : floor.getSlots()) {
                System.out.println(
                    "Slot " + slot.getSlotId() + " occupied: " + slot.isOccupied()
                );
            }
        }
    }
}