class Truck extends Vehicle {
    private String make;
    private int mpg;
    private int load;
    private String vin;

    public Truck(String make, int mpg, int load, String vin) {
        super(make, load, vin);
        this.make = make;
        this.mpg = mpg;
        this.load = load;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public int getMPG() {
        return mpg;
    }

    public int getLoad() {
        return load;
    }

    public String getVIN() {
        return vin;
    }

    public String toString() {
        return ""+make+"     "+mpg+" mpg     "+load+" lbs.     "+vin;
    }
}