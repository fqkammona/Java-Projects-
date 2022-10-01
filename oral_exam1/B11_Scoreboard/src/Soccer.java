public class Soccer extends Game{

    /** Using an Anonymous create all the scoringMethod objects
     * and then adding them into an array of ScoringMethods called scoringMethods. */
    ScoringMethod[] scoringMethods = {
            new ScoringMethod("Goal", 1)
    };
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
        gameOver = period == 3; // if period == 3 then gameOver = true otherwise gameOver stays false
        return gameOver;
    }
}
