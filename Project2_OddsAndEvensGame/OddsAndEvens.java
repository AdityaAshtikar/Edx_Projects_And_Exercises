import java.util.*;

class OddsAndEvens{
  public static void main(String args[]){
    Scanner console = new Scanner(System.in);
    String name = "", choice="";

    System.out.println("______________________________________________________________________________");
    System.out.println();
    System.out.println("Let's play a game called Odds and Evens");

    System.out.print("What is your name? ");
    try{
      name = console.nextLine();
    } catch(Exception e){
      System.out.println("Error while name input: " + e);
    }

    System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
    try{
      choice = console.nextLine().toLowerCase();
    } catch(Exception e){
      System.out.println("Error while Choosing Odd or Even: " + e);
    }

    if(choice.startsWith("o")){
      System.out.println(name + " chose ODDS, the Computer will be EVENS");
    } else if(choice.startsWith("e")){
      System.out.println(name + " chose EVENS, the Computer will be ODDS");
    } else{
      System.out.println("Enter a valid choice "+ name + "..Either O(o) or E(e)");
    }

    System.out.println("______________________________________________________________________________");
    System.out.println();

    String playAgain = "y";
    while(playAgain.startsWith("y")){
      play(console, name, choice);
      System.out.println("How does the Score look like " + name + ", Want to Play again?(y or n)");
      playAgain = console.nextLine().toLowerCase();
      if(playAgain.startsWith("n")){
        System.out.println("Thanks for playing..See you soon!");
      }
    }

  }

  public static void play(Scanner console, String name, String choice){
    int numberOfFingers = 0;
    System.out.println("How many 'fingers' do you put out?(You can only put out 5 fingers)");
    try{
      numberOfFingers = console.nextInt();
    } catch(Exception e1){
      System.out.println("Error while, taking number of fingers: " + e1);
    }
    if(numberOfFingers > 5){
      System.out.println("You cannot put out more than 5 fingers " + name);
      System.out.println("Let's try again!");
      play(console, name, choice);
    }

    Random rand = new Random();
    int computerFingers = rand.nextInt(6);
    int UserScore = 0;
    int computerScore = 0;

    System.out.println("The computer played: " + computerFingers);

    int sum = numberOfFingers + computerFingers;
    System.out.println("sum = " + numberOfFingers  + "+" + computerFingers);

    if(sum%2 == 0){
      System.out.println(sum + " is. . . . Even");
      if(choice.startsWith("e")){
        System.out.println("The Winner is " + name);
        UserScore++;
        System.out.println(name + "'s score: " + UserScore);
        System.out.println("Computer's score: " + computerScore);
      } else{
        System.out.println("The Winner is Computer");
        computerScore++;
        System.out.println(name + "'s score: " + UserScore);
        System.out.println("Computer's score: " + computerScore);
      }
    } else{
        System.out.println(sum + " is. . . . Odd");
        if(choice.startsWith("o")){
          System.out.println("The Winner is " + name);
          UserScore++;
          System.out.println(name + "'s score: " + UserScore);
          System.out.println("Computer's score: " + computerScore);
        } else{
          System.out.println("The Winner is Computer");
          computerScore++;
          System.out.println(name + "'s score: " + UserScore);
          System.out.println("Computer's score: " + computerScore);
        }
    }

    System.out.println("______________________________________________________________________________");

  }
}
