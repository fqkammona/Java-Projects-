import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Football game = new Football();

        System.out.println("Select the type of game:");
        System.out.println("1. Football");
        System.out.print("Enter Choice: ");

        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        System.out.println();
        System.out.print("Enter Home Team: ");
        Scanner homeInput = new Scanner(System.in);
        String homeTeam = homeInput.nextLine();

        System.out.print("Enter Away Team: ");
        Scanner awayInput = new Scanner(System.in);
        String awayTeam = awayInput.nextLine();

        game.setHomeTeamName(homeTeam);
        game.setAwayTeamName(awayTeam);

        game.startGame();
        boolean thisGameOver = game.isGameOver();

        while(!thisGameOver){

            /* This is the Score and period section */
            System.out.print(game.getHomeTeamName() + " - ");
            System.out.println(game.getHomeScore() + ", ");

            System.out.print(game.getAwayTeamName() + " - ");
            System.out.println(game.getAwayScore());

            System.out.print("Current " + game.getPeriodName());
            System.out.println(":" + game.getCurrentPeriod());

            /* This is the Menu section */
            String[] methods = game.getScoringMethods();
            int count = 0;
            int number = 1;

            while(count < 2){ //This loop is to go through the scoring methods twice
                String teamName = game.getHomeTeamName();
                if(count == 1){ teamName = game.getAwayTeamName(); }

                for(String method: methods){
                    System.out.println(number + ". " + teamName + " " + method);
                    number++;
                }
                count++;
            }

            System.out.println(number + ". End " + game.getPeriodName()); // This is the final option to end the period

            /* */
            System.out.print("Enter Choice: ");



        }




    }
}

