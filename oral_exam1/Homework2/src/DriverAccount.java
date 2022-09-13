import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class DriverAccount {

    public static void main(String[] args) {

        ArrayList<Account> accounts = new ArrayList<Account>();

        Account.setCurrency(12);
        Account.setCurrency(14);
        Account a1 = new Account(1,500);
        Account a2 = new Account(2,300.2345);
        System.out.println();
    }
}
