import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hash Function Test Program");
        System.out.println("--------------------------\n");

        //Input for test run
        Scanner scnr = new Scanner(System.in);
        System.out.print("Hash Table array size:  ");
        int size = Integer.parseInt(scnr.nextLine());
        System.out.print("Number of JNumbers:  ");
        int input = Integer.parseInt(scnr.nextLine());

        //test program
        int[] a = new int[size];
        int count = 0;
        for(int i = 0; i < input; i++) {
            long h = hashFunction(randomJNumber(), size);
            a[Math.toIntExact(h)]++;
        }

        for(int i = 0; i < size; i++) {
            System.out.println("Index "+i+" count = "+a[i]);
            //Count how many collision occurred
            if(a[i]>1){
                count =(count + (a[i] - 1));
            }
        }
        System.out.println("\nTotal Collisions :"+count);
    }

    /**hashFunction()
     * Method to provide hash
     * @param key  key to be hashed
     * @param size size of array
     * @return
     */
    public static long hashFunction(String key, int size){
        //My hash function
        long hash = 0;
        for(int i =1;i<9;i++){
            hash = hash*11 + key.charAt(i);
        }
        hash = hash*hash;
        hash =  (hash % 1000000) / 100;
        return hash%size;

        //Better given hash function
        /*
        long hash = 0;
        for(int i =1;i<9;i++){
            hash = (31*hash) +(key.charAt(i));
        }
        return Math.abs(hash) % size;
        */
    }

    /**randomJNumber()
     * @return randomly generated JNumber
     */
    public static String randomJNumber(){
        String jNumber = "J";
        for(int i=0;i<9;i++){
            jNumber = jNumber + ((int) (Math.random()*(9)));
        }
        return jNumber;
    }
}