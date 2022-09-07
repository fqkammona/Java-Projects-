public class Scoreboard {
    public String homeTeam, awayTeam; /* Team names */
    public int homeScore, awayScore, period;

    public String periodName = "quarter"; /* Default period name */

    public String[] scoringMethods = {"Goal"};

    public String[] getScoringMethods(){
        return scoringMethods;
    }
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

    public void addScoreHome(int i){ /* Standard scoring */
        homeScore += 1;
    }

    public void addScoreAway(int i){ /* Standard scoring */
        awayScore += 1;
    }

    public String getPeriodName(){
        return periodName;
    }

    public void startGame() { /* starts game */
        gameOver = false;
        period = 1;
    }

    public void endCurrentPeriod() { /* Adds one to the period */
        period += 1;
    }

    public int getCurrentPeriod() {
        return period;
    } /* Returns the period number */

//    public String getWinnter(){ /* to find out who is the winner */
//        if(homeScore > awayScore){
//            return homeTeam;
//        } else if( awayScore > homeScore){
//            return awayTeam;
//        } else {
//            return "Tie";
//        }
//    }
//    public boolean isGameOver(){ /* the base rules for game rules */
//        if (period == 5){
//            gameOver = true;
//        }else {
//            gameOver = false;
//        }
//        return gameOver;
//    }

//    public String printScoreUpdate(){ // This returns the string with info about home/away score
//        String print = "";
//
//        print = homeTeam + " - " + homeScore + ", ";
//        print = print + awayTeam + " - " + awayScore + ", ";
//
//        return print;
//    }
}
