public class Basketball extends Game{

    /** Using an Anonymous create all the scoringMethod objects
     * and then adding them into an array of ScoringMethods called scoringMethods. */
    ScoringMethod[] scoringMethods = {
            new ScoringMethod("Two Pointer", 2),
            new ScoringMethod("Three Pointer", 3),
            new ScoringMethod("Free Throw", 1)
    };

    public Basketball(Team homeTeam, Team awayTeam){
        super.homeTeam = homeTeam;
        super.awayTeam = awayTeam;
    }

    public ScoringMethod[] getScoringMethods(){
        return scoringMethods;
    }

    public int getPeriodLength(){
        return 12;
    }
}
