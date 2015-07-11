/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class MyLinkedList<E> implements LinkedList<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(Node<E> newNode) {
        if(size == 0)
            tail = newNode;

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(Node<E> newNode) {
        newNode.setNext(null);

        if(size == 0)
            head = newNode;

        if (size != 0)
            tail.setNext(newNode);

        tail = newNode;
        size++;
    }

    public Node<E> removeFirst() {
        Node<E> tempNode = null;
        if (size != 0) {
            if(size == 1)
                tail = null;

            tempNode = head;
            head = head.getNext();
            tempNode.setNext(null);
            size--;
        }
        return tempNode;
    }

    public Node<E> removeLast() {
        Node tempNode = head;

        if(size == 0)
            return null;

        if(size == 1) {
            head = null;
            tail = null;
            size--;
            return tempNode;
        }

        for(int i=1; i<=size-2; i++) {
            tempNode = tempNode.getNext();
        }

        Node tempNode2 = tail;
        tail = tempNode;
        tail.setNext(null);
        size--;
        return tempNode2;

    }

    public int searchList(E searchKey) {
        if(size == 0)
            return -1;

        Node tempNode = head;
        for(int i=1; i<=size; i++) {
            if(tempNode.getElement().equals(searchKey))
                return i;
            tempNode = tempNode.getNext();
        }

        return -1;
    }

    public void printList() {
        Node tempNode = head;
        for(int i=1; i<=size; i++) {
            System.out.print(tempNode.getElement());
            if(i!=size)
                System.out.print(" - ");
            tempNode = tempNode.getNext();
        }
        System.out.println();
    }
}
