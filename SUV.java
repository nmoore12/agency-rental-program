class SUV extends Vehicle {
    private String make;
    private int mpg;
    private int seat;
    private int cargo;
    private String vin;

    public SUV(String make, int mpg, int seat, int cargo, String vin) {
        super(make, cargo, vin);
        this.make = make;
        this.mpg = mpg;
        this.seat = seat;
        this.cargo = cargo;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public int getMPG() {
        return mpg;
    }

    public int getSeat() {
        return seat;
    }

    public int getCargo() {
        return cargo;
    }

    public String getVIN() {
        return vin;
    }

    public String toString() {
        return ""+make+" - "+mpg+" mpg     "+seat+"     "+cargo+" cubic ft.     "+vin;
    }
}