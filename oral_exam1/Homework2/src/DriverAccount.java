import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.makeNewAccount(1,672.9);


        System.out.println(bank.withdrawalIn("USD",24.6));

        System.out.println(bank.exchangeCurrency("USD", "USD",24.6));


    }
}
