import java.util.Scanner;

public class OneTimePad {
    final static char alphabet [] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private int key;
    private String message;

    public void setKey(int key){
        this.key = key;
    }

    public void setMessage(String message){
        this.message = message.toUpperCase(); // converts the message to uppercase
    }

    public int getKey(){
        return key;
    }

    public String getMessage(){
        return message;
    }

    public static void main(String[] args) {
        OneTimePad myObj = new OneTimePad();

        System.out.println("Please enter your message!");
        Scanner input = new Scanner(System.in);

        String message = input.nextLine();
        myObj.setMessage(message);

        System.out.println("Please enter your key!");
        input = new Scanner(System.in);
        int key = input.nextInt();
        myObj.setKey(key);

        System.out.println(myObj.getMessage());



    }
}
