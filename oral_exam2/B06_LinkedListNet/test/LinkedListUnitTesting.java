/** This is the unit testing class for the LinkedList class.*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListUnitTesting {
    LinkedList<String> fruitList = new LinkedList<>();

    @BeforeEach
    void fillList(){
        String[] fruits = { "apple", "grape", "banana", "strawberry", "pineapple"};

        for (String i: fruits)
            fruitList.insetLast(i);
    }

    @Test
    void deleteNodeHead(){
        fruitList.deleteNode("apple");
        assertEquals(fruitList.printList(), "grape\n" +
                "banana\n" +
                "strawberry\n" +
                "pineapple\n");
    }

    @Test
    void deleteNodeTail(){
        fruitList.deleteNode("pineapple");
        assertEquals(fruitList.printList(), "apple\n" +
                "grape\n" +
                "banana\n" +
                "strawberry\n");
    }

    @Test
    void deleteNodeMiddle(){
        fruitList.deleteNode("banana");
        assertEquals(fruitList.printList(), "apple\n" +
                "grape\n" +
                "strawberry\n" +
                "pineapple\n");
    }

    @Test
    void deleteNodeAnywhere(){
        fruitList.deleteNode("banana");
        fruitList.deleteNode("apple");
        fruitList.deleteNode("pineapple");
        fruitList.deleteNode("grape");
        assertEquals(fruitList.printList(), "strawberry\n");
    }

//    @Test // When the node doesn't exist what happens?
//    void deleteNodeDoesNotExist(){
//        fruitList.deleteNode("banana");
//        fruitList.deleteNode("apple");
//        fruitList.deleteNode("pineapple");
//        fruitList.deleteNode("grape");
//        assertEquals(fruitList.printList(), "strawberry\n");
//    }


}
