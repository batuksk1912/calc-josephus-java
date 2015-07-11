import java.util.Scanner;

/**
 * Created by Mac on 30.10.14 Baturay Kayaturk - 120315024 - Project I
 */

public class Test {

      public static void main(String[] args) {

          int c;
          Scanner in = new Scanner(System.in);
          System.out.println("1. Arithmetic Evaluation Program");
          System.out.println("2. Hot Potato Game");
          System.out.println("Please enter your choice : ");
          c = in.nextInt();
          switch (c) {
              case 1 :
                  System.out.println("1.Prefix Expression : ");
                  System.out.println("2.Infix Expression  : ");
                  int iop = in.nextInt();
                  switch (iop) {
                      case 1 :
                          System.out.println("Enter Prefix Expression : ");
                          Scanner preEx = new Scanner(System.in);
                          String exp = preEx.nextLine();
                          char control = exp.charAt(0);
                          if (control == '+' || control == '-' || control == '*'|| control == '/') {
                              Converter x = new Converter(exp);
                              String postFix = x.PrefixToPostfix();
                              System.out.println("Postfix Expression is : " + postFix);
                              Evaluation y = new Evaluation(postFix);
                              System.out.println("Result is : " + y.evaluate());
                          }
                          else {
                              System.out.println("This expression is not Prefix.");
                          }
                          break;

                      case 2 :
                          System.out.println("Enter Infix Expression : ");
                          Scanner regEx = new Scanner(System.in);
                          String expressionInfix = regEx.nextLine().replaceAll("\\s", "");
                          Converter x = new Converter(expressionInfix);
                          String postFix = x.InfixToPostfix();
                          System.out.println("Postfix Expression is : " + postFix);
                          Evaluation y = new Evaluation(postFix);
                          System.out.println("Result is : " + y.evaluate());
                          break;

                      default :
                          System.out.println("You must choose 1 or 2.");
                          break;
                  }
                  break;

              case 2 :
                  HotPotato z = new HotPotato();
                  boolean state = false;
                  System.out.print("Enter number of passes : ");
                  int passes = in.nextInt();
                  System.out.print("Enter name of players, to finish please enter DONE : ");
                  MyQueue<String> myQueue = new MyQueue<String>();
                  while (!state) {
                      String persons = in.next();
                      if (persons.equals("DONE") || persons.equals("done")) {
                          state = true;
                      } else {
                          myQueue.enqueue(persons);
                      }
                  }
                  System.out.println("Winner is " + z.HotPotato(myQueue,passes));
                  break;

              default :
                  System.out.println("You must choose 1 or 2.");
                  break;
          }
      }
}
