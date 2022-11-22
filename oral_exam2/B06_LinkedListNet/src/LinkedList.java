// LinkedList.java by Fatima Kammona
/* This is the enhanced linked list.
 * It allows for insert/delete anywhere in the linked list. */
public class LinkedList<T> {
    /**
     * Instance Variables
     */
    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    /**
     * Accessor methods
     */
    public int getSize() {
        return size;
    }

    public String getHeadNode() {
        return headNode.getData().toString();
    }

    public String getTailNode() {
        return tailNode.getData().toString();
    }

    public boolean isEmpty() { // returns true if the list is empty
        return size == 0;
    }

    /**
     * This method fills the linked list by inserting the new
     * node at the end of the list. The method should only be used to
     * create the linked list.
     */
    public void insetLast(T node) {
        Node<T> newNode = new Node<>(node, null); // creates a new node

        if (isEmpty())
            headNode = tailNode = newNode; // if empty making the new node the head
        else
            tailNode = tailNode.nextNode = newNode; // else make the new node the tail

        size++;
    }

    /**
     * This method returns a string with the name of all
     * the elements of in the list.
     */
    public String printList() {
        StringBuilder listOfFruits = new StringBuilder();

        if (isEmpty())
            return "List is empty";

        Node<T> current = headNode; // to track the current node
        while (current != null) {
            listOfFruits.append(current.getData()).append("\n");
            current = current.nextNode;
        }

        return listOfFruits.toString();
    }

    /**
     * This method deletes the given node anywhere in the
     * linked list.
     */
    public void deleteNode(T node) {
        Node<T> deleteThisNode = new Node<>(node, null); // creates a new node

        Node<T> current = headNode; // to track the current node
        Node<T> past = headNode; // To track the past node
        int i = 1;

        while (current.getData().toString().compareTo(deleteThisNode.getData().toString()) != 0 && i < size) {
            past = current;
            current = current.nextNode;
            i++;
        }

        if (current.getData().toString().compareTo(deleteThisNode.getData().toString()) == 0) {
            if (i == 1) { // Beginning
                headNode = headNode.nextNode;
            } else if (i == size) { // End
                tailNode = past.nextNode = null;
            } else { // In the middle
                past.nextNode = current.nextNode;
            }
            size--;
        }
    }

    /**
     * This method adds the given node anywhere in the
     * linked list.
     */
    public void addNode(T node, String location, T nodeReference) {
        Node<T> addThisNode = new Node<>(node, null); // creates a new node
        Node<T> referenceNode = new Node<>(nodeReference, null);

        Node<T> current = headNode; // to track the current node
        Node<T> future = headNode; // To track the past node
        Node<T> past = headNode;
        int i = 1;

        while (current.getData().toString().compareTo(referenceNode.getData().toString()) != 0 && i < size) {
            past = current;
            current = current.nextNode;
            future = current.nextNode;
            i++;
        }

        if (location.compareTo("before") == 0) {
            if (i == 1) {
                headNode = addThisNode;
                headNode.nextNode = future;
            } else {
                past.nextNode = addThisNode;
                addThisNode.nextNode = current;
            }
        } else if (location.compareTo("after") == 0) {
            if (i == size) {
                tailNode.nextNode = addThisNode;
            } else {
                Node<T> temp = current.nextNode;
                current.nextNode = addThisNode;
                addThisNode.nextNode = temp;
            }
        }

        size++;
    }
}
