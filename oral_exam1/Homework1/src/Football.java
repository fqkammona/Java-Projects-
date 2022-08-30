
public class Football extends Scoreboard{
    public String periodName = "quarter";
    public String[] scoringMethods = {"touchdown", "field goal", "extra-point", "two-point conversion", "safety"};

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    public int getPeriodLength(){
        return 15;
    }
    public String getPeriodName(){
        return periodName;
    }

    public boolean isGameOver(){
        int period = getCurrentPeriod();

        if (period == 5){
            return true;
        }else {
            return false;
        }
    }


}
