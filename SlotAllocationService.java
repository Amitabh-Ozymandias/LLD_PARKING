class SlotAllocationService {

    public ParkingSlot assignNearestSlot(Floor floor, Vehicle vehicle) {

        SlotType required = mapVehicleToSlot(vehicle.getVehicleType());

        for (ParkingSlot slot : floor.getSlots()) {
            if (!slot.isOccupied() && slot.getSlotType() == required) {
                if (slot.occupy()) {
                    return slot;
                }
            }
        }
        return null;
    }

    private SlotType mapVehicleToSlot(VehicleType type) {
        switch (type) {
            case TWO_WHEELER: return SlotType.SMALL;
            case CAR: return SlotType.MEDIUM;
            case BUS: return SlotType.LARGE;
            default: throw new RuntimeException();
        }
    }
}