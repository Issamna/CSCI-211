/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
class Main {
    public static void main(String[] args) {
        //Load team data into array
        Team mlsPlayoffs[] = {new Team("Toronto FC", 2007),
                new Team("FC Dallas", 1995),
                new Team("Atlanta United FC", 2014),
                new Team("Seattle Sounders FC", 2009),
                new Team("LA Galaxy", 1994),
                new Team("Philadelphia Union", 2008),
                new Team("Real Salt Lake", 2005),
                new Team("Minnesota United FC", 2015),
                new Team("Portland Timbers", 2011),
                new Team("DC United", 1996)};

        System.out.println("\nHeap sorting an Array of Objects");
        System.out.println("---------------------------------");

        //create minHeap for sort
        MinHeap heapsort = new MinHeap();
        //load into minHeap
        for(int i = 0; i < 10; i++){
            heapsort.add(mlsPlayoffs[i]);
        }
        //Sort back into array
        for(int i = 0; i < 10; i++) {
            mlsPlayoffs[i] = heapsort.remove();
        }
        //Print array
        for(int i = 0; i < 10; i++) {
            System.out.println(mlsPlayoffs[i].getName());
        }
    }
}