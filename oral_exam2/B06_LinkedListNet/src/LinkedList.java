// LinkedList by Fatima Kammona

/** This is the enhanced linked list.
 * It allows for insert/delete anywhere in the linked list. */
public class LinkedList<T> {
    /** Instance Variables */
    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    /** Accessor methods */
    public int getSize() {return size;}
    public boolean isEmpty(){ // returns true if the list is empty
        return size==0;
    }

    /** This method fills the linked list by insterting the new
     * node at the end of the list. The method should only be used to
     * create the linked list. */
    public void insetLast(T node){
        Node<T> newNode = new Node<>(node,null); // creates a new node

        if(isEmpty())
            headNode = tailNode = newNode; // if empty making the new node the head
        else
            tailNode = tailNode.nextNode = newNode; // else make the new node the tail

        size++;
    }

    /** This method returns a string with the name of all
     * the elements of in the list. */
    public String printList(){
        StringBuilder listOfFruits = new StringBuilder();

        if(isEmpty())
            return "List is empty";

        Node<T> current = headNode; // to track the current node
        while(current != null){
            listOfFruits.append(current.getData()).append("\n");
            current = current.nextNode;
        }

        return listOfFruits.toString();
    }
    // method insert anywhere in the list

    // method delete anywhere in the list

    // method fill linked list

    // method print linked list
}
