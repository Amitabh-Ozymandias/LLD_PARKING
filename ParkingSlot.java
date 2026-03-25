import java.util.concurrent.locks.ReentrantLock;

class ParkingSlot {
    private int slotId;
    private SlotType slotType;
    private boolean occupied;
    private ReentrantLock lock = new ReentrantLock();

    public ParkingSlot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.occupied = false;
    }

    public boolean occupy() {
        lock.lock();
        try {
            if (occupied) return false;
            occupied = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            occupied = false;
        } finally {
            lock.unlock();
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getSlotId() {
        return slotId;
    }
}