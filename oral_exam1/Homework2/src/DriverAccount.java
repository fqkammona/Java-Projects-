import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.makeNewAccount(1,300);
        bank.makeNewAccount(2,1209.13);
        bank.makeNewAccount(3,10.0);

        int bankNumber = 4;
        String output = bank.bankOptionsAtStartup();

        boolean endProgram = false;

        while(!endProgram){

            /* Display start up options */
            System.out.print(output);

            Scanner input = new Scanner(System.in);
            int in = input.nextInt();

            switch (in) {
                case 1:
                    System.out.print("\nEntire balance: ");
                    bank.makeNewAccount(bankNumber++, input.nextDouble());
                    System.out.println("Account has been created: You are now logged in");
                    System.out.println(bank.yourAccountInfo());
                    output = bank.bankOptions();
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    endProgram = true;
                    break;
            }
            System.out.println();

        }
    }
}
