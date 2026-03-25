class Vehicle {
    private String number;
    private String color;
    private String make;
    private VehicleType vehicleType;

    public Vehicle(String number, String color, String make, VehicleType vehicleType) {
        this.number = number;
        this.color = color;
        this.make = make;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}