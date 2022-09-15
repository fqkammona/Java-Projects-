import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class DriverAccount {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();

        Account.setCurrency(12);

        Account a1 = new Account(1,500);

     //   System.out.println(a1.Withdraw(10.20));

        System.out.print(a1.getWithdraw(400));

//        Account a1 = new Account(1,500);
//        Account a2 = new Account(2,300.2345);
//
//        accounts.add(a1);
//        accounts.add(a2);
//        System.out.println();
    }
}
