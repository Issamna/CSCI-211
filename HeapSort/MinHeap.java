/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 */
public class MinHeap{

    /**
     * Node in Heap
     */
    class Node{
        Team value;   //team object class
        /**Constructor for Node
         * @param v team object
         */
        Node(Team v){
            value = v;
        }
    }

    int size = 16;
    Node[] array = new Node[size];
    int nextAvail;

    /**Constructor for MinHeap
     *  nextAvail = 1
     */
    public MinHeap(){
        nextAvail = 1;
    }

    /**add()
     * @param value team object to be added
     */
    public void add(Team value){
        if(nextAvail > size-1){
            return;
        }
        array[nextAvail] = new Node(value);
        int p = getParentIndex(nextAvail);
        int i = nextAvail;
        while(p >= 1){
            if(array[p].value.getYear() > value.getYear()){
                swap(array[p], array[i]);
            }
            i = p;
            p = getParentIndex(p);
        }
        nextAvail++;
    }

    /**remove()
     * removes root node
     * @return min value/root node
     */
    public Team remove(){
        if(array[1] == null){
            return null;
        }
        Team r = array[1].value;
        nextAvail--;
        if(nextAvail == 1){
            array[nextAvail] = null;
        }
        else {
            array[1].value = array[nextAvail].value;
            array[nextAvail] = null;
            fixHeap();
        }
        return r;
    }

    /**getParentIndex()
     * @param index node being referenced
     * @return parent node index
     */
    private int getParentIndex(int index){
        return index/2;
    }

    /**getLeftChildIndex()
     * @param index node being referenced
     * @return left child index
     */
    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    /**getRightChildIndex()
     * @param index node being referenced
     * @return right child index
     */
    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }


    /**hasChildren()
     * @param index node being referenced
     * @return boolean if node has children
     */
    private Boolean hasChildren(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        if(left >= size) {
            return false;
        }
        else if(array[left] == null && array[right] == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**swap()
     * swap node team object
     * @param n1 first node
     * @param n2 second node
     */
    private void swap(Node n1, Node n2) {
        Team t = n1.value;
        n1.value = n2.value;
        n2.value = t;
    }

    /**fixHeap()
     * fix heap after node removal so it doesn't violate heap rules
     */
    private void fixHeap(){
        int i = 1;
        int v = array[i].value.getYear();
        while(hasChildren(i)){
            Node left = array[getLeftChildIndex(i)];
            Node right = array[getRightChildIndex(i)];
            if(left != null){
                if(right != null){
                    if(left.value.getYear() < right.value.getYear()){
                        if(v > left.value.getYear()){
                            swap(array[i], left);
                            i = getLeftChildIndex(i);
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        if(v > right.value.getYear()){
                            swap(array[i], right);
                            i = getRightChildIndex(i);
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                }
                else{
                    if(v > left.value.getYear()){
                        swap(array[i], left);
                        i = getLeftChildIndex(i);
                        continue;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                break;
            }
        }

    }
}