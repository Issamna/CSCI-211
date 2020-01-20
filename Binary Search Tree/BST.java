import java.util.Queue;
import java.util.LinkedList;
/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *
 */
public class BST{

    /**
     * Node for a leaf or vertex in binary tree
     */
    class Node{
        Team value;   //team object class
        Node left;    //left node
        Node right;   //right node
        Node parent;  //Parent node

        /**Constructor for Node
         * @param v team object
         * @param p node parent
         */
        Node(Team v, Node p){
            value = v;
            left = null;
            right = null;
            parent = p;
        }
    }

    Node root;      //Tree root node

    /**
     * Constructor with root set to null
     */
    public BST(){
        root = null;
    }


    /**insert() recursive
     * @param n recursive value
     * @param value new team to be added
     */
    private void insert(Node n, Team value){
        //if greater go to right node
        if(value.getYear() > n.value.getYear()){
            if(n.right != null){
                insert(n.right, value);
            }
            else{
                n.right = new Node(value, n);
            }
        }
        //if less go to left node
        else if(value.getYear() < n.value.getYear()){
            if(n.left != null){
                insert(n.left, value);
            }
            else{
                n.left = new Node(value, n);
            }
        }
        else{
            System.out.println("Node already exists");
        }
    }

    /**insert()
     * @param value new team
     */
    public void insert(Team value){
        //if BST empty
        if(root == null){
            root = new Node(value, null);
        }
        //call recursive method
        else{
            insert(root, value);
        }
    }

    /**traverse()
     * Select which traverse method
     * 1 - Inorder
     * 2 - Postorder
     * 3 - Preorder
     * 4 - Breadth First
     * @param type traverse choice
     */
    public void traverse(int type){
        if(type == 1){
            System.out.println("\nInorder");
            System.out.println("--------------");
            inorder(root);
        }
        else if(type == 2){
            System.out.println("\nPostorder");
            System.out.println("--------------");
            postorder(root);
        }
        else if(type == 3){
            System.out.println("\nPreorder");
            System.out.println("--------------");
            preorder(root);
        }
        else if(type == 4){
            System.out.println("\nBreadth First");
            System.out.println("--------------");
            breadthfirst(root);
        }
    }

    /**inorder()
     * @param n
     */
    public void inorder(Node n){
        if(n == null){
            return;
        }
        inorder(n.left);
        System.out.println(n.value.getName());
        inorder(n.right);
    }

    /**postorder()
     * @param n starting node
     */
    public void postorder(Node n){
        if(n == null){
            return;
        }
        postorder(n.left);
        postorder(n.right);
        System.out.println(n.value.getName());
    }

    /**preorder()
     * @param n starting node
     */
    public void preorder(Node n){
        if(n == null){
            return;
        }
        System.out.println(n.value.getName());
        preorder(n.left);
        preorder(n.right);
    }

    /**breadthfirst()
     * @param n starting node
     */
    public void breadthfirst (Node n){
        //check if null tree
        if(n == null){
            return;
        }
        //create queue
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            Node t = q.remove();
            System.out.println(t.value.getName());
            if(t.left != null){
                q.add(t.left);
            }
            if(t.right != null){
                q.add(t.right);
            }
        }
    }
}