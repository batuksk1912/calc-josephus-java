/**
 * Created by Mac on 31.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class MyQueue<E> implements Queue<E> {

        protected Node<E> head;
        protected Node<E> tail;
        protected int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public void enqueue(E elem) {
            Node<E> node = new Node<E>();
            node.setElement(elem);
            node.setNext(null);
            if (size == 0)
                head = node;
            else
                tail.setNext(node);
            tail = node;
            size++;
        }

        public E dequeue() throws EmptyQueueException {
            if (size == 0)
                throw new EmptyQueueException("Queue is empty.");
            E tmp = head.getElement();
            head = head.getNext();
            size--;
            if (size == 0)
                tail = null;
            return tmp;
        }

        public int size() { return size; }

        public boolean isEmpty() {
            return size == 0;
        }

        public E front() throws EmptyQueueException{
            if (isEmpty()) throw new EmptyQueueException("Queue is empty.");
            return head.getElement();
        }

        public String toString() {
            Node<E> temp = head;

            String s;
            s = "[";

            for (int i = 1; i <= size(); i++){
                if(i==1)
                    s += temp.getElement();
                else
                    s += ", " + temp.getElement();
                temp = temp.getNext();
            }

            return s + "]";
        }
}

