public class Football implements Game{
    public String homeTeam, awayTeam;
    public int homeScore, awayScore;

    public Football(String homeTeam, String awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        homeScore = 0;
        awayScore = 0;
    }
    public void setHomeTeamName(String homeTeam){
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamName(String awayTeam) {
        this.awayTeam =awayTeam;
    }

    public String getHomeTeamName(){
        return homeTeam;
    }

    public String getAwayTeamName(){
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore(){
        return awayScore;
    }
}
