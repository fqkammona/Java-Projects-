public class Baseball extends Game{

    /** Using an Anonymous create all the scoringMethod objects
     * and then adding them into an array of ScoringMethods called scoringMethods. */
    ScoringMethod[] scoringMethods = {
            new ScoringMethod("Single", 1),
            new ScoringMethod("Double", 2),
            new ScoringMethod("Triple", 3),
            new ScoringMethod("Home-Run", 4)
    };

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
        gameOver = period == 10; // if period == 10 then gameOver = true otherwise gameOver stays false
        return gameOver;
    }
}
