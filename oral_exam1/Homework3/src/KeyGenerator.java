import java.util.Scanner; // So that I write to the screen
import java.io.File;
import java.io.IOException;


public class KeyGenerator {
    public static void main(String[] args) {
        System.out.println("Key File has been created.");
        System.out.println("Please choices a number to be your n. This number will be the starting point.");
        System.out.println("Number: ");

        Scanner input = new Scanner(System.in);
        int key = input.nextInt();


    }
}
