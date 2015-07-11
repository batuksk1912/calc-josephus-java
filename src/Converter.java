/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class Converter {

    private String exp;
    private MyStack<Character> myStack = new MyStack<Character>();

    public Converter(String exp) {
        this.exp = exp;
    }

    public String InfixToPostfix() {

        String postFix = "";
        for(int i = 0; i < exp.length(); i++)
        {
            char character = exp.charAt(i);
            if(isOperator(character))
            {
                while(!myStack.isEmpty() && Precedence(myStack.top())>= Precedence(character))
                    postFix += myStack.pop() + " ";
                myStack.push(character);
            }
            else if(character == '(')
            {
                myStack.push(character);
            }
            else if(character == ')')
            {
                while(myStack.top() != '(')
                    postFix += myStack.pop() + " ";
                myStack.pop();
            }
            else
            {
                if(isOperand(character) && (i + 1) < exp.length() && isOperand(exp.charAt(i+1)))
                {
                    postFix += character;
                }
                else if(isOperand(character))
                {
                    postFix += character + " ";
                }
            }
        }
        while(!myStack.isEmpty() && myStack.top() != '(')
        {
            postFix += myStack.pop() + " ";
        }
        if (myStack.size() > 0) {
            throw new FullStackException("Expression is unbalanced. Please enter correct one !");
        } else {
            return postFix;
        }
    }

    public String PrefixToPostfix() {

        char flag = '#';
        String postFix = "";
        for(int i=0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if (isOperator(c)) {
                myStack.push(c);
            } else if (isOperand(c))  {
                postFix += c + " ";
                while (!myStack.isEmpty() && myStack.top() == '#') {
                    myStack.pop();
                    postFix += myStack.pop() + " ";
                }
                myStack.push(flag);
            }
        }
        return postFix;
    }

    private boolean isOperand(char c) {
        if(c >= '0' && c <= '9') return true;
        return false;
    }

    private boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/') return true;
        return false;
    }

    private static int Precedence(char operator)
    {
        if(operator == '+' || operator =='-')
            return 1;
        else if(operator == '*' || operator == '/')
            return 2;
        else
            return 0;
    }
}
