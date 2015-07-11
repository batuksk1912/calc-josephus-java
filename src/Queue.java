/**
 * Created by Mac on 31.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public interface Queue<E> {
        public int size();
        public boolean isEmpty();
        public E front() throws EmptyQueueException;
        public void enqueue (E element);
        public E dequeue() throws EmptyQueueException;
    }

