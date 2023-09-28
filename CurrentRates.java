public class CurrentRates {
    private VehicleRates[] rates = new VehicleRates[3];

    public CurrentRates() {
        rates[0] = new CarRates(24.95, 169.95, 514.95, 0.16, 14.95);
        rates[1] = new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95);
        rates[2] = new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95);
    }
    public VehicleRates getCarRates() {
        return rates[0];
    } 

    public VehicleRates getSUVRates() {
        return rates[1];
    } 

    public VehicleRates getTruckRates() {
        return rates[2];
    } 

    public void setCarRates(VehicleRates r){
        rates[0] = new CarRates(r.getDailyRate(),r.getWeeklyRate(),r.getMonthlyRate(),r.getMileageChrg(),r.getDailyInsurRate());
    }

    public void setSUVRates(VehicleRates r){
        rates[1] = new SUVRates(r.getDailyRate(),r.getWeeklyRate(),r.getMonthlyRate(),r.getMileageChrg(),r.getDailyInsurRate());
    }

    public void setTruckRates(VehicleRates r){
        rates[2] = new TruckRates(r.getDailyRate(),r.getWeeklyRate(),r.getMonthlyRate(),r.getMileageChrg(),r.getDailyInsurRate());
    }

    public double calcEstimatedCost(int vehicleType,TimeSpan estimatedRentalPeriod, int estimatedNumMiles, boolean dailyInsur, boolean primeCustomer) {
        if(vehicleType == 1 && estimatedRentalPeriod.getTime() == 'd' || estimatedRentalPeriod.getTime() == 'D') {
            double carRate = 0.0;
            int numDays = estimatedRentalPeriod.getNum();

            carRate = 24.95 * (14.95*numDays) + (0.16*estimatedNumMiles);

            return carRate;
        }

        if(vehicleType == 1 && estimatedRentalPeriod.getTime() == 'w' || estimatedRentalPeriod.getTime() == 'W') {
            double carRate = 0.0;
            int numWeeks = estimatedRentalPeriod.getNum();

            carRate = 169.95 * numWeeks + (0.16*estimatedNumMiles);

            return carRate;
        }

        if(vehicleType == 1 && estimatedRentalPeriod.getTime() == 'm' || estimatedRentalPeriod.getTime() == 'M') {
            double carRate = 0.0;
            int numMonths = estimatedRentalPeriod.getNum();

            carRate = 514.95 * numMonths + (0.16*estimatedNumMiles);

            return carRate;
        }

        return 0;
     }

     public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven, boolean dailyInsur, boolean primeCustomer) {
        return NumMilesDriven;
         
     }

     public String toString() {
         return "Car Rates: "+rates[0]+" SUV Rates: "+rates[1]+" Truck Rates: "+rates[2];
     }

}