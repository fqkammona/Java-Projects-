public class Baseball extends Game{
    /**This section is creating all the ... and then
     * adding them into an array of ScoringMethods
     * called scoringMethods */
    ScoringMethod method1 = new ScoringMethod("Single", 1);
    ScoringMethod method2 = new ScoringMethod("Double", 2);
    ScoringMethod method3 = new ScoringMethod("Triple", 3);

    ScoringMethod method4 = new ScoringMethod("Home-Rune", 4);
    ScoringMethod[] scoringMethods = {method1, method2, method3,method4};
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
