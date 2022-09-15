import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Account {
    private static double currency;
    private final double[] swdDollars = {25, 10, 5, 1, .20, .08, 0.05, 0.01}; // static or no ?

    private BigDecimal[] dollars = {
            new BigDecimal(Double.toString(25)),
            new BigDecimal(Double.toString(10)),
            new BigDecimal(Double.toString(5)),
            new BigDecimal(Double.toString(1)),
            new BigDecimal(Double.toString(.20)),
            new BigDecimal(Double.toString(.08)),
            new BigDecimal(Double.toString(.05)),
            new BigDecimal(Double.toString(.001))
    };

    private BigDecimal balance1;
    private final int accountNum; // This is final because you should always have the same number
    private double balance;

    public Account(int accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
        this.balance1 = new BigDecimal(Double.toString(balance));
    }

    public double getBalance() {
        BigDecimal changeB =new BigDecimal(balance);
       // return rounded(changeB);
        return balance;
    }

    public String getnewB(){
        BigDecimal hold = new BigDecimal(Double.toString(.10));
        BigDecimal answ = new BigDecimal(Double.toString(.15444679955));



        answ = answ.add(hold);
        answ = answ.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        String str = answ.stripTrailingZeros().toPlainString();

        return str;

    }
    public String getWithdraw(double amount1){
        BigDecimal amount = new BigDecimal(Double.toString(amount1));
        String hold = "";

        if(amount.compareTo(balance1) == 1){ // if you try taking more than you have
            return "Error: not enough money";
        }


        //        while(amount > 0){
//            int countBill = 0;
//            while(amount >=  swdDollars[i]){
//                countBill++;
//                amount -= swdDollars[i];
//            }
//            hold = hold + countBill + " - " + swdDollars[i] + " SWD Bill, \n";
//           // replay.add(countBill, ", SWD Bill");
//            i++;
//        }
//
//        balance -= amount;

        int i = 0;
        while(!amount.equals(0)){
            int countBill = 0;
            while(amount.compareTo(dollars[i]) == 1){
                countBill++;
                amount = amount.subtract(dollars[i]);
            }
            //hold = hold + countBill + " - " + swdDollars[i] + " SWD Bill, \n";
           // replay.add(countBill, ", SWD Bill");
            amount = amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//            String str = amount.stripTrailingZeros().toPlainString();

            hold = hold + countBill + " - " + dollars[i] + " SWD Bill, \n";
            i++;
        }


        return hold;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void updateBalance(double balance){
        this.balance = balance;
    }

    public String Withdraw(double amount){
       if(amount > balance) return "error Funds not effiecent"; // To make sure you don't with draw more then you have.
        String hold = "";
        int i = 0;

//        while(amount > 0){
//            int countBill = 0;
//            while(amount >=  swdDollars[i]){
//                countBill++;
//                amount -= swdDollars[i];
//            }
//            hold = hold + countBill + " - " + swdDollars[i] + " SWD Bill, \n";
//           // replay.add(countBill, ", SWD Bill");
//            i++;
//        }
//
//        balance -= amount;






        return hold;
    }

    public static void setCurrency(double currency) {
        Account.currency = currency;
    }

    public static double getCurrency() {
        return currency;
    }
}
