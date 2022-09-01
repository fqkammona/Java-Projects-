public class Volleyball extends Scoreboard{
    public String periodName = "match";
    public String[] scoringMethods = {"Ace Serve", };

    public int homeGameWin, awayGameWin;

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    public String getPeriodName(){
        return periodName;
    }

    public boolean isGameOver(){
        return false;
    }

}
