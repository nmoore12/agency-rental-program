public class Transaction {
    private String creditcard_num;
    private String company_name;
    private String vehicle_type; 
    private String rental_period; 
    private String miles_driven;
    private String rental_cost;

    public Transaction(String creditcard_num, String company_name, String vehicle_type, String rental_period, String miles_driven, String rental_cost) {
        this.creditcard_num = creditcard_num;
        this.company_name = company_name;
        this.vehicle_type = vehicle_type;
        this.rental_period = rental_period;
        this.miles_driven = miles_driven;
        this.rental_cost = rental_cost;
    }

    public String getCredit() {
        return creditcard_num;
    }

    public String getCompany() {
        return company_name;
    }

    public String getVehicleType() {
        return vehicle_type;
    }

    public String getRentalPeriod() {
        return rental_period;
    }

    public String getMilesDriven() {
        return miles_driven;
    }

    public String getRentalCost() {
        return rental_cost;
    }


    public String toString() {
        return ""+creditcard_num+" "+company_name+" "+vehicle_type+rental_period+" "+miles_driven+rental_cost;
    }
}