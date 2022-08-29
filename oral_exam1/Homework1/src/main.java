import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Game[] game = new Game[1];


        System.out.println("Select the type of game:");
        System.out.println("1. Football");
        System.out.print("Enter Choice: ");

        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        System.out.println();
        System.out.print("Enter Home Team: ");
        Scanner i = new Scanner(System.in);
        String homeTeam = i.nextLine();

        if(in == 1){
            System.out.println("hi");
            game[0] = new Football(homeTeam, "awayTeam");
        } else {
            System.out.println("Please Enter");
        }

//        while(game.isGameOve == false){
//
//        }


    }
}

