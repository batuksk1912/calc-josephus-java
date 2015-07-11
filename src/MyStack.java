/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class MyStack<E> implements Stack<E> {

        protected MyLinkedList<E> MyLL;

        public MyStack() {
            MyLL = new MyLinkedList<E>();
        }

        public int size() {
            return MyLL.size();
        }

        public boolean isEmpty() {
            return MyLL.isEmpty();
        }

        public void push(E element) {
            MyLL.addFirst(new Node<E>(element,null));
        }

        public E top() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException("Expression is unbalanced. Please enter correct one !");
            return MyLL.head.getElement();
        }

        public E pop() throws EmptyStackException {
            Node<E> n;
            if (isEmpty())
                throw new EmptyStackException("Expression is unbalanced. Please enter correct one !");
            n = MyLL.removeFirst();

            return n.getElement();
        }
        public void printStack(){
            MyLL.printList();
        }
}
