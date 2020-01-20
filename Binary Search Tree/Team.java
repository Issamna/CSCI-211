/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 */
public class Team{
    private String name;
    private int year;

    /**Constructor for Team
     * @param name
     * @param year
     */
    public Team(String name, int year){
        this.name = name;
        this.year = year;
    }

    /**getName()
     * @return team name
     */
    public String getName(){
        return name;
    }

    /**getYear()
     * @return team year
     */
    public int getYear(){
        return year;
    }
}