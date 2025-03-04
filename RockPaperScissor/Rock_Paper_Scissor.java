package RockPaperScissor;

import java.util.*;

public class Rock_Paper_Scissor {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int u, c, us = 0, cs = 0, gp = 0;
    System.out.println("Welcome to Rock Paper Scissor");
    System.out.println("0==> Rock \n1==> Paper \n2==> Scissor");
    System.out.println("-1 To exit the game");
    while (true) {
      System.out.println("Enter Your choice ");
      u = sc.nextInt();
      if (u == -1)
        break;
      else {
        gp++;
        c = random.nextInt(3);
        System.out.println("Computer chosed: " + c);
        if (c == u)
          System.out.println("Game Drawn!!");
        else if ((u == 0 && c == 2) || (u == 1 && c == 0) || (u == 2 && c == 1)) {
          us++;
          System.out.println("You Win");
        } else {
          cs++;
          System.out.println("You Lost");
        }
      }
    }
    System.out.println("Total Game Played: " + gp);
    System.out.println("You Score: " + us);
    System.out.println("Computer Score: " + cs);
    if (us == cs)
      System.out.println("Result: Game Drawn");
    else if (us > cs)
      System.out.println("Result: You Won");
    else
      System.out.println("Result: Computer Won");

  }
}
