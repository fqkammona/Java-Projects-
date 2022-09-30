public class Team {
    private final String TeamName;
    private int TeamScore;
    public Team(String TeamName){
        this.TeamName = TeamName;
    }

    public String getTeamName(){
        return TeamName;
    }

    public void addScore(int point){
        TeamScore += point;
    }

    public int getTeamScore() {
        return TeamScore;
    }
}
