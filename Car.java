class Car extends Vehicle {
    private String make = "";
    private int year;
    private int mpg;
    private int seat;
    private String vin = "";

    public Car(String make, int year, int mpg, int seat, String vin) {
        super(make, seat, vin);
        this.make = make;
        this.year = year;
        this.mpg = mpg;
        this.seat = seat;
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getSeat() {
        return seat;
    }

    public String getVIN() {
        return vin;
    }

    public String toString() {
        return ""+make+" - "+year+"     "+mpg+" mpg      "+seat+"     "+vin;
    }
}