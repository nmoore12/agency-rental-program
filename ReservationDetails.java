public class ReservationDetails {
    private String vin;
    private String creditCardNum;
    private TimeSpan rentalPeriod;
    private boolean insuranceSelected;
    
    public ReservationDetails (String vin, String creditCardNum, TimeSpan rentalPeriod, boolean insuranceSelected){
        this.vin = vin;
        this.creditCardNum = creditCardNum;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }

    public String getVIN() {
        return vin;
    }

    public String getCard() {
        return creditCardNum;
    }

    public TimeSpan getRental() {
        return rentalPeriod;
    }

    public boolean getInsur() {
        return insuranceSelected;
    }


    
}