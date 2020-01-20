/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class Ferry {
    int currentAdd;                             //current lane for adding cars
    int currentLoad;                            //current lane for removing cars
    LaneQueue[] Lanes =  new LaneQueue[10];     //array for 10 lanes in Ferry
    int totalCars;                              //current total cars accepted counter (to give Car a unique id)
    /**
     *Constructor for Ferry
     * Sets currentAdd & currentLoad to lane 1 (array 0)
     * Fills array with lanes
     */
    public Ferry(){
        this.currentAdd = 0;
        this.currentLoad = 0;
        for(int i=0; i<10; i++){
            Lanes[i] = new LaneQueue();
        }
        this.totalCars = 0;
    }

    /**add()
     * Method to add cars to lanes
     * @param addCars amount of cars to be added
     */
    public void add(int addCars){
        int startLane = currentAdd;
        //loop through all lanes
        do{
            int carCount = 0;           //Counter for number of cars added into lane
            while(!Lanes[currentAdd].isFull() && addCars>0){
                Lanes[currentAdd].push(new Car(totalCars));
                //adjust counters
                addCars--;
                carCount++;
                totalCars++;
            }
            //Print number of cars assigned to lane
            if(carCount != 0){
                System.out.println("Added "+carCount+" cars to Lane "+(currentAdd+1));
            }
            //if current lane is full, move to next lane
            if(Lanes[currentAdd].isFull()){
                if(currentAdd<9){
                    currentAdd++;
                }
                else{
                    currentAdd = 0;
                }
            }
        }while(currentAdd != startLane && addCars>0); //at most does one full round of lanes
        //if all lanes are full and cars left over
        if(addCars > 0){
            System.out.println("Could not add "+addCars+" cars. All queues full.");
        }
    }

    /**load()
     * Empties a total of 100 cars from lanes
     */
    public void load(){
      int startNode = currentLoad;
      int emptySpaces = 100;
      //loop through lanes
      do{
          int carCount = 0;               //Counter for number of cars removed from lane
          while((!Lanes[currentLoad].isEmpty()) && emptySpaces>0){
              Lanes[currentLoad].pop();
              emptySpaces--;
              carCount++;
          }
          //Print number of cars removed from lane
          if(carCount != 0){
              System.out.println(carCount+" Removed from lane "+(currentLoad+1));
          }
          //if current lane is empty, move to next lane
          if(Lanes[currentLoad].isEmpty()){
              if(currentLoad >= 9){
                  currentLoad = 0;
              }
              else{
                  currentLoad++;
              }
          }
      }while(currentLoad != startNode && emptySpaces>0);//at most does one full round of lanes
        // if all lanes are full and cars left over
      if(emptySpaces == 100){
          System.out.println("All queues Empty.");
          currentLoad = currentAdd;                 //sets currentLoad to last currentAdd to start loading from that position
      }
    }

    /**laneStatus()
     * Method for testing purpose, returns current lane status
     */
    public void laneStatus(){
      for(int i=0; i<10; i++){
          System.out.println("Lane "+(i+1)+": "+Lanes[i].size());
        }
    }
}
