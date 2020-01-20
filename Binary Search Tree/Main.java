/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 */
public class Main {
    public static void main(String[] args) {

        //Create BST
        BST mlsPlayoffs = new BST();
        System.out.println("\nBST with Objects Program");
        System.out.println("-------------------------");

        //Insert Team Objects
        mlsPlayoffs.insert(new Team("Philadelphia Union", 2008));
        mlsPlayoffs.insert(new Team("DC United", 1996));
        mlsPlayoffs.insert(new Team("Atlanta United FC", 2014));
        mlsPlayoffs.insert(new Team("FC Dallas", 1995));
        mlsPlayoffs.insert(new Team("Toronto FC", 2007));
        mlsPlayoffs.insert(new Team("Portland Timbers", 2011));
        mlsPlayoffs.insert(new Team("Minnesota United FC", 2015));
        mlsPlayoffs.insert(new Team("Seattle Sounders FC", 2009));
        mlsPlayoffs.insert(new Team("Real Salt Lake", 2005));
        mlsPlayoffs.insert(new Team("LA Galaxy", 1994));

        //Print traverses
        mlsPlayoffs.traverse(1);
        mlsPlayoffs.traverse(2);
        mlsPlayoffs.traverse(3);
        mlsPlayoffs.traverse(4);
        System.out.println("\nExiting Program");
        System.out.println("---------------------------");
    }
}