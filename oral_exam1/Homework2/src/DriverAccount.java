import java.util.ArrayList;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.*;

public class DriverAccount {

    public static void main(String[] args) {


        Bank b = new Bank();
        b.makeNewAccount(1, 500);
        b.makeNewAccount(2, 530);


        System.out.println(b.getBalance());

        System.out.println(b.withdrawSWD(80));
        System.out.println(b.getBalance());

        // Account.setCurrency(1.2);

    }
}
