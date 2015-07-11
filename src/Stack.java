/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public interface Stack<E> {
    public int size();
    public boolean isEmpty();
    public E top()
            throws EmptyStackException;
    public E pop()
            throws EmptyStackException;
}
