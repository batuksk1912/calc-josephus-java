/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public interface LinkedList<E> {
    public void addFirst(Node<E> newNode);
    public void addLast(Node<E> newNode);
    public Node<E> removeFirst();
    public Node<E> removeLast();
    public int searchList(E searchKey);
    public void printList();
    public int size();
    public boolean isEmpty();
}
