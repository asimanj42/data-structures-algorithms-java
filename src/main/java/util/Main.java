package util;

import doublylinkedlist.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList(112);
        d.append(136);
        d.append(141);
         d.append(144);
        d.printList();
        System.out.println("-----------");
        d.removeLast();
        d.printList();
    }
}
