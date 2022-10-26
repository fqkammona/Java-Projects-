// Node by Fatima Kammona

/** This is the Node class that creates a new
 * node that will be inserted in the linked list.  */

public class Node<T> {
    /** Instance Variables */
    private T data;
    private Node<T> nextNode; // reference to next linked node

    /** A constructor that creates a new node given the data*/
    public Node(T data) {
        this.data = data;
        nextNode = null;
    }

    /** Accessor methods */
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
