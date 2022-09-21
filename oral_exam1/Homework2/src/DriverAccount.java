import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();


        Bank b = new Bank();
        b.makeNewAccount(1, 500);
        b.makeNewAccount(2, 530);
       Bank.setCurrency(1.27);

        System.out.println(b.getBalance());
       System.out.println(Bank.getCurrency());
        System.out.println(Exchange.getCurrency());
        System.out.println(b.getExchangeFromSWD(80));
        System.out.println(b.getExchangeToSWD(80));

        // Account.setCurrency(1.2);

    }
}
