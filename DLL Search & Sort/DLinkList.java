/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 * Doubly Linked Linked List
 */
public class DLinkList {
    /**
     * Node object to represent each object in list.
     * Contains a Storm object, and Pointers for next and previous nodes
     */
    class Node{
        Storm data;     //Storm data
        Node next;      //Pointer for next node
        Node previous;  //Pointer for previous node
    }

    Node head;      //Pointer to list head
    Node tail;      //Pointer too list tail

    /**
     * Constructor with head/tail pointer set to null
     */
    public DLinkList(){
        head = null;
        tail = null;
    }

    /**push_back()
     * Method to append a new node to the end of list
     * @param h Storm object data
     */
    public void push_back(Storm h){
        Node temp = new Node();
        temp.data = h;
        temp.next = null;
        if(head == null){
            temp.previous = null;
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
    }

    /**push_front()
     * Method to prepend a new node to the start of list
     * @param h Storm object data
     */
    public void push_front(Storm h){
        Node temp = new Node();
        temp.data = h;
        temp.next = head;
        temp.previous = null;
        if(head != null){
            head.previous = temp;
        }
        head = temp;
        if(tail == null){
            tail = temp;
        }
    }

    /**insert()
     * Method to insert new node in the index position
     * @param h Storm object data
     * @param index location of new node
     */
    public void insert(Storm h, int index){
        //if index is below zero, prepend to front
        if(index <= 0){
            push_front(h);
            return;
        }
        Node temp = head;
        int counter = 0;
        while (counter < index-1 && temp != null){
            temp = temp.next;
            counter++;
        }
        //if index is greater the list size, append to back
        if(temp == null || temp.next == null){
            push_back(h);
        }
        else {
            Node newTemp = new Node();
            newTemp.data = h;
            newTemp.next = temp.next;
            newTemp.previous = temp;
            temp.next.previous = newTemp;
            temp.next = newTemp;
        }
    }

    /**erase()
     * Method to delete node from index position
     * @param index location of node to be deleted
     */
    public void erase(int index){
        if(index < 0 || head == null){
            return;
        }
        Node prev = head;
        if(index == 0){
            head.next.previous = null;
            head = prev.next;
            return;
        }
        for(int i=0; prev != null && i < index-1; i++){
            prev = prev.next;
        }
        if(prev == null || prev.next == null){
            return;
        }
        Node after = prev.next.next;
        if(after == null){
            tail = prev;
            tail.next = null;
        }
        else{
            prev.next = after;
            after.previous = prev;
        }
    }

    /**printForward()
     * Method to print list data from head to tail
     */
    public void printForward(){
        Node temp = head;
        System.out.println("\nStorm Data List");
        System.out.println("-------------------------");
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    /**printBackward()
     * Method to print list data from tail to head
     */
    public void printReverse(){
        Node temp = tail;
        System.out.println("\nStorm Data List (Backward)");
        System.out.println("-------------------------");
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.previous;
        }
    }

    /**size()
     * Method to get size of current list
     */
    public int size(){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**sortwind()
     * Method to sort storms by Max Wind speed (bubble sort)
     */
    public void sortwind(){
        Node temp;
        int size = this.size();
        for(int i = 0; i < size-1; i++){
            temp = head;
            for(int j = 0; j < size-i-1; j++){
                Node t1 = temp;
                Node t2 = temp.next;
                if(t1.data.getMaxWind() > t2.data.getMaxWind()){
                    Storm t = t2.data;
                    t2.data = t1.data;
                    t1.data = t;
                }
                temp = temp.next;
            }
        }
    }

    /**searchname()
     * Method to search list by Storm's name (linear search)
     * @param search name to be searched
     */
    public void searchname(String search){
        Node temp = head;
        //Check if list is empty
        if(temp == null){
            System.out.println("Storm list is empty");
            return;
        }
        //Linear Search with storm name
        do{
            if(temp.data.getName().equals(search)){
                System.out.println(temp.data.toString());
                return;  //return if name found
            }
            temp = temp.next;
        }while(temp != null);
        //if not found
        System.out.println("No storms found.");
    }

    /**searchcategory()
     * Method to search list by Storm's category (linear search)
     * @param search category to be searched
     */
    public void searchcategory(int search){
        Node temp = head;
        //Check if list is empty
        if(temp == null){
            System.out.println("Storm list is empty");
            return;
        }
        int count = 0;
        //Check if search key is 0-5
        if(search < 0 || search >5){
            System.out.println("Invalid Category");
        }
        else {
            do {
                if ((temp.data.getCategory()) == search) {
                    System.out.println(temp.data.toString());
                    count++;    //count how many storms found with key
                }
                temp = temp.next;
            }while (temp != null);
            //if not storm is found with search key, count is 0
            if (count == 0) {
                System.out.println("No storms found.");
            }
        }
    }

    /**searchmonth()
     * Method to search list by Storm's month formed (linear search)
     * @param search month formed to be searched
     */
    public void searchmonth(String search){
        Node temp = head;
        //Check if list is empty
        if(temp == null){
            System.out.println("Storm list is empty.");
            return;
        }
        int count = 0;
        int isaMonth = 0;
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        //Check if search key is a month
        for(int i = 0; i < 12; i++){
            if(search.equals(months[i])){
                isaMonth = 1;
            }
        }
        //if search key is a month start search
        if(isaMonth == 1){
            do{
                if(temp.data.getMonthFormed().equals(search)){
                    System.out.println(temp.data.toString());
                    count++;
                }
                temp = temp.next;
            }while (temp != null);
            //if not storm is found with search key, count is 0
            if (count == 0) {
                System.out.println("No storms found.");
            }
        }
        //if not a valid month
        else{
            System.out.println("Invalid Month.");
        }
    }
}
