import java.time.Duration;
import java.time.LocalDateTime;

class BillingService {

    public double generateBill(ParkingTicket ticket) {

        LocalDateTime end = LocalDateTime.now();

        long hours = Duration.between(ticket.getStartTime(), end).toHours() + 1;

        SlotType slotType = ticket.getSlot().getSlotType();

        switch (slotType) {
            case SMALL: return hours * 10;
            case MEDIUM: return hours * 20;
            case LARGE: return hours * 50;
            default: return 0;
        }
    }
}