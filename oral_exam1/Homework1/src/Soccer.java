public class Soccer extends Scoreboard{
    public String periodName = "half";
    public String[] scoringMethods = {"Goal"};

    public String[] getScoringMethods(){
        return scoringMethods;
    }

    public String getPeriodName(){
        return periodName;
    }

    public int getPeriodLength(){
        return 45;
    }
    public boolean isGameOver(){ /* the base rules for game rules */
        if (period == 3){
            gameOver = true;
        }else {
            gameOver = false;
        }
        return gameOver;
    }
}
