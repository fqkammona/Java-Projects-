public class Basketball extends Scoreboard{
    public String[] scoringMethods = {"two", "three", "free throw"};
    public int[] scoringPoints = {2,3,1}; /* an array that holds the points for the scoring methods */

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
        return 12;
    }
}
