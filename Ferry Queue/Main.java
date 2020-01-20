import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\nCape May-Lewes Ferry Program");
        System.out.println("------------------------------");

        //Create Ferry object that has 10 lanes with 30 car capacity
        Ferry CMLFerry = new Ferry();
        Scanner scnr = new Scanner(System.in);
        int quit = 0;

        //Menu Option loop
        while(quit == 0){
          try{
            System.out.print("\nCommand: ");
            String commandInput = scnr.nextLine();
            //switch case for input
            switch(commandInput){
                case "add":
                    System.out.print("Number of Cars: ");
                    int addCars = Integer.parseInt(scnr.nextLine());
                    CMLFerry.add(addCars);
                    break;
                case "load":
                    CMLFerry.load();
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
          //Catch for invalid int input
          catch(Exception e) {
                System.out.println("Invalid Input");
                quit = 0;
            }
        }
        scnr.close();
    }
}
