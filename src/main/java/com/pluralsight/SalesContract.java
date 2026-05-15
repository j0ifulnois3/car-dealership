package com.pluralsight;

import java.util.ArrayList;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean willFinance;
    private double monthlyPayment;

    public SalesContract() {

    }

    public SalesContract(String contractDate, String name, String email, boolean isSold, double salesTax, double recordingFee, double processingFee, boolean willFinance) {
        super(contractDate, name, email, isSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.willFinance = willFinance;
    }

    public double getSalesTax(double price) {
        salesTax = price - (price * .05)
        if ( int userChoiceVin ==vin){
            result. (vehicle);
        }
        return salesTax;
    }


    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return 100;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isWillFinance() {
        return willFinance;
    }

    public void setWillFinance(boolean willFinance) {
        this.willFinance = willFinance;
    }

    @Override
    public double getTotalPrice() {
//        ArrayList<Vehicle> result = new ArrayList<>();
//
//        for (Vehicle vehicle : inventory){
//                    double price = salesTax * vehicle.getPrice();
//                    price += getRecordingFee();
//
//
//                };
        return getTotalPrice();
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    public String displaySalesContract() {
        return "contract";
    }


}
