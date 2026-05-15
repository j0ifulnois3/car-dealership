package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    static Scanner input = new Scanner(System.in);
    //field
    private Dealership dealership;

    public Interface() {
    }

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    public void display(){
        init();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                                       Menu:
                            1 - Find vehicles within a price range
                            2 - Find vehicles by make / model
                            3 - Find vehicles by year range
                            4 - Find vehicles by color
                            5 - Find vehicles by mileage range
                            6 - Find vehicles by type (car, truck, SUV, van)
                            7 - List ALL vehicles
                            8 - Add a vehicle
                            9 - Remove a vehicle
                            0 - Quit
                            """);
            System.out.print("What would you like to do? ");
            int userChoice = 0;
            try {
                String userInput = input.nextLine();
                userChoice = Integer.parseInt(userInput);
            } catch (Exception e) {
                System.out.println("\nSorry, invalid option. Please try again!\n");
                continue; // skip to next loop iteration
            }

            switch (userChoice) {
                case 1 -> getByPriceRange();
                case 2 -> getByMakeModel();
                case 3 -> getByYearRange();
                case 4 -> getByColor();
                case 5 -> getByMileageRange();
                case 6 -> getByType();
                case 7 -> getAllVehicles();
                case 8 -> addVehicle();
                case 9 -> removeVehicle();
                case 0 -> isRunning = false;

                default -> System.out.println("We don't recognize this option. Please Try again");
            }
        }
    }

    public void getByVin(){
        System.out.print("Enter Vin: ");
        int userChoiceVin = Integer.parseInt(input.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByVin(userChoiceVin);
     for (Vehicle vehicle : vehicles){
         if (vehicle.getVin() == userChoiceVin) {
             vehicle.getPrice();
         }
     }
        contractOption();
        displayVehicles(vehicles);

    }

    public void getByPriceRange() {
        System.out.print("Type minimum price: ");
        double userChoiceMin = Double.parseDouble(input.nextLine());
        System.out.print("Type maximum price: ");
        double userChoiceMax = Double.parseDouble(input.nextLine());
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(userChoiceMin, userChoiceMax);

        displayVehicles(vehicles);
    }

    public void getByMakeModel() {
        System.out.print("Type make: ");
        String userChoiceMake = input.nextLine();
        System.out.print("Type model: ");
        String userChoiceModel = input.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(userChoiceMake, userChoiceModel);

        displayVehicles(vehicles);
    }

    public void getByYearRange() {
        System.out.print("Type minimum year: ");
        int userChoiceMin = Integer.parseInt(input.nextLine());
        System.out.print("Type maximum year: ");
        int userChoiceMax = Integer.parseInt(input.nextLine());
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(userChoiceMin, userChoiceMax);

        displayVehicles(vehicles);
    }

    public void getByColor() {
        System.out.print("Type make: ");
        String userChoiceColor = input.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(userChoiceColor);

        displayVehicles(vehicles);
    }

    public void getByMileageRange() {
        System.out.print("Type minimum mileage: ");
        int userChoiceMin = Integer.parseInt(input.nextLine());
        System.out.print("Type maximum mileage: ");
        int userChoiceMax = Integer.parseInt(input.nextLine());
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(userChoiceMin, userChoiceMax);

        displayVehicles(vehicles);
    }

    public void getByType() {
        System.out.print("Type vehicle Type: ");
        String userChoiceType = input.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(userChoiceType);

        displayVehicles(vehicles);
    }

    public void getAllVehicles() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void addVehicle() {
        System.out.print("Type Vin: ");
        int vin = Integer.parseInt(input.nextLine());
        System.out.println("Type year: ");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("Type make: ");
        String make = input.nextLine();
        System.out.println("Type model: ");
        String model = input.nextLine();
        System.out.println("Vehicle type: ");
        String vehicleType = input.nextLine();
        System.out.println("Type color: ");
        String color = input.nextLine();
        System.out.print("Type mileage: ");
        int mileage = Integer.parseInt(input.nextLine());
        System.out.print("Type price: ");
        double price = Double.parseDouble(input.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, mileage, price);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);

    }

    public void removeVehicle() {
        System.out.print("Type Vin: ");
        int vin = Integer.parseInt(input.nextLine());

        ArrayList<Vehicle> result = dealership.getAllVehicles();
        for (Vehicle vehicle : result) {
            if(vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
            }
        }
        DealershipFileManager dealershipFileManager = new DealershipFileManager();

        dealershipFileManager.saveDealership(dealership);
    }

    //helper methods
    public void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%nVin: %d | Year: %d | Make: %s | Model: %s | Vehicle Type: %s | Color: %s | Odometer: %d | Price: %.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice());


        getByVin();
        }
    }

    //sale/lease
    /*
    list vehicle options ✅
    choose a vehicle ✅
    choose contract type 1/2
     + implement veh into cont.
    display contract
     */
    public void contractOption(){
        boolean contract = true;
SalesContract salesContract = new SalesContract();
        while(contract){
            System.out.println("""
                    1 - Sale
                    2 - Lease""");
            int userOption = input.nextInt();

            switch(userOption){
                case 1 -> salesContract.displaySalesContract();
            }
        }
    }
}