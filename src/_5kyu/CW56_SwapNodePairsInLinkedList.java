package _5kyu;

/*
You are given the head node of a singly-linked list. Write a method that swaps each pair of nodes in the list,
then returns the head node of the list. You have to swap the nodes themselves, not their values.

Example:
(A --> B --> C --> D) => (B --> A --> D --> C)

The swapping should be done left to right, so if the list has an odd length, the last node stays in place:
(A --> B --> C) => (B --> A --> C)

The list will be composed of Nodes of the following specification:

public class Node {
    private String value;
    public Node next;

    public Node(String value) { this.value = value; }

    public String getValue() { return value; }
  // returns a String representation of the whole list:
    public String printList() {}
}
 */
public class CW56_SwapNodePairsInLinkedList {
    public static void main(String[] args) {

        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");

        System.out.println(swapPairs(head).printList()); // B A D C
    }

    public static Node swapPairs(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

class Node {
    private final String value;
    public Node next;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String printList() {
        Node current = this;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            result.append(current.value).append(" ");
            current = current.next;
        }
        return result.toString().trim();
    }
}