import java.math.BigDecimal;
import java.util.ArrayList;

public class Bank extends Exchange {
    ArrayList<newAccount> accounts = new ArrayList<newAccount>();
    public newAccount currentAccount;
   // Exchange.localCurrency("USD", USDdollars, USDcurrency, USDbillNames);

    public Bank(){
        setLocalCurrency("USD");
    }

    public void makeNewAccount(int accountNum, double balance){
        currentAccount = new newAccount(accountNum, balance);
        accounts.add(currentAccount);
    }

    public String bankOptionsAtStartup(){
        return "1. Create new account\n"
                + "2. Log in to account\n"
                + "3. Exchange\n"
                + "4. Set SWD Exchange Rate\n"
                + "5. Exit Program\n"
                + "Enter Choice: ";
    }

    public String bankOptions(){
        return "1. Get account information\n"
                + "2. Withdraw\n"
                + "3. Delete Account\n"
                + "4. Log out of Account\n"
                + "5. Log out of Account and Exit Program\n"
                + "Enter Choice: ";
    }

    public String yourAccountInfo(){
        return "Account Information: "
                + "\nAccount Number: " + currentAccount.getAccountNum()
                + "\nAccount Balance: " + currentAccount.getBalance() + "\n";
    }

    public BigDecimal getBalance(){
        return currentAccount.getBalance();
    } /** GET RID OF THE WORD PUBLIC */

    public int getAccountNum() {
        return currentAccount.getAccountNum();
    } /** GET RID OF THE WORD PUBLIC */

    public String verifyWithdraw(BigDecimal amount){ /** GET RID OF THE WORD PUBLIC */
        if(amount.compareTo(currentAccount.getBalance()) == 1){ // if you try taking more than you have
            return "Error: not enough money";
        }
        return "";
    }

    private void updateBalance(BigDecimal amount){
        currentAccount.setBalance(getBalance().subtract(amount));
    }

    // Money is given in SWD and you want to withdraw that in usd

    public String withdrawalIn(String currencyName, double amount){

        /* 1. Amount is given in any Currency, so we need to exchange it into USD */
        BigDecimal amountAfterExchange = exchangeCurrency(currencyName, "USD", amount);

        /* 2. We need to verify that the amount is less than the balance */
        String output = verifyWithdraw(amountAfterExchange);
        if(!output.equals("")){ return output; }

        /* 3. Update the balance. Balance is always in USD therefor we use the amountAfterExchange to update it */
        updateBalance(amountAfterExchange);

        /* 4. Create a BigDecimal of amount */
        BigDecimal amountBigD = new BigDecimal(Double.toString(amount));

        /* 5. We Set the inUSD to false because we want to print in SWD */
        String temp = setMyCurrentCurrency(currencyName);

        /* 6. We can now call the withdraw method */
        output = getWithdraw(amountBigD); /// ASK about this.

        return output;
    }

    public String findAccount(int number){

        for (newAccount account : accounts){
            if (account.getAccountNum() == number){
                currentAccount = account;
                return "Account has been found.";
            }
        }
        return "Error: account was not found.";
    }

    public String deleteAccount(int number){

        for (newAccount account : accounts){
            if (account.getAccountNum() == number){
                double balanceInDouble = Double.parseDouble(String.valueOf(account.getBalance()));
                String output = withdrawalIn("USD", balanceInDouble);
                accounts.remove(account);
                return output;
            }
        }
        return "Error: account was not found.";
    }

}
