import java.math.BigDecimal;
import java.util.Scanner;

public class DriverAccount {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.makeNewAccount(1,300);
        bank.makeNewAccount(2,1209.13);
        bank.makeNewAccount(3,10.0);

        int bankNumber = 4;
        String output = bank.bankOptionsAtStartup();

        boolean logOn = false;
        boolean endProgram = false;

        while(!endProgram){

            /* Display start up options */
            System.out.print(output);

            Scanner input = new Scanner(System.in);
            int in = input.nextInt();

            if(!logOn){ // Switch case when user is not logged on
                switch (in) {
                    case 1: // Create new bank account
                        System.out.print("\nEntire balance: ");
                        bank.makeNewAccount(bankNumber++, input.nextDouble());
                        System.out.println("Account has been created: You are now logged in");
                        System.out.println(bank.yourAccountInfo());
                        output = bank.bankOptions();
                        logOn = true;
                        break;
                    case 2: // Log in to account
                        System.out.println("Please enter your bank number: ");
                        String foundAccount = bank.findAccount(input.nextInt());
                        System.out.println(foundAccount);

                        if(foundAccount.compareTo("Account has been found.") == 0){
                            System.out.println("You are now logged in");
                            logOn = true;
                            output = bank.bankOptions();
                        }
                        break;
                    case 3: // Exchange
                        System.out.println("Wednesday");
                        break;
                    case 4: // Exit Program
                        endProgram = true;
                        break;
                }

            }else { // Switch cases when a user is logged on
                switch (in) {
                    case 1: // Get account info
                        System.out.println("Account Information:\n");
                        System.out.println(bank.yourAccountInfo());
                        break;
                    case 2: // Withdraw
                        System.out.println("Tuesday");
                        break;
                    case 3: // Delete Account
                        System.out.println(bank.deleteAccount(bank.getAccountNum()));
                        logOn = false;
                        output = bank.bankOptionsAtStartup();
                        break;
                    case 4: //  Log out of Account
                        logOn = false;
                        output = bank.bankOptionsAtStartup();
                        break;
                    case 5: // Log out of Account and Exit program
                        endProgram = true;
                        break;
                }
            }
            System.out.println();
        }
    }
}
