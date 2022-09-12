public class Baseball extends Game{
    /**This section is creating all the ... and then
     * adding them into an array of ScoringMethods
     * called scoringMethods */
    ScoringMethod method1 = new ScoringMethod("Run", 1);
    ScoringMethod[] scoringMethods = {method1};
    public String periodName = "inning";
    public Baseball(Team homeTeam, Team awayTeam){
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
        if (period == 10){
            gameOver = true;
        }else {
            gameOver = false;
        }
        return gameOver;
    }
}
