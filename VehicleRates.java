abstract class VehicleRates {
    private double daily;
    private double weekly;
    private double monthly;
    private double mileage;
    private double dailyInsur;
    
    public VehicleRates(double daily, double weekly, double monthly, double mileage, double dailyInsur) {
        this.daily = daily;
        this.weekly = weekly;
        this.monthly = monthly;
        this.mileage = mileage;
        this.dailyInsur= dailyInsur;
    }

    public double getDailyRate() {
        return daily;
    } 

    public double getWeeklyRate() {
        return weekly;
    }

    public double getMonthlyRate() {
        return monthly;
    }

    public double getMileageChrg() {
        return mileage;
    } 

    public double getDailyInsurRate() {
        return dailyInsur;
    }
    
    public abstract String toString(); 
}
