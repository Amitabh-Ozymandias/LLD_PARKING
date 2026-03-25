import java.util.*;

class Floor {
    private int floorId;
    private List<ParkingSlot> slots;
    private List<Gate> gates;

    public Floor(int floorId) {
        this.floorId = floorId;
        this.slots = new ArrayList<>();
        this.gates = new ArrayList<>();
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public int getFloorId() {
        return floorId;
    }
}