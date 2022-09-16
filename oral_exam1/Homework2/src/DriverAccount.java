import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class DriverAccount {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();

        Account.setCurrency(12);

        Account a1 = new Account(1,500);

     //   System.out.println(a1.Withdraw(10.20));

        System.out.print(a1.getWithdraw(600));

    }
}
