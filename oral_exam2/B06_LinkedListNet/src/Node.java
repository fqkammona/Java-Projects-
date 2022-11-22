// Node.java by Fatima Kammona
/* This is the Node class that creates a new
 * node that will be inserted in the linked list.  */

public class Node<T> {
    /**
     * Instance Variables
     */
    public T data;
    public Node<T> nextNode; // reference to next linked node

    /**
     * Different constructors.
     */

    /* A constructor that creates a new node with
     * null reference to both instance variables.*/
    public Node() {
        this(null, null);
    }

    /* A constructor that creates a new node given the data
     * and sets the nextNode to null.*/
    public Node(T object) {
        this(object, null);
    }

    /* A constructor that creates a new node given information
     * for both instance variables. */
    public Node(T object, Node<T> node) {
        data = object;
        nextNode = node;
    }

    /**
     * Accessor methods
     */
    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        nextNode = next;
    }

    public Node<T> getNext() {
        return nextNode;
    }
}
