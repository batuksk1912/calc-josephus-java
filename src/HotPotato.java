/**
 * Created by Mac on 31.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class HotPotato {

    public static <E> E HotPotato(Queue<E> Q, int k) {
        if (Q.isEmpty()) return null;
        while (Q.size() > 1) {
            System.out.println("  Queue : " + Q + "  Passes = " + k);
            for (int i=0; i < k; i++)
                Q.enqueue(Q.dequeue());
            E e = Q.dequeue();
            System.out.println("    " + e + " is out.");
        }
        return Q.dequeue();
    }
}
