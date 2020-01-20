import java.util.Random;
/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Card Sorter Program");
        System.out.println("-------------------------------------");

        //Create a Deck (array) using Card class
        Card[] Deck = new Card[52];

        //Fill Deck
        int deckCount = 0;              //count for array position
        for(int i=1; i<5; i++){         //Fills suit
            for(int j=2; j<15; j++){    //Fills values
                Deck[deckCount] = new Card(j,i);
                deckCount++;
            }
        }
        System.out.println("Deck Created");

        //Shuffle deck & print
        System.out.println("\nShuffled Deck: ");
        shuffle(Deck);
        printDeck(Deck);
        System.out.println("-------------------------------------");

        //Sort deck by value & print
        System.out.println("\nDeck Sorted by Value: ");
        quickSort(Deck,0, (Deck.length-1), "Value"); //Call quickSort method
        printDeck(Deck);
        System.out.println("-------------------------------------");

        //Sort deck by value & suit & print
        System.out.println("\nDeck Sorted by Value and Suit: ");
        suitSort(Deck);
        printDeck(Deck);
        System.out.println("-------------------------------------");

        System.out.println("\nProgram exiting...");
    }

    /**printDeck()
     * Print Deck (card array) method
     * @param Deck card array to be printed
     */
    public static void printDeck(Card[] Deck){
        for(int i=0; i<Deck.length; i++){
            System.out.println(Deck[i].toString());
        }
    }

    /**shuffle()
     * Shuffle deck method using Fisher-Yates Algorithm
     * @param Deck card array to be shuffled
     */
    public static void shuffle(Card[] Deck){
        Random rand = new Random();
        for(int i=0; i<Deck.length; i++) {
            int j = rand.nextInt(Deck.length);
            Card temp = Deck[j];
            Deck[j] = Deck[i];
            Deck[i] = temp;
        }
    }

    /**QuickSort()
     * Sorts deck by sortType (ex. "Value" or "Suit")
     * Modified from Introduction to Computer Science with Java by C. Herbert
     * @param a Card array to be sorted
     * @param startIndex Start index of sort
     * @param endIndex  End Index of sort
     * @param sortType  Sort by "Value" or "Suit"
     */
    public static void quickSort(Card[] a, int startIndex, int endIndex, String sortType){
        int pivotIndex;
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex, sortType);
            // quickSort the low set
            quickSort(a, startIndex, pivotIndex - 1, sortType);
            //quickSort the high set
            quickSort(a, pivotIndex + 1, endIndex, sortType);
        }
    }

    /**partition()
     * Method performs partitioning for quickSort method.
     * Modified from Introduction to Computer Science with Java by C. Herbert
     * @param a Card array to be sorted
     * @param startIndex Start index of sort
     * @param endIndex  End Index of sort
     * @param sortType  Sort by "Value" or "Suit"
     * @return midIndex
     */
    public static int partition(Card[] a, int startIndex, int endIndex, String sortType) {
        int pivotIndex; // the index of the chosen pivot element
        Card pivot; // the value of the chosen pivot
        int midIndex = startIndex;
        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];
        // put the pivot at the end of the set
        swap(a, pivotIndex, endIndex);
        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            //For sorting by Suit
            if(sortType == "Suit") {
                if ((a[i].getSuitInt()) < pivot.getSuitInt()) {
                    // put a[i] in the low half and increment current Index
                    swap(a, i, midIndex);
                    midIndex = midIndex + 1;
                }
            }
            //For sorting by Value
            else if(sortType == "Value") {
                if ((a[i].getValueInt()) < pivot.getValueInt()) {
                    // put a[i] in the low half and increment current Index
                    swap(a, i, midIndex);
                    midIndex = midIndex + 1;
                }
            }
        }
        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);
        // return index of pivot
        return midIndex;
    }

    /**swap()
     * Method swaps two elements in an Card array for quickSort method.
     * Modified from Introduction to Computer Science with Java by C. Herbert
     * @param a Card array to be sorted
     * @param first index of first Card
     * @param second index of second Card
     */
    public static void swap(Card[] a, int first, int second) {
        Card c;
        c = a[first];
        a[first] = a[second];
        a[second] = c;
    }

    /**suitSort()
     * Method to sort card array by value & suit using quickSort()
     * @param Deck card array to be sorted
     */
    public static void suitSort(Card[] Deck)
    {
        //Sort deck by Suit first
        quickSort(Deck,0, (Deck.length-1), "Suit");
        //Sort first Suit (C) by value
        quickSort(Deck,0, 12, "Value");
        //Sort next Suit (D) by value
        quickSort(Deck,13, 25, "Value");
        //Sort next Suit (H) by value
        quickSort(Deck,26, 38, "Value");
        //Sort last Suit (S) by value
        quickSort(Deck,39, 51, "Value");
    }
}
