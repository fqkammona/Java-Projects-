public class Football extends Game{

    /**This section is creating all the ... and then
     * adding them into an array of ScoringMethods
     * called scoringMethods */
    ScoringMethod method1 = new ScoringMethod("Touchdown", 6);
    ScoringMethod method2 = new ScoringMethod("Field Goal", 3);
    ScoringMethod method3 = new ScoringMethod("Extra-point", 1);
    ScoringMethod method4 = new ScoringMethod("Two-point Conversion", 2);
    ScoringMethod method5 = new ScoringMethod("Safety", 2);
    ScoringMethod[] scoringMethods = {method1, method2, method3, method4, method5};

    public Football(Team homeTeam, Team awayTeam){
        super.homeTeam = homeTeam;
        super.awayTeam = awayTeam;
    }

    public ScoringMethod[] getScoringMethods(){
        return scoringMethods;
    }

//    public ScoringMethod get(int whichMethod){
//        return ScoringMethod[whichMethod];
//    }

    public int getPeriodLength(){
        return 15;
    }

}
