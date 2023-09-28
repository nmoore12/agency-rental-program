import java.util.Scanner;

public class AgencyRentalProgram {
    public static void main(String[ ] args) {
        // Provide Hard-coded Current Agency Rates
        CurrentRates agency_rates = new CurrentRates();
        // Create an Initially Empty Vehicles Collection, and Populate
        Vehicles agency_vehicles = new Vehicles();
        populate(agency_vehicles); // supporting private static method (to be added)
        // Create Initially Empty Accounts and Transactions Objects
        Accounts accounts = new Accounts();
        Transactions transactions = new Transactions();

        // Establish User Interface
        Scanner input = new Scanner(System.in);
        UserInterface ui;
        boolean quit = false;
        // Create Requested UI and Begin Execution
        while(!quit) { // (allows switching between Employee and Manager user interfaces while running)
            ui = getUI(input);
            if(ui == null)
                quit = true;
            else {
        // Init System Interface with Agency Data (if not already initialized)
                if(!SystemInterface.initialized())
                    SystemInterface.initSystem(agency_rates, agency_vehicles, accounts, transactions);
        // Start User Interface
                ui.start(input);
             }
        }
    }

    public static UserInterface getUI(Scanner input) {
        boolean valid_selection = false;

        while(!valid_selection) {
            System.out.print("1 - Employee, 2 - Manager, 3 - Quit: ");
            int selection = input.nextInt();
            if(selection == 1) {
                valid_selection = true;
                return new EmployeeUI();
             } else
                if(selection == 2) {
                    valid_selection = true;
                    return new ManagerUI();
                } else if(selection == 3) {
                        valid_selection = true;
                        return null;
                    } else
                        System.out.println("Invalid selection - please reenter");
        } return null;
    }

    private static void populate(Vehicles vehs) {
        Car car1 = new Car("Chevrolet Camaro", 2018, 30, 2, "KH4GM4564GQ");
        vehs.add(car1);
        Car car2 = new Car("Ford Fusion", 2018, 34, 4, "AB4FG5689GM");
        vehs.add(car2);
        Car car3 = new Car("Ford Fusion Hybrid", 2018, 32, 4, "KV4EG3245RV");
        vehs.add(car3);
        Car car4 = new Car("Chevrolet Impala", 2019, 30, 4, "RK3MB3366YH");
        vehs.add(car4);
    
        SUV suv1 = new SUV("Honda Odyssey", 28, 7, 6, "VM9RF2635TD");
        vehs.add(suv1);
        SUV suv2 = new SUV("Dodge Caravan", 25, 5, 4, "QK3FT4273NE");
        vehs.add(suv2);
        SUV suv3 = new SUV("Ford Expedition", 20, 5, 3, "JK2HL8264HY");
        vehs.add(suv3);
    
        Truck t1 = new Truck("Ten-Foot", 12, 2810, "EJ5KU2437BD");
        vehs.add(t1);
        Truck t2 = new Truck("Eighteen-Foot", 10, 5950, "KG4MD5372RK");
        vehs.add(t2);
        Truck t3 = new Truck("Twenty-Four-Foot", 8, 6500, "EB2WR3082OB");
        vehs.add(t3);
        Truck t4 = new Truck("Twenty-Four-Foot", 8, 6510, "TV3GH4390FK");
        vehs.add(t4);
      }
}

