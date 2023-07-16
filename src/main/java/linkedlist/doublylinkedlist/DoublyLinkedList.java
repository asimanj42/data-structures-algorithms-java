package linkedlist.doublylinkedlist;

import linkedlist.LinkedList;

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
        Node temp = tail; //temp = 4 , tail = 4
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            head = null;
            tail = null;
        } else {

            tail = tail.prev; // tail = 7
            tail.next = null;
            temp.prev = null;
        }
        length--;
        System.out.println("Silinen eded: " + temp.value);
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        Node temp = head; //temp = 4, head = 4;

        if (length == 0) {
            return null;
        }
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next; //head = 11
            head.prev = null;
            temp.next = null;
        }
        length--;
        System.out.println("Silinen eded: " + temp.value);
        return temp;
    }


    public Node get(int index) {
        Node temp = head;
        if (index < 0 || index >= length) {
            return null;
        }
        if (index < length / 2) { //Effektiv usul,beleki index'i tapmaga hem head,hem de tail terefden baslaya bilerik
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (index < 0 || index >= length) {
            return false;
        } else {
            temp.value = value;
            return true;
        }
    }

    public void insert(int index, int value) {

        Node newNode = new Node(value); //newNode = 4
        Node before = get(index); //temp = 3
        Node after = get(index + 1); //after = 23
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            prepend(value);
            return;
        }
        if (index == length) {
            append(value);
            return;
        }
        before.next = newNode;
        after.prev = newNode;
        newNode.prev = before;
        newNode.next = after;
        length++;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node temp = get(index); // temp = 23
        Node before = get(index - 1);
        Node after = get(index + 1);
        temp.next = null;
        temp.prev = null;
        before.next = after;
        after.prev = before;
        length--;
        System.out.println("Silinen eded: " + temp.value);
        return temp;
    }

}
