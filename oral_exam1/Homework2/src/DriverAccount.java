import java.util.ArrayList;
import java.util.Scanner;


public class DriverAccount {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();

       // Account.setCurrency(1.2);

        Account a1 = new Account(1,500);
        Account.setCurrency(15);

        System.out.println(Account.getCurrency());


       // System.out.println(a1.getExchangeFromSWD(80));
//        System.out.println(a1.withdrawSWD(80));
//        System.out.println(a1.getBalance());
//
//        System.out.print(a1.getWithdraw(400));
//        System.out.println(a1.getWithdraw(17.53));
//        System.out.println(a1.getBalance());
    }
}
