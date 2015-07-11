import java.util.Scanner;

/**
 * Created by Mac on 31.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class Evaluation {

    private MyStack<Integer> myStack;
    private String exp;

    public Evaluation(String exp) {
        this.exp = exp;
    }

    public int evaluate()
    {
        Scanner scan = new Scanner(exp);
        myStack = new MyStack<Integer>();

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int token = scan.nextInt();
                myStack.push (token);
            }
            else {
                String op = scan.next();
                int operandTwo = myStack.pop();
                int operandOne = myStack.pop();
                if (op.equals("+")) {
                    myStack.push (operandOne+operandTwo);
                }
                else if (op.equals("-")) {
                    myStack.push (operandOne-operandTwo);
                }
                else if (op.equals("*")) {
                    myStack.push (operandOne*operandTwo);
                }
                else if (op.equals("/")) {
                    if (operandTwo == 0) {
                        throw new ArithmeticException("Expression cannot divide by 0.");
                    } else {
                        myStack.push (operandOne/operandTwo);
                    }
                }
            }
        }
        return myStack.pop();
    }
}
