package GuessTheNumber;

import java.util.*;

class guessnumber {
  private int ran_no;
  Random random = new Random();

  void setnumber() {
    ran_no = random.nextInt(1000);
  }

  int getnumber() {
    return ran_no;
  }
}

public class Guess_The_no_game {

  public static void main(String[] args) {
    int guess = 0, ui;
    Scanner sc = new Scanner(System.in);
    guessnumber g = new guessnumber();
    g.setnumber();
    // System.out.println("Number generated: "+ g.getnumber());
    while (true) {
      System.out.println("Enter a number(0-1000): ");
      ui = sc.nextInt();
      if (ui > g.getnumber()) {
        System.out.println("your number is greater than the number");
        guess++;
      } else if (ui < g.getnumber()) {
        System.out.println("your number is smaller than the number");
        guess++;
      } else {
        System.out.println("you guessed correct number");
        guess++;
        System.out.println("Number of guess made: " + guess);
        return;
      }
    }
  }
}
