public abstract class Game {
    public Team homeTeam, awayTeam;
    public boolean gameOver = true;
    public int period;
    public String periodName = "quarter"; /* Default period name */
    public String getPeriodName(){
        return periodName;
    }
    public int getCurrentPeriod(){ return period;}
    public int getPeriodLength(){ return 45; }

    public void endCurrentPeriod() { /* Adds one to the period */
        period += 1;
    }

    public abstract ScoringMethod[] getScoringMethods();

    public void addScore(ScoringMethod method, Team name){
        int point = method.getPoint();
        name.addScore(point);
    }

    /** This method will set the period and change gameOver to false. */
    public void startGame() { /* starts game */
        gameOver = false;
        period = 1;
    }

    /** This method is the base rules for the game. */
    public boolean isGameOver(){
        gameOver = period == 5; // if period == 5 then gameOver = true else gameOver = false
        return gameOver;
    }

    /** This method compares the scores and sends the name of the winning team */
    public String getWinner(){ /* to find out who is the winner */
        if(homeTeam.getTeamScore() > awayTeam.getTeamScore()){
            return homeTeam.getTeamName();
        } else if(awayTeam.getTeamScore() > homeTeam.getTeamScore()){
            return awayTeam.getTeamName();
        } else {
            return "Tie";
        }
    }
    /** This returns the string with info about home/away score */
    public String printScoreUpdate(){
        String print = "";

        print = homeTeam.getTeamName() + " - " + homeTeam.getTeamScore() + ", ";
        print = print + awayTeam.getTeamName() + " - " + awayTeam.getTeamScore() + ", ";

        return print;
    }

}
