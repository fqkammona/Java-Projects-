import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {


    public static void main(String[] args) {

        Exchange exchange = new Exchange();

        Bank b = new Bank();

        System.out.println(b.printCurrencyList());


        BigDecimal amountBigD = new BigDecimal(Double.toString(1.90));

        String temp = b.upDateCurrency(amountBigD, "SWD");
        System.out.println(b.getExchangeRate());
        System.out.println(b.getCurrencyName());
        System.out.println(exchange.getExchangeRate());
        String hold = b.findCurrentCurrency("CAD");
        System.out.println(b.getCurrencyName());
        System.out.println(b.getExchangeRate());

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
