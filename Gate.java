class Gate {
    private int gateId;
    private int floorId;
    private GateType gateType;

    public Gate(int gateId, int floorId, GateType gateType) {
        this.gateId = gateId;
        this.floorId = floorId;
        this.gateType = gateType;
    }

    public int getGateId() {
        return gateId;
    }

    public int getFloorId() {
        return floorId;
    }
}