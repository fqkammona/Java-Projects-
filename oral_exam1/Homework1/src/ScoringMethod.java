public class ScoringMethod {

    /* Having the variables as final is just a good java practice
        and prevents the value of point to ever change and
        the name of the method to change.
     */
    private final String nameOfMethod;
    private final int point;
    public ScoringMethod(String nameOfMethod, int point) {
        this.nameOfMethod = nameOfMethod;
        this.point = point;
    }

    public String getNameOfMethod(){ return nameOfMethod; }
    public int getPoint(){ return point; }
}
