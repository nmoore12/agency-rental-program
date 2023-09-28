import java.util.Scanner;

public class EmployeeUI implements UserInterface {
// no constructor needed, calls static methods of the SystemInterface
// starts a “command loop” that repeatedly: (a) displays a menu of options, (b) gets the selected
 // option from the user, and (c) executes the corresponding command.
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
        int veh_type, num_day_used, num_miles_driven;
        String vin, creditcard_num; 
        String[] display_lines;
        RentalDetails rental_details; 
        ReservationDetails reserv_details;

        switch(selection) {
// display rental rates
            case 1: veh_type = getVehicleType(input);
                switch(veh_type){
                    case 1: display_lines = SystemInterface.getCarRates(); 
                    displayResults(display_lines); 
                    break;
                    case 2: display_lines = SystemInterface.getSUVRates();
                    displayResults(display_lines);  
                    break;
                    case 3: display_lines = SystemInterface.getTruckRates(); 
                    displayResults(display_lines); 
                    break;
                }
            break;
// display available vehicles
            case 2: veh_type = getVehicleType(input);
                switch(veh_type){
                    case 1: display_lines = SystemInterface.getAvailCars(); 
                    displayResults(display_lines); 
                    break;
                    case 2: display_lines = SystemInterface.getAvailSUVs(); 
                    displayResults(display_lines); 
                    break;
                    case 3: display_lines = SystemInterface.getAvailTrucks(); 
                    displayResults(display_lines); 
                    break;
                }
            break;
// display estimated rental cost
            case 3: rental_details = getRentalDetails(input);
                display_lines = SystemInterface.estimatedRentalCost(rental_details);
                displayResults(display_lines); break;
// make a reservation
            case 4: reserv_details = getReservationDetails(input);
                display_lines = SystemInterface.makeReservation(reserv_details);
            displayResults(display_lines); break;
// cancel a reservation
            case 5: vin = getVIN(input);
                creditcard_num = getCreditCardNum(input);
                display_lines = SystemInterface.cancelReservation(creditcard_num, vin);
                displayResults(display_lines); break;
// view corporate account (and company reservations)
            case 6: creditcard_num = getCreditCardNum(input);
                display_lines = SystemInterface.getAccount(creditcard_num);
                displayResults(display_lines); break;
// process returned vehicle
            case 7: creditcard_num = getCreditCardNum(input);
                vin = getVIN(input);
                num_day_used = getNumDays(input);
                num_miles_driven = getMiles(input);
                display_lines = SystemInterface.processReturnedVehicle(vin,num_day_used,num_miles_driven);
            displayResults(display_lines); break;
// quit program
            case 8: quit = true;
        }
    }
 


// ------- private methods
private void displayMenu() {
    System.out.println("MAIN MENU - Employee");
    System.out.println("");
    System.out.println("1 - View Current Rates");
    System.out.println("");
    System.out.println("2 - View Available Vehicles");
    System.out.println("");
    System.out.println("3 - Calc Estimated Rental Cost");
    System.out.println("");
    System.out.println("4 - Make a Reservation");
    System.out.println("");
    System.out.println("5 - Cancel a Reservation");
    System.out.println("");
    System.out.println("6 - View Corporate Account");
    System.out.println("");
    System.out.println("7 - Process Returned Vehicle");
    System.out.println("");
    System.out.println("8 - Quit");
 }
// displays the menu of options
private int getSelection(Scanner input) {
    System.out.println("Make a Selection: ");
    int selection;
    selection = input.nextInt();
    return selection;
 }
// prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)
private String getVIN(Scanner input) {
    System.out.println("Enter VIN Number: ");
    String vin;
    vin = input.next();
    return vin;
}
private String getCreditCardNum(Scanner input) {
    System.out.println("Enter Credit Card Number: ");
    String cc;
    cc = input.next();
    return cc;
}
private int getNumDays(Scanner input) {
    System.out.println("Enter Days Used: ");
    int num = input.nextInt();
    return num;
}
private int getMiles(Scanner input) {
    System.out.println("Enter the Amount of Miles Driven: ");
    int miles = input.nextInt();
    return miles;
}
// prompts user to enter VIN for a given vehicle (does not do any error checking on the input) { }
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
// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) { }
private RentalDetails getRentalDetails(Scanner input) {
    RentalDetails r;
    boolean insuranceSelected = false;
    boolean prime = false;
    System.out.println("Enter vehicle type (1. Car 2. SUV 3. Truck): ");
    int type = input.nextInt();

    System.out.println("Enter Rental Period (ex. 3 M for 3 months): ");
    int time = input.nextInt();
    char span = input.next().charAt(0);
    

    System.out.println("Estimated Number of Miles to be Driven: ");
    int miles = input.nextInt();

    System.out.println("Daily Insurance? (y,n): ");
    String insur = input.next();

    if(insur.equalsIgnoreCase("y")){
        insuranceSelected = true;
    }else if(insur.equalsIgnoreCase("n")) {
        insuranceSelected = false;
    }else {
        System.out.println("Invalid Option");
        insur = input.next();
    }

    System.out.println("Prime Member? (y,n): ");
    String primeMem = input.next();
    if(primeMem.equalsIgnoreCase("y")){
        prime = true;
    }
    if(primeMem.equalsIgnoreCase("n")) {
        prime = false;
    }
    if(!primeMem.equalsIgnoreCase("y") || !insur.equalsIgnoreCase("n")) {
        System.out.println("Invalid Option");
        insur = input.next();
    }

    TimeSpan rentalPeriod = new TimeSpan(span, time);
    r = new RentalDetails(type, rentalPeriod, miles, insuranceSelected, prime);

    SystemInterface.estimatedRentalCost(r);

    return r;

}
// prompts user to enter required information for an estimated rental cost (vehicle type, estimated
// number of miles expected to be driven, rental period (number of days, weeks or months), and
// insurance option, returning the result packaged as a RentalDetails object (to be passed in method
// calls to the SystemInterface) { }
private ReservationDetails getReservationDetails(Scanner input) {
    ReservationDetails r;
    String vin;
    String creditCardNum;
    TimeSpan rentalPeriod;
    boolean insuranceSelected = false;

    System.out.println("Enter VIN Number: ");
    vin = input.next();

    System.out.println("Enter Credit Card Number: ");
    creditCardNum = input.next();

    System.out.println("Enter Rental Period (ex. 3 M for 3 months): ");
    int time = input.nextInt();
    char span = input.next().charAt(0);
    rentalPeriod = new TimeSpan(span, time);

    System.out.println("Daily Insurance? (y,n): ");
    String insur = input.next();
    if(insur.equalsIgnoreCase("y")){
        insuranceSelected = true;
    }else if(insur.equalsIgnoreCase("n")) {
        insuranceSelected = false;
    }else {
        System.out.println("Invalid Option");
        insur = input.next();
    }
    r = new ReservationDetails(vin, creditCardNum, rentalPeriod, insuranceSelected);

    SystemInterface.makeReservation(r);

    return r;
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
// displays the array of strings passed, one string per screen line { }
}