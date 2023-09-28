import java.util.Scanner;

public class ManagerUI implements UserInterface{
    private boolean quit = false;
    public void start(Scanner input) {
        int selection;
// command loop
        while(!quit) {
            displayMenu();
            selection = getSelection(input);
            execute(selection, input);
        }
    }

    private void execute(int selection, Scanner input) {
        int veh_type;
        String[] display_lines; 

        switch(selection) {
// view/update rates
            case 1:
                veh_type = getVehicleType(input);
                switch(veh_type) {
                    case 1:
                    display_lines = SystemInterface.updateCarRates(updateRates(input));
                    displayResults(display_lines);
                    break;
                    case 2:
                    display_lines = SystemInterface.updateSUVRates(updateRates(input));
                    displayResults(display_lines);
                    break;
                    case 3:
                    display_lines = SystemInterface.updateTruckRates(updateRates(input));
                    displayResults(display_lines);
                    break;
                }
            break;
// view all vehilces
            case 2: display_lines = SystemInterface.getAllVehicles();
            displayResults(display_lines);
            break;
// add account
            case 3: makeAccount(input);
            display_lines = SystemInterface.addAccount(makeAccount(input));
            displayResults(display_lines);
            break;
// view all reservations
            case 4: display_lines = SystemInterface.getAllReservations();
            displayResults(display_lines);
            break;
// view all accounts
            case 5: display_lines = SystemInterface.getAllAccounts();
            displayResults(display_lines);
            break;
// view transactions
            case 6: display_lines = SystemInterface.getAllTransactions();
            displayResults(display_lines); 
            break;
// quit program
            case 7: quit = true;
        }
    }

    private void displayMenu() {
        System.out.println("MAIN MENU - Manager");
        System.out.println("");
        System.out.println("1 - View/Update Rates");
        System.out.println("");
        System.out.println("2 - View All Vehicles");
        System.out.println("");
        System.out.println("3 - Add Account");
        System.out.println("");
        System.out.println("4 - View All Reservations");
        System.out.println("");
        System.out.println("5 - View All Accounts");
        System.out.println("");
        System.out.println("6 - View Transactions");
        System.out.println("");
        System.out.println("7 - Quit");
     }
    // displays the menu of options
    private int getSelection(Scanner input) {
        System.out.println("Make a Selection: ");
        int selection;
        selection = input.nextInt();
        if(selection > 8 || selection < 1) {
            System.out.println("Invalid Selection.");
            selection = input.nextInt();
        }
        return selection;
     }
    private int getVehicleType(Scanner input) {
        System.out.println("Enter Vehicle Type (1. Car 2. SUV 3. Truck): ");
        int type;
        type = input.nextInt();
        if(type == 1) {
            return type;
         } else
            if(type == 2) {
                return type;
            } else if(type == 3) {
                    return type;
                } else
                    System.out.println("Invalid selection - please reenter");
        return type;
    }

    private VehicleRates updateRates(Scanner input) {
        VehicleRates r;
        double daily;
        double weekly;
        double monthly;
        double mileage;
        double dailyInsur;

        System.out.println("Enter New Daily Rate: ");
        daily = input.nextDouble();
        System.out.println("Enter New Weekly Rate: ");
        weekly = input.nextDouble();
        System.out.println("Enter New Monthly Rate: ");
        monthly = input.nextDouble();
        System.out.println("Enter New Mileage Charge: ");
        mileage = input.nextDouble();
        System.out.println("Enter New Daily Insurance Rate: ");
        dailyInsur = input.nextDouble();

        if(getVehicleType(input) == 1) {
            CarRates car = new CarRates(daily, weekly, monthly, mileage, dailyInsur);
            r = car;
            SystemInterface.updateCarRates(r);
            return r;
        }
        if(getVehicleType(input) == 2) {
            SUVRates suv = new SUVRates(daily, weekly, monthly, mileage, dailyInsur);
            r = suv;
            SystemInterface.updateSUVRates(r);
            return r;
        }
        if(getVehicleType(input) == 3) {
            TruckRates truck = new TruckRates(daily, weekly, monthly, mileage, dailyInsur);
            r = truck;
            SystemInterface.updateTruckRates(r);
            return r;
        }
        
        return null;
    }

    private Account makeAccount(Scanner input) {
        Account a;
        boolean quit = true;
        while (quit != false) {
            
        String custName;
      System.out.println("Enter Customer's Name: ");
      custName = input.next();

     String creditCard;
      System.out.println("Enter Credit Card Number: ");
     creditCard = input.next();

      String primeMember;
      boolean prime = false;
     System.out.println("Prime Customer? (Y/N): ");
      primeMember = input.next();
      if(primeMember.equalsIgnoreCase("Y")) {
      prime = true;
    } else if(!primeMember.equalsIgnoreCase("Y") && !primeMember.equalsIgnoreCase("N")) {
      System.out.println("* Invalid Option *");
      primeMember = input.next();
    }
      if(primeMember.equalsIgnoreCase("N")) {
      prime = false;
    } else if(!primeMember.equalsIgnoreCase("N") && !primeMember.equalsIgnoreCase("Y")) {
      System.out.println("* Invalid Option *");
      primeMember = input.next();
    }

    String cont;
    System.out.println("Continue? (Y/N)");
    cont = input.next();
    if(cont.equalsIgnoreCase("Y")) {
      quit = true;
    } else if(!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N")) {
      System.out.println("* Invalid Option *");
      cont = input.next();
    }
    if(cont.equalsIgnoreCase("N")) {
      quit = false;
    } else if(!cont.equalsIgnoreCase("N") && !cont.equalsIgnoreCase("Y")) {
      System.out.println("* Invalid Option *");
      cont = input.next();
    }

      a = new Account(custName,creditCard,prime);
      SystemInterface.addAccount(a);
      Accounts accounts = new Accounts();
     accounts.add(a);
     return a;
    }
    return null;
    
}
    // prompts user to enter required information for making a reservation (VIN of vehicle to reserve,
    // credit card num, rental period, and insurance option), returning the result packaged as a
    // ReservationDetails object (to be passed in method calls to the SystemInterface) { }
    private void displayResults(String[] lines) {
        int index = 0;
        while(index < lines.length) {
            String print = lines[index++];
            System.out.println(print);
        }
    }

}
