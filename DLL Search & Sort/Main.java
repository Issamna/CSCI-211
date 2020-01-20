import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 */
public class Main {
    public static void main(String[] args) {
        //Storms 1988 Atlantic Ocean
        System.out.println("\nStorms Doubly Linked List Program");
        System.out.println("-------------------------------------");
        //Create list
        DLinkList storms1988 = new DLinkList();

        //add to list
        storms1988.push_back(new Storm("Florence", 80, "September", 1));
        storms1988.push_back(new Storm("Gilbert", 185, "September", 5));
        storms1988.push_front(new Storm("Joan–Miriam", 145, "October", 4));
        storms1988.push_front(new Storm("Keith", 70, "November", 0));
        storms1988.insert(new Storm("Debby", 75, "August", 1), 2);

        Scanner scnr = new Scanner(System.in);
        int quit = 0;
        //Menu Option loop
        while(quit == 0){
            try{
                System.out.print("\nCommand: ");
                String commandInput = scnr.nextLine();
                //switch case for input
                switch(commandInput){
                    case "sortwind":
                        storms1988.sortwind();
                        storms1988.printForward();
                        break;
                    case "searchname":
                        System.out.print("Enter Name: ");
                        String searchName = scnr.nextLine();;
                        System.out.println();
                        storms1988.searchname(searchName);
                        break;
                    case "searchcategory":
                        System.out.print("Enter Category: ");
                        int searchCategory = Integer.parseInt(scnr.nextLine());
                        System.out.println();
                        storms1988.searchcategory(searchCategory);
                        break;
                    case "searchmonth":
                        System.out.print("Enter Month: ");
                        String searchMonth = scnr.nextLine();
                        System.out.println();
                        storms1988.searchmonth(searchMonth);
                        break;
                    case "exit":
                        System.out.println("\nExiting Program...");
                        quit = 1;
                        break;
                    default:
                        System.out.println("Invalid Command");
                        break;
                }
            }
            //Catch for invalid int input in searchcategory
            catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }
        scnr.close();
    }
}