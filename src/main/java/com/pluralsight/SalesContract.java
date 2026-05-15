package com.pluralsight;

public class SalesContract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean willFinance;
    private double monthlyPayment;

    public SalesContract(double salesTax, double recordingFee, double processingFee, boolean willFinance) {
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.willFinance = willFinance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
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
    public double getTotalPrice(){

       return (recordingFee + processingFee + (getPrice * salesTax);
    }
}
