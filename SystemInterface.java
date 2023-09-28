public class SystemInterface {
    private static CurrentRates agency_rates;
    private static VehicleRates vehicle_rates;
    private static Vehicles agency_vehicles;
    private static Accounts accounts;
    private static Transactions transactions_history;
    // used to init static variables (in place of a constructor)
    public static void initSystem(CurrentRates r, Vehicles v, Accounts a, Transactions t) {
        agency_rates = r;
        agency_vehicles = v;
        accounts = a;
        transactions_history = t;
    }
    // Note that methods makeReservation, cancelReservation, addAccount, and updateXXXRates return
    // an acknowledgement of successful completion of the requested action (e.g. “Vehicle QK3FL4273ME
    // successfully reserved”). Method processReturnedVehicle returns the final cost for the returned
    // vehicle (e.g., “Total charge for VIN QK3FL4273ME for 3 days, 233 miles @ 0.15/mile and daily
    // insurance @ 14.95/day (with 100 miles credit as Prime customer) = $xxx.xx.)
    // Current Rates Related Methods
    public static String[] getCarRates() {
        int numCarRates = 0;
        Vehicle v;
        agency_vehicles.reset();

        while(agency_vehicles.hasNext()) {
            v = agency_vehicles.getNext();
            if(v instanceof Car) {
                numCarRates = numCarRates + 1;
            }
        }

        String[] carRate = new String[numCarRates];

            int i = 0;
            agency_vehicles.reset();
            while(agency_vehicles.hasNext()) {
                v = agency_vehicles.getNext();
                if(v instanceof Car) {
                    carRate[i++] = agency_rates.toString();
                }
            }

        return carRate;
     }
    public static String[] getSUVRates() {
        int numSUVRates = 0;
        Vehicle v;
        agency_vehicles.reset();

        while(agency_vehicles.hasNext()) {
            v = agency_vehicles.getNext();
            if(v instanceof SUV) {
                numSUVRates = numSUVRates + 1;
            }
        }

        String[] suvRate = new String[numSUVRates];

            int i = 0;
            agency_vehicles.reset();
            while(agency_vehicles.hasNext()) {
                v = agency_vehicles.getNext();
                if(v instanceof SUV) {
                    suvRate[i++] = agency_rates.toString();
                }
            }

        return suvRate;

    }
    public static String[] getTruckRates() {
        int numTruckRates = 0;
        Vehicle v;
        agency_vehicles.reset();

        while(agency_vehicles.hasNext()) {
            v = agency_vehicles.getNext();
            if(v instanceof Truck) {
                numTruckRates = numTruckRates + 1;
            }
        }

        String[] truckRate = new String[numTruckRates];

            int i = 0;
            agency_vehicles.reset();
            while(agency_vehicles.hasNext()) {
                v = agency_vehicles.getNext();
                if(v instanceof Truck) {
                    truckRate[i++] = agency_rates.toString();
                }
            }

        return truckRate;

    }
    public static String[] updateCarRates(VehicleRates r) {
        double daily = r.getDailyRate();
        double weekly = r.getWeeklyRate();
        double monthly = r.getMonthlyRate();
        double mileage = r.getMileageChrg();
        double dailyInsur = r.getDailyInsurRate();

        CarRates car = new CarRates(daily, weekly, monthly, mileage, dailyInsur);
        int index = 0;
        String[] carRates = new String[index];
        carRates[index++] = car.toString();
        return carRates;
    }
    public static String[] updateSUVRates(VehicleRates r) {
        double daily = r.getDailyRate();
        double weekly = r.getWeeklyRate();
        double monthly = r.getMonthlyRate();
        double mileage = r.getMileageChrg();
        double dailyInsur = r.getDailyInsurRate();

        SUVRates suv = new SUVRates(daily, weekly, monthly, mileage, dailyInsur);
        int index = 0;
        String[] suvRates = new String[index];
        suvRates[index++] = suv.toString();
        return suvRates;
    }
    public static String[] updateTruckRates(VehicleRates r) {
        double daily = r.getDailyRate();
        double weekly = r.getWeeklyRate();
        double monthly = r.getMonthlyRate();
        double mileage = r.getMileageChrg();
        double dailyInsur = r.getDailyInsurRate();

        TruckRates truck = new TruckRates(daily, weekly, monthly, mileage, dailyInsur);
        int index = 0;
        String[] truckRates = new String[index];
        truckRates[index++] = truck.toString();
        return truckRates;
    }
    public static String[] estimatedRentalCost(RentalDetails details) {
        return null;

    }
    public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) {
        return null;
    }
    // Note that the rates to be used are retrieved from the VehicleRates object stored in the specific rented
    // vehicle object, the daily insurance option is retrieved from the Reservation object of the rented
    // vehicle, and whether they are a Prime customer is retrived from the Customer Account object vehicle
    // associated with the Reservation object associated with the specific rented vehicle.
    // Vehicle Related Methods
    public static String[] getAvailCars() {
        Vehicle v;
        int num_vehicles = 0;

        agency_vehicles.reset();
     while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof Car && !v.isReserved())
        num_vehicles = num_vehicles + 1;
    }

    String[] results = new String[num_vehicles];

    agency_vehicles.reset();
    int i = 0;
    while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof Car && !v.isReserved()){
        results[i++] = v.toString();
      }
    }

    return results;

    }
    public static String[] getAvailSUVs() {
        Vehicle v;
        int num_vehicles = 0;

        agency_vehicles.reset();
     while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof SUV && !v.isReserved())
        num_vehicles = num_vehicles + 1;
    }

    String[] results = new String[num_vehicles];

    agency_vehicles.reset();
    int i = 0;
    while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof SUV && !v.isReserved()){
        results[i] = v.toString();
        i = i + 1;
      }
    }

    return results;


    }
    public static String[] getAvailTrucks() {
        Vehicle v;
        int num_vehicles = 0;

        agency_vehicles.reset();
     while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof Truck && !v.isReserved())
        num_vehicles = num_vehicles + 1;
    }

    String[] results = new String[num_vehicles];

    agency_vehicles.reset();
    int i = 0;
    while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
      if(v instanceof Truck && !v.isReserved()){
        results[i] = v.toString();
        i = i + 1;
      }
    }

    return results;
    }
    public static String[ ] getAllVehicles() {

        Vehicle v;
        int num_vehicles = 0;

        agency_vehicles.reset();
     while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
        num_vehicles = num_vehicles + 1;
    }

    String[] results = new String[num_vehicles];

    agency_vehicles.reset();
    int i = 0;
    while(agency_vehicles.hasNext()) {
      v = agency_vehicles.getNext();
        results[i++] = v.toString();
      
    }

    return results;

    }

    public static String[] makeReservation(ReservationDetails details) {
        String vin;
        vin = details.getVIN();
        String creditCardNum;
        creditCardNum = details.getCard();
        TimeSpan period;
        period = details.getRental();
        boolean insur;
        insur = details.getInsur();

        

        Reservation resv = new Reservation(vin, creditCardNum, period, insur);
        int numRes = 1;
        String[] res = new String[numRes];
        res[numRes] = resv.toString();
        numRes ++;

        return res;
    }

    public static String[ ] cancelReservation(String credit_card_num, String vin) throws VINNotFoundException {
        return null;

    }
    public static String[ ] getReservation(String vin) throws VINNotFoundException {
        Vehicle v;
        v = agency_vehicles.getVehicle(vin);

        int numVehs = 0;
        agency_vehicles.reset();
        while(agency_vehicles.hasNext() && v.isReserved()) {
            v = agency_vehicles.getNext();
            numVehs = numVehs + 1;
        }

        String[] resv = new String[numVehs];
        int i = 0;
        agency_vehicles.reset();
        while(agency_vehicles.hasNext() && v.isReserved()) {
            v = agency_vehicles.getNext();
            resv[i++] = v.getReservation().toString();
        }    
        return resv;
    }
    
    public static String[ ] getAllReservations() {
        Vehicle v;
        v = agency_vehicles.getNext();
        int numRes = 0;
        agency_vehicles.reset();
        while(agency_vehicles.hasNext() && v.isReserved()) {
            v = agency_vehicles.getNext();
            numRes = numRes + 1;
        }

        String[] allRes = new String[numRes];
        agency_vehicles.reset();
        int i = 0;
        while(agency_vehicles.hasNext() && v.isReserved()) {
            v = agency_vehicles.getNext();
            allRes[i++] = v.getReservation().toString();
        }

        return allRes;

    }
    // Customer Accounts Related Methods
    public static String[ ] addAccount(Account account) {
        String creditcard = account.getCreditCardNumber();
        String company_name = account.getCompanyName();
        boolean prime_cust = account.primeCustomer();

        Account acct = new Account(company_name,creditcard,prime_cust);
        accounts.add(acct);

        int numAccts = 0;
        accounts.reset();
        while(accounts.hasNext()) {
            acct = accounts.getNext();
            numAccts = numAccts + 1;
        }

        String[] addAcct = new String[numAccts];
        int i = 0;
        accounts.reset();
        while(accounts.hasNext()) {
            acct = accounts.getNext();
            addAcct[i++] = acct.toString();
            System.out.println("Account "+company_name+" Successfully Added.");
        }
        return addAcct;
    }
    public static String[ ] getAccount(String creditcard_num) {
        Account acct;

        int numAccts = 0;
        accounts.reset();
        while(accounts.hasNext()) {
            acct = accounts.getNext();
            numAccts = numAccts + 1;
        }

        String[] getAcct = new String[numAccts];
        int i = 0;
        accounts.reset();
        while(accounts.hasNext()) {
            acct = accounts.getAccount(creditcard_num);
            getAcct[i++] = acct.toString();
        }
        return getAcct;

    }
    public static String[] getAllAccounts() {
        Account acct;

        accounts.reset();
        int numAccts = 0;
        while(accounts.hasNext()) {
            acct = accounts.getNext();
            numAccts = numAccts + 1;
        }

        
        String[] allAccts = new String[numAccts];
        accounts.reset();
        int i = 0;
        while(accounts.hasNext()) {
            acct = accounts.getNext();
            allAccts[i++] = acct.toString();
        }
        return allAccts;

    }
    // transactions-related methods
    public static String[ ] getAllTransactions() {
        Transaction trans;

        transactions_history.reset();
        int numTrans = 0;
        while(transactions_history.hasNext()) {
            trans = transactions_history.getNext();
            numTrans = numTrans +1;
        }

        String[] allTrans = new String[numTrans];
        int i = 0;
        transactions_history.reset();
        while(transactions_history.hasNext()) {
            trans = transactions_history.getNext();
            allTrans[i++] = trans.toString();
        }
        return allTrans;

    }
    public static boolean initialized() {
        return false;
    }
}