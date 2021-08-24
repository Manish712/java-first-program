package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;


    public MortgageCalculator(long loanAmount,int termInYears , float annualRate){
        this.loanAmount=loanAmount;
        this.termInYears=termInYears;
        this.annualRate=annualRate;
    }

    private int getnumberofPayments(){
        return termInYears*12;
    }

    private float getMonthlyInterestRates(){
        float interestRate;
        interestRate=annualRate/100;
        interestRate/=12;
        return interestRate ;

    }
    public  void calculateMonthlyPayment(){
        long P= loanAmount;
        float r=getMonthlyInterestRates();
        int n=getnumberofPayments();

        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
        M=this.monthlyPayment;
    }
    public String tostring(){
        DecimalFormat df;
        df=new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {

        long loanAmount = Utilities.getLongValue(args[0] );
        int termsInYears = Utilities.getIntValue(args[1]);
        float annualRate=Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termsInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());

    }

}
