public class CarRates extends VehicleRates {
    private double daily;
    private double weekly;
    private double monthly;

    public CarRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg, double daily_insur_rate) {
        super(daily_rate, weekly_rate, monthly_rate, mileage_chrg, daily_insur_rate);
        daily = daily_rate;
        weekly = weekly_rate;
        monthly = monthly_rate;
    }

    public double getDaily() {
        return daily;
    }

    public double getWeekly() {
        return weekly;
    }

    public double getMonthly() {
        return monthly;
    }

    public String toString() {
        return "Daily- $"+daily+" Weekly- $"+weekly+" Monthly- $"+monthly;
    }
    
}