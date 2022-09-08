public class ScoringMethod{
    private String nameOfMethod;
    private int point;
    public ScoringMethod(String nameOfMethod, int point){
        this.nameOfMethod = nameOfMethod;
        this.point = point;
    }

    public String getNameOfMethod(){ return nameOfMethod; }
    public int getPoint(){ return point; }
}
