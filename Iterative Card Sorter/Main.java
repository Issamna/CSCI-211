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
        valueSort(Deck);
        printDeck(Deck);
        System.out.println("-------------------------------------");

        //Sort deck by value & suit & print
        System.out.println("\nDeck Sorted by Value and Sut: ");
        suitSort(Deck);
        printDeck(Deck);
        System.out.println("-------------------------------------");

        System.out.println("\nProgram exiting...");
    }

    /**
     * Print Deck (card array) method
     * @param Deck (card array to be printed)
     */
    public static void printDeck(Card[] Deck){
        for(int i=0; i<Deck.length; i++){
            System.out.println(Deck[i].toString());
        }
    }

    /**
     * Shuffle deck method using Fisher-Yates Algorithm
     * @param Deck (card array to be shuffled)
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

    /**
     * Method to sort card array by value using bubble sort
     * @param Deck (card array to be sorted)
     */
    public static void valueSort(Card[] Deck){
        //Bubble sort
         for (int i=0; i<Deck.length-1; i++){
             for (int j=0; j<Deck.length-i-1; j++){
                 if (Deck[j].compareToValue(Deck[j+1])>0)
                 {
                     Card temp = Deck[j];
                     Deck[j] = Deck[j+1];
                     Deck[j+1] = temp;
                 }
             }
         }
    }

    /**
     * Method to sort card array by value & suit using bubble sort
     * @param Deck (card array to be sorted)
     */
    public static void suitSort(Card[] Deck)
    {
        //Sort deck by value first in case it was not done prior.
        valueSort(Deck);
        //Bubble sort by suit
        for (int i=0; i<Deck.length-1; i++){
            for (int j=0; j<Deck.length-i-1; j++){
                if (Deck[j].compareToSuit(Deck[j+1])>0)
                {
                    Card temp = Deck[j];
                    Deck[j] = Deck[j+1];
                    Deck[j+1] = temp;
                }
            }
        }
    }
}
