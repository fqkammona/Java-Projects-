public class Scoreboard {
    public String homeTeam, awayTeam; /* Team names */
    public int homeScore, awayScore, period;

//    public Scoreboard(String homeTeam, String awayTeam){
//        this.homeTeam = homeTeam;
//        this.awayTeam = awayTeam;
//    }
    public boolean gameOver = true; /* boolean to track if the game has started and when it finishes */

    public void setHomeTeamName(String homeTeam){ /* Set home teams name */
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamName(String awayTeam) {
        this.awayTeam =awayTeam;
    } /* Set away teams name */

    public String getHomeTeamName(){ /* Gets home teams name */
        return homeTeam;
    }

    public String getAwayTeamName(){
        return awayTeam;
    } /* Gets away teams name */

    public int getHomeScore() {
        return homeScore;
    } /* Returns Home Teams score */

    public int getAwayScore(){
        return awayScore;
    } /* Returns Away Teams score */

    public void startGame() { /* starts game */
        gameOver = false;
    }

    public void endCurrentPeriod() { /* Adds one to the period */
        period += 1;
    }

    public int getCurrentPeriod() {
        return period;
    } /* Returns the period number */
    public boolean isGameOver(){
        return gameOver;
    } /* Return the boolean for gameOver */
}
