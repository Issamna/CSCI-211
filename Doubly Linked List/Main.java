/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Main {

    public static void main(String[] args) {
        //Storms 1988 Atlantic Ocean
        System.out.println("Storms Doubly Linked List Program");
        System.out.println("-------------------------------------");
        //Create list
        DLinkList storms1988 = new DLinkList();

        //add to list
        storms1988.push_back(new Storm("Florence", 80, "September", 1));
        storms1988.push_back(new Storm("Gilbert", 185, "September", 5));
        storms1988.push_front(new Storm("Joan–Miriam", 145, "October", 4));
        storms1988.push_front(new Storm("Keith", 70, "November", 0));
        storms1988.insert(new Storm("Debby", 75, "August", 1), 2);

        //Print list
        System.out.println("\nAll Storm Data added");
        storms1988.printForward();
        storms1988.printReverse();

        //erase from list
        storms1988.erase(3);

        //Print list
        System.out.println("\nIndex 3 deleted.");
        storms1988.printForward();
        storms1988.printReverse();
    }
}
