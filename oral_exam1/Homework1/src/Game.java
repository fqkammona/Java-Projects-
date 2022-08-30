public interface Game {

    public void setHomeTeamName(String name); /* Set home teams name */
    public void setAwayTeamName(String name); /* Set away teams name */

    public String getHomeTeamName(); /* Gets home teams names */

    public String getAwayTeamName(); /* Get away teams names */
    public int getHomeScore(); /* Gets home teams current score */
    public int getAwayScore(); /* Gets away teams current score */

    /* addScore*/

    public String[] getScoringMethods(); /* gets an array of scoring methods */
    public void endCurrentPeriod(); /* ends the current period by adding one to the one to the period */
    public int getCurrentPeriod(); /* Gets the current period */

    public int getPeriodLength(); /* Returns the length of the period */
    public String getPeriodName(); /* Gets the name of the period */

    public void startGame(); /* Sets the boolean for game to false; */

    public boolean isGameOver(); /* Return false if game is not over */

}
