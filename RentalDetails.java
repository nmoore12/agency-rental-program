public class RentalDetails {
    private int vehicleType;
    private TimeSpan rentalPeriod;
    private int estNumMiles;
    private boolean insurSelected;
    private boolean prime;

    public RentalDetails(int vehicleType, TimeSpan rentalPeriod, int estNumMiles, boolean insurSelected, boolean prime) {
        this.vehicleType = vehicleType;
        this. rentalPeriod = rentalPeriod;
        this. estNumMiles = estNumMiles;
        this. insurSelected = insurSelected;
        this.prime = prime;
    }

    public int getType() {
        return vehicleType;
    }

    public TimeSpan getRental() {
        return rentalPeriod;
    }

    public int getMiles() {
        return estNumMiles;
    }

    public boolean getInsur() {
        return insurSelected;
    }

    public boolean getPrime() {
        return prime;
    }
}