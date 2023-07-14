package doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
        ;
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
        ;

    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        } else {
            Node temp = tail; //temp = 4 , tail = 4
            tail = tail.prev; // tail = 7
            tail.next = null;
            temp.prev = null;
            System.out.println("Silinen eded: " + temp.value);
            return temp;
        }

    }

}
