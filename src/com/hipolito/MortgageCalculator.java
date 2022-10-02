package com.hipolito;

public class MortgageCalculator {
    private final static byte MONTHS_PER_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = (short) getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);
    }

    public double calculateMortgage(
    ){
        short numberOfPayments = (short) getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterestRate / PERCENT / MONTHS_PER_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_PER_YEAR;
    }
}
