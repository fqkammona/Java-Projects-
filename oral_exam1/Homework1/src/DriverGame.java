import java.util.Scanner;
import java.util.LinkedList;
public class DriverGame {
    public static void main(String[] args) {
        LinkedList<String> replay = new LinkedList<>();

        Game game;

        System.out.println("Select the type of game:");
        System.out.println("1. Football");
        System.out.println("2. Basketball");
        System.out.println("3. Soccer");
        System.out.println("4. Hockey");
        System.out.println("5. Baseball");
        System.out.print("Enter Choice: ");

        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        System.out.println();
        System.out.print("Enter Home Team: ");
        Scanner homeInput = new Scanner(System.in);
        Team homeTeam = new Team(homeInput.nextLine());

        System.out.print("Enter Away Team: ");
        Scanner awayInput = new Scanner(System.in);
        Team awayTeam = new Team(awayInput.nextLine());

        /* This is polymorphism */
        if(in == 1){
             game = new Football(homeTeam, awayTeam);
        }else if(in == 2){
           game = new Basketball(homeTeam, awayTeam);
        }else if(in == 3){
            game = new Soccer(homeTeam, awayTeam);
        }else if(in == 4){
            game = new Hockey(homeTeam, awayTeam);
        }else{
            game = new Baseball(homeTeam,awayTeam);
        }

        game.startGame();
        boolean thisGameOver = game.isGameOver();

        /* This is the loop for the game */
        while(!thisGameOver){

            /* This is the Score and period section */
            System.out.println();
            System.out.println(game.printScoreUpdate());

            System.out.print("Current " + game.getPeriodName());
            System.out.println(": " + game.getCurrentPeriod());
            System.out.println();

            /* This is the Menu section */
            System.out.println("Menu:");
            ScoringMethod[] methods = game.getScoringMethods(); // Not a hundered % about this sooooo ask about it
            int count = 0;
            int number = 1; // The number for the associated with scoring methods

            while(count < 2){ //This loop is to go through the scoring methods twice

                String teamName = homeTeam.getTeamName(); // Is this right??
                if(count == 1){ teamName = awayTeam.getTeamName(); } // is this right??

                for(ScoringMethod method: methods){ // Iterates through the array of methods and prints out the methods name
                    System.out.println(number + ". " + teamName + " " + method.getNameOfMethod());
                    number++;
                }
                count++;
            }

            System.out.println(number + ". End " + game.getPeriodName()); // This is the final option to end the period
            System.out.print("Enter Choice: ");

            /* This section is to make sure a valid choice is inputed */
            Scanner choiceInput = new Scanner(System.in);
            int choice = choiceInput.nextInt();

            while(choice <= 0 || choice > (methods.length * 2) + 1){ // To stop user from trying to break the program
                System.out.println("\nPlease chose a valid option.");
                System.out.print("Enter Choice: ");

                choice = choiceInput.nextInt();
            }

            /* This is the adding score section  */

            if(choice <= methods.length){ // This is home team
                ScoringMethod methodChoice = game.getScoringMethods()[choice - 1];
                game.addScore(methodChoice, homeTeam);
                replay.add(homeTeam.getTeamName() + " " + methodChoice.getNameOfMethod()); // Add a short method for score 9-8 hawks
            } else if (choice <= (methods.length * 2)){ // This is away team
                ScoringMethod methodChoice = game.getScoringMethods()[choice - methods.length - 1];
                game.addScore(methodChoice, awayTeam);
                replay.add(awayTeam.getTeamName() + " " + methodChoice.getNameOfMethod());
            } else {
                game.endCurrentPeriod();
            }

            thisGameOver = game.isGameOver();
        }

        /* This is the Result section */
        System.out.println();
        System.out.println("Game is over.");

        System.out.println(game.printScoreUpdate());

        System.out.print("Current " + game.getPeriodName());
        System.out.println(": Final");
        System.out.println("Winner: " + game.getWinner());

        /* This section prints the Replay */
        System.out.println();
        System.out.println("Replay");

        for(String play : replay) {
            System.out.println(play);
        }

    }
}

