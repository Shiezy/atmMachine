package com.example.atm.java;

import java.util.Date;
import java.util.Scanner;

public class Atm{

    private float balance;
    private float deposit;
    private static float withdrawal;
    private static int depositCount = 0;
    private static int withdrawalCount = 0;
    private static String state = "open";

    public Atm(float balance, float deposit, float withdrawal){
    }

    public void menuOptions(){
        int option;
        Scanner input = new Scanner(System.in);
//        Atm machine = new Atm();


        System.out.println("*****MENU******");
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");

        System.out.println("Enter Menu Option");
        option = input.nextInt();
        while(state.equalsIgnoreCase("open")){
            switch(option){
                case 1:
                    float userBalance = balanceEnquiry(balance);
                    break;
                case 2:
                    if(deposit < 150000 && depositCount < 4){
                        System.out.println("Enter Amount to deposit");
                        float amount = input.nextFloat();
                        float totalDeposits = deposit(deposit, amount);
                    }  else {
                        System.out.println("You have Reached your max deposit for the day");
                        menuOptions();
                    }

                        break;
                case 3:
                    if(withdrawal < 50000 && withdrawalCount < 3){
                        System.out.println("Enter Amount to withdraw");
                        float withdrawalAmount = input.nextFloat();
                        withdraw(withdrawal, withdrawalAmount);
                    }else {
                        System.out.println("You have Reached your max withdrawal for the day");
                        menuOptions();
                    }
                    break;
                case 4:
                    System.out.println("Are you sure you wish to quit? Type No If not sure");
                    quitEvaluate();
                    break;
            }
        }
        // return option;
    }
    public void quitEvaluate(){
        Scanner input = new Scanner(System.in);
        String response =  input.nextLine();

        if(response.equalsIgnoreCase("NO")){
            menuOptions();
        } else {
            System.exit(0);
        }

    }
    public float balanceEnquiry(float userBalance){
        System.out.println("Balance : "+ userBalance);
        menuOptions();
        return userBalance;
    }
    public float deposit(float userDeposit, float amount){
            float newDeposit = 0;
            if(amount <= 40000){
                newDeposit = userDeposit + amount;
                if(newDeposit <= 150000) {
                    balance += amount;
                    depositCount++;
                    deposit = newDeposit;
                    System.out.println("Amount Deposited : " + amount);
                    System.out.println("New Balance  : " + balance);
//                    menuOptions();

                } else{
                    System.out.println("Amount surpasses daily limit. Max allowed is : " + (150000-userDeposit));
                }

            } else {
                System.out.println(" You can only deposit 40,000 per transaction  " );

            }
            menuOptions();
            return newDeposit;

    }
    public float withdraw(float userWithdrwal, float amount){
            float newWithdrawal = 0;
            if(amount <= 20000){
                newWithdrawal = userWithdrwal + amount;
                if(newWithdrawal <= 50000){
                    balance -= amount;
                    withdrawalCount++;
                    withdrawal += amount;
                    System.out.println("Amount Deposited : " + amount);
                    System.out.println("New Balance  : " + balance);
                }else{
                    System.out.println("Amount surpasses daily limit. Max allowed is : " + (50000-withdrawal));
                }

            }else {
                System.out.println(" You can only withdraw 20,000 per transaction  " );
            }

            menuOptions();
            return newWithdrawal;
    }
    public static void main(String args[]){
        Atm machine = new Atm(0,0,0);
        System.out.println("**********WELCOME TO OUR ATM*************");
        machine.menuOptions();



    }
}
