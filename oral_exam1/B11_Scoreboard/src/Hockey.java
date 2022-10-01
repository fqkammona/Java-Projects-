public class Hockey extends Game{

    /** Using an Anonymous create all the scoringMethod objects
     * and then adding them into an array of ScoringMethods called scoringMethods. */
    ScoringMethod[] scoringMethods = {
            new ScoringMethod("Goal", 1)
    };

    public String periodName = "Period";

    public Hockey(Team homeTeam, Team awayTeam){
        super.homeTeam = homeTeam;
        super.awayTeam = awayTeam;
    }
    public ScoringMethod[] getScoringMethods(){
        return scoringMethods;
    }

    public String getPeriodName(){
        return periodName;
    }

    public int getPeriodLength(){
        return 20;
    }
    public boolean isGameOver(){ /* the base rules for game rules */
        gameOver = period == 4; // if period == 4 then gameOver = true otherwise gameOver stays false
        return gameOver;
    }
}
