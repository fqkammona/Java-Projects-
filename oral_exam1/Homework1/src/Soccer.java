public class Soccer extends Game{

    /**This section is creating all the ... and then
     * adding them into an array of ScoringMethods
     * called scoringMethods */
    ScoringMethod method1 = new ScoringMethod("Goal", 1);
    ScoringMethod[] scoringMethods = {method1};
    public String periodName = "half";
    public Soccer(Team homeTeam, Team awayTeam){
        super.homeTeam = homeTeam;
        super.awayTeam = awayTeam;
    }
    public ScoringMethod[] getScoringMethods(){
        return scoringMethods;
    }

    public String getPeriodName(){
        return periodName;
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
