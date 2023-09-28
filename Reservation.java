class Reservation { 
    private String name;
    private String creditCardNum;
    private TimeSpan rentalPeriod;
    private boolean insuranceSelected;
    
    public Reservation (String name, String creditCardNum, TimeSpan rentalPeriod, boolean insuranceSelected){
        this.name = name;
        this.creditCardNum = creditCardNum;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }

    public String getName() {
        return name;
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

    public String toString() {
        return name+" "+creditCardNum+" "+rentalPeriod+" "+insuranceSelected;
    }

    
}