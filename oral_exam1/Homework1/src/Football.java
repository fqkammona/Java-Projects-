
public class Football implements Game{
    public String homeTeam, awayTeam;
    public String periodName = "quarter";

    public String[] scoringMethods = {"touchdown", "field goal", "extra-point", "two-point conversion", "safety"};
    public boolean game = true;
    public int homeScore, awayScore, period;

    public Football(String homeTeam, String awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScore = 0;
        awayScore = 0;
        period = 1;
    }
    public void setHomeTeamName(String homeTeam){
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamName(String awayTeam) {
        this.awayTeam =awayTeam;
    }

    public String getHomeTeamName(){
        return homeTeam;
    }

    public String getAwayTeamName(){
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore(){
        return awayScore;
    }

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    public void endCurrentPeriod() { /* Adds one to the period */
        period += 1;

        if (period == 5){ /* If the game is over */
            periodName = "Final"; /* Change the name of the period */
            game = true; /* Set the boolean for game to true */
        }
    }

    public int getCurrentPeriod() {
        return period;
    }

    public int getPeriodLength(){
        return 15;
    }
    public String getPeriodName(){
        return periodName;
    }

    public void startGame() {
        game = false; /* starts game */
    }

    public boolean isGameOver(){
        return game;
    }
}
