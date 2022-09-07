public abstract class Game {
    public Team homeTeam, awayTeam;

    public boolean gameOver = true;
    public int period;

    public String[] scoringMethods;
    public int[] scoringPoints;
    public String periodName = "quarter"; /* Default period name */
    public String getPeriodName(){
        return periodName;
    }
    public int getCurrentPeriod(){ return period;}

    public void endCurrentPeriod() { /* Adds one to the period */
        period += 1;
    }


    /** This method will set the period and change gameOver to false. */
    public void startGame() { /* starts game */
        gameOver = false;
        period = 1;
    }


    /** This method is the base rules for the game. */
    public boolean isGameOver(){
        if (period == 5){
            gameOver = true;
        }else {
            gameOver = false;
        }
        return gameOver;
    }

//    public String getWinnter(){ /* to find out who is the winner */
//        if(homeScore > awayScore){
//            return homeTeam;
//        } else if( awayScore > homeScore){
//            return awayTeam;
//        } else {
//            return "Tie";
//        }
//    }
    /** This returns the string with info about home/away score */
    public String printScoreUpdate(){
        String print = "";

        print = homeTeam + " - " + "homeScore" + ", ";
        print = print + awayTeam + " - " + "awayScore" + ", ";

        return print;
    }

}
