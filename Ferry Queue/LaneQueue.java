/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 * Circular Queues
 */
public class LaneQueue {

    int count;          //current cars counter
    int max;            //maximum cars allowed
    int front;          //front index
    int back;           //back index
    Car[] carArray;     //array for cars


    /**
     * Constructor for LaneQueue
     */
    public LaneQueue(){
        count = 0;
        max = 30;
        front = -1;
        back = -1;
        carArray = new Car[max];
    }

    /**push()
     * adds car to lane
     * @param newCar
     */
    public void push(Car newCar){
        //Check if full
        if(count == max){
            System.out.println("Lane full");
            return;
        }
        //Check if empty
        else if(front == -1){
            front = 0;
            back = 0;
        }
        //Check if loop around
        else if(back == max-1){
            back = 0;
        }
        //otherwise add to back
        else{
            back++;
        }
        carArray[back] = newCar;
        count++;
    }

    /**pop()
     * removes car from lane
     * @return removed car id
     */
    public Car pop(){
        //Check if empty
        if(front == -1){
            System.out.println("Lane is empty");
            return null;
        }
        Car temp = carArray[front];
        if(front == back){
            front = -1;
            back = -1;
        }
        //check for loop around
        else if(front == max-1){
            front = 0;
        }
        else{
            front++;
        }
        count--;
        return temp;
    }

    /**peek()
     * Method shows first car in queue
     * @return car id in first
     */
    public Car peek(){
        //check if empty
        if(front == -1){
            System.out.println("Queue empty");
            return null;
        }
        return carArray[front];
    }

    /**capacity()
     * shows max capacity of lane
     * @return max
     */
    int capacity(){
        return max;
    }

    /**size()
     * Method shows current size of lane
     * @return count
     */
    public int size(){
        return count;
    }

    /**isEmpty()
     * Method determines if lane is empty or not
     * @return boolean of if empty or not
     */
    public boolean isEmpty(){
        return front == -1 ? true : false;
    }

    /**isFull()
     * Method determines if lane is full or no
     * @return boolean of if full or not
     */
    public boolean isFull(){
        return count == max ? true : false;
    }
}
