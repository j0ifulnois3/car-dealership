package com.pluralsight;

public abstract class Contract {
    private String contractDate;
    private String name;
    private String email;
    private boolean isSold;
    private double totalPrice;
    private double monthlyPayment;


    public Contract(String contractDate, String name, String email, boolean isSold) {
        this.contractDate = contractDate;
        this.name = name;
        this.email = email;
        this.isSold = isSold;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public abstract double getTotalPrice();

    public abstract double  getMonthlyPayment();

}
