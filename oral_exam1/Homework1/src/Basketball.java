public class Basketball extends Game{

    /**This section is creating all the method objects and then
     * adding them into an array of ScoringMethods
     * called scoringMethods */
    ScoringMethod method1 = new ScoringMethod("Two Pointer", 2);
    ScoringMethod method2 = new ScoringMethod("Three Pointer", 3);
    ScoringMethod method3 = new ScoringMethod("Free Throw", 1);

    ScoringMethod[] scoringMethods = {method1, method2, method3};

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
