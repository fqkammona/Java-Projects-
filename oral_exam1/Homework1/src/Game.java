public interface Game {

    public void setHomeTeamName(String name); /* Set home teams name */
    public void setAwayTeamName(String name); /* Set away teams name */

    public String getHomeTeamName(); /* Gets home teams names */

    public String getAwayTeamName(); /* Get away teams names */
    public int getHomeScore(); /* Gets home teams current score */
    public int getAwayScore(); /* Gets away teams current score */
}
