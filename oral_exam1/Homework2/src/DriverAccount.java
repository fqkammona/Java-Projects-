import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {


    public static void main(String[] args) {

        Exchange exchange = new Exchange();

        Bank b = new Bank();
        b.upDateCurrency(new BigDecimal(Double.toString(1.2)), "SWD");
        //exchangeCurrency(String currencyName1, String currencyName2, double amount1){

    //    System.out.println(b.getExchangeRate());
        BigDecimal amount = b.exchangeCurrency("USD", "SWD",80);
        BigDecimal amount1 = b.exchangeCurrency("SWD", "USD",80);
        BigDecimal amount2 = b.exchangeCurrency("CAD", "POUND",2);
        BigDecimal amount3 = b.exchangeCurrency("CAD", "USD",2);
       BigDecimal amount4 = b.exchangeCurrency("USD", "POUND",1);
        System.out.println(amount);
        System.out.println(amount1);
        System.out.println(amount2);
        System.out.println(amount3);
        System.out.println(amount4);
//
//
//        BigDecimal amountBigD = new BigDecimal(Double.toString(1.90));
//
//        String temp = b.upDateCurrency(amountBigD, "SWD");
//        System.out.println(b.getExchangeRate());
//        System.out.println(b.getCurrencyName());
//        System.out.println(exchange.getExchangeRate());
//        String hold = b.findCurrentCurrency("CAD");
//        System.out.println(b.getCurrencyName());
//        System.out.println(b.getExchangeRate());
//
//
//
//        BigDecimal amountBigDD = new BigDecimal(Double.toString(1.50));
//        String tempp = b.upDateCurrency(amountBigDD, "SWD");
//        System.out.println(b.getCurrencyName());
//        System.out.println(b.getExchangeRate());
//        System.out.println(b.getCurrencyName());
//        System.out.println(exchange.getExchangeRate());
//        System.out.println(exchange.getCurrencyName());


//        b.makeNewAccount(1, 500);
//        b.makeNewAccount(2, 530);
//
//
//        System.out.println(b.getBalance());
//
//        System.out.println(b.withdrawSWD(80));
//        System.out.println(b.getBalance());

        // Account.setCurrency(1.2);

    }
}
