/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Storm {
    //Storm fields/parameter
    private String name;
    private int maxWind;
    private String monthFormed;
    private int category;

    /**Storm()
     * Constructor with parameters
     * Constructor takes values for storms and applies to fields/parameter
     * @param name Storm name
     * @param maxWind Storm's max wind
     * @param monthFormed month storm formed
     * @param category Storm's category
     */
    public Storm(String name, int maxWind, String monthFormed, int category){
        this.name = name;
        this.maxWind = maxWind;
        this.monthFormed = monthFormed;
        this.category = category;
    }

    /**toString()
     * Method to return Storm's parameter as string
     * Assigns Tropical Storm/Hurricane according to category
     * @return Storm's parameter string
     */
    public String toString(){
        if(category < 1){
            return ("Tropical Storm "+name+" - Wind Speed: "+maxWind+" MPH; Month Formed: "+monthFormed+"; Category: "+category);
        }
        else{
            return ("Hurricane "+name+" - Wind Speed: "+maxWind+" MPH; Month Formed: "+monthFormed+"; Category: "+category);
        }
    }

    /**getName()
     * @return Storm object name
     */
    public String getName(){
        return name;
    }

    /**getMaxWind()
     * @return Storm object max wind
     */
    public int getMaxWind(){
        return maxWind;
    }

    /**getCategory()
     * @return Storm object category
     */
    public int getCategory(){
        return category;
    }

    /**getMonthFormed()
     * @return Storm object month formed
     */
    public String getMonthFormed(){
        return monthFormed;
    }

}
