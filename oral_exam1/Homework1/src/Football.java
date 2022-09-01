
public class Football extends Scoreboard{
    public String periodName = "quarter";
    public String[] scoringMethods = {"touchdown", "field goal", "extra-point", "two-point conversion", "safety"};
    public int[] scoringPoints = {6,3,1,2,2}; /* an array that holds the points for the scoring methods */

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    /* Adds points to the home teams score */
    public void addScoreHome(int method){
        homeScore += scoringPoints[method -1];
    }

    /* Adds points to the away teams score */
    public void addScoreAway(int method){
        awayScore += scoringPoints[method -1];
    }

    public int getPeriodLength(){
        return 15;
    }
    public String getPeriodName(){
        return periodName;
    }

    public boolean isGameOver(){
        if (period == 5){
            gameOver = true;
        }else {
            gameOver = false;
        }
        return gameOver;
    }

}
