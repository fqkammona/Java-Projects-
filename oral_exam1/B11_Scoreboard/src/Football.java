public class Football extends Game{ // is a game therefor inhertance

    /** Using an Anonymous create all the scoringMethod objects
     * and then adding them into an array of ScoringMethods called scoringMethods. */
    ScoringMethod[] scoringMethods = {
            new ScoringMethod("Touchdown", 6),
            new ScoringMethod("Field Goal", 3),
            new ScoringMethod("Extra-point", 1),
            new ScoringMethod("Two-point Conversion", 2),
            new ScoringMethod("Safety", 2)
    };

    public Football(Team homeTeam, Team awayTeam){
        super.homeTeam = homeTeam;
        super.awayTeam = awayTeam;
    }

    public ScoringMethod[] getScoringMethods(){
        return scoringMethods;
    }

    public int getPeriodLength(){
        return 15;
    }

}
