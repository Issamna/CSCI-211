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
    void push_back(Storm h){
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
    void push_front(Storm h){
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
    void insert(Storm h, int index){
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
    void erase(int index){
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
    void printForward(){
        Node temp = head;
        System.out.println("\nStorm Data List (Forward)");
        System.out.println("-------------------------");
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    /**printBackward)
     * Method to print list data from tail to head
     */
    void printReverse(){
        Node temp = tail;
        System.out.println("\nStorm Data List (Backward)");
        System.out.println("-------------------------");
        while(temp != null){
            System.out.println(temp.data.toString());
            temp = temp.previous;
        }
    }
}
