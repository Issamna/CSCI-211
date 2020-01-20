/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Card {
    //Card fields/parameters
    private int valueInt; //Value in integer
    private int suitInt;  //Suit in integer
    private String value; //Value in String
    private String suit;  //Suit in String

    /**
     * Constructor with parameters
     * Constructor takes two int values and assigns the string representation to Card
     * If integer outside range (ex. valueInt = 76) Joker String is assigned to Card
     * @param valueInt Card value in integer (2-10, J=11, Q=12, K=13, A=14)
     * @param suitInt Card suit in integer (C=1, D=2, H=3, S=4)
     */
    public Card(int valueInt, int suitInt){
        this.valueInt = valueInt;
        this.suitInt = suitInt;
        //String assigned for card Value
        if(valueInt>1 && valueInt<11){
            this.value = valueInt+"";
        }
        else{
            switch (valueInt){
                case 11:
                    this.value = "J";
                    break;
                case 12:
                    this.value = "Q";
                    break;
                case 13:
                    this.value = "K";
                    break;
                case 14:
                    this.value = "A";
                    break;
                default:
                    this.value = "Joker";
                    break;
            }
        }
        //String assigned for card Suit
        switch (suitInt){
            case 1:
                this.suit = "C";
                break;
            case 2:
                this.suit = "D";
                break;
            case 3:
                this.suit = "H";
                break;
            case 4:
                this.suit = "S";
                break;
            default:
                this.suit = "Joker";
                break;
        }
    }

    /**
     * Accessor method to return Card's value in int
     * @return valueInt
     */
    public int getValueInt(){
        return valueInt;
    }

    /**
     * Accessor method to return Card's suit in int
     * @return valueInt
     */
    public int getSuitInt(){
        return suitInt;
    }


    /**
     * Method to return Card's value & suit as a String
     * @return (value+" - "+suit)
     */
    public String toString(){
        return (value+" - "+suit);
    }

    /**
     * Method to compare two Card values
     * @param card2 Card object being compared to
     * @return returns int
     */
    public int compareToValue(Card card2){
        if(this.getValueInt() < card2.getValueInt()) {
            return -1;
        }
        else if(this.getValueInt() > card2.getValueInt()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     * Method to compare two Card suits
     * @param card2 Card object being compared to
     * @return returns int
     */
    public int compareToSuit(Card card2){
        if(this.getSuitInt() < card2.getSuitInt()) {
            return -1;
        }
        else if(this.getSuitInt() > card2.getSuitInt()) {
            return 1;
        }
        else {
            return 0;
        }
    }


}
