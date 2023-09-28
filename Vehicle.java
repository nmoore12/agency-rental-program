abstract class Vehicle {
    private String description;
    private int mpg;
    String vin;
    private Reservation resv;
    private VehicleRates rates;

    public Vehicle(String description, int mpg, String vin) {
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        resv = null; 
        rates = null; 
    }

    public String getDescription() {
        return description;
    }
    public int getMpg() {
        return mpg;
    }
    public String getVIN() {
        return vin;
    }

    public VehicleRates getQuotedRates() {
        return rates;
    }

    public Reservation getReservation() {
        return resv;
    } 

    public boolean isReserved() {
        if(resv != null) {
            return true;
        }
        return false;
    }

    public void reserve(Reservation r) {
        if(resv == null) {
            resv = r;
        } else {
            System.out.println("Vehicle Already Reserved");
        }
    } 

    public void cancelReservation() {
      if( resv != null) {
          resv = null;
      } else {
        System.out.println("No Reservation Found");
      }
    } 

    public abstract String toString();
}