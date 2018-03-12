import java.util.*;
import java.io.*;

class OddsAndEvens{
  static int UserScore = 0;
  static int computerScore = 0;

  public static void main(String args[]){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String name = "", choice="";

    System.out.println("______________________________________________________________________________");
    System.out.println();
    System.out.println("Let's play a game called Odds and Evens");

    System.out.print("What is your name? ");
    try{
      name = console.readLine();
    } catch(Exception e){
      System.out.println("Error while name input: " + e);
    }

    System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
    try{
      choice = console.readLine().toLowerCase();
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

    while(play(console, name, choice, UserScore, computerScore).startsWith("y")){
      play(console, name, choice, UserScore, computerScore);
    }

  }

  public static String play(BufferedReader console, String name, String choice, int UserScore, int computerScore){
    int numberOfFingers = 0;
    ArrayList<Integer> UserScoreArray = new ArrayList<Integer>();
    ArrayList<Integer> computerScoreArray = new ArrayList<Integer>();

    UserScoreArray.add(0);
    computerScoreArray.add(0);

    System.out.println("How many 'fingers' do you put out?(You can only put out 5 fingers)");
    try{
      numberOfFingers = Integer.parseInt(console.readLine());
    } catch(Exception e1){
      System.out.println("Error while, taking number of fingers: " + e1);
    }
    if(numberOfFingers > 5){
      System.out.println("You cannot put out more than 5 fingers " + name);
      System.out.println("Let's try again!");
      play(console, name, choice, UserScore, computerScore);
    }

    Random rand = new Random();
    int computerFingers = rand.nextInt(6);

    System.out.println("The computer played: " + computerFingers);

    int sum = numberOfFingers + computerFingers;
    System.out.println("sum = " + numberOfFingers  + "+" + computerFingers);

    if(sum%2 == 0){
      System.out.println(sum + " is. . . . Even");
      if(choice.startsWith("e")){
        System.out.println("The Winner is " + name);
        UserScore++;
        UserScoreArray.add(UserScore);
        System.out.println(name + "'s score: " + UserScoreArray.get(UserScoreArray.size() - 1));
        System.out.println("Computer's score: " + computerScoreArray.get(computerScoreArray.size() - 1));
      } else{
        System.out.println("The Winner is Computer");
        computerScore++;
        computerScoreArray.add(computerScore);
        System.out.println(name + "'s score: " + UserScoreArray.get(UserScoreArray.size() - 1));
        System.out.println("Computer's score: " + computerScoreArray.get(computerScoreArray.size() - 1));
      }
    } else{
        System.out.println(sum + " is. . . . Odd");
        if(choice.startsWith("o")){
          System.out.println("The Winner is " + name);
          UserScore++;
          UserScoreArray.add(UserScore);
          System.out.println(name + "'s score: " + UserScoreArray.get(UserScoreArray.size() - 1));
          System.out.println("Computer's score: " + computerScoreArray.get(computerScoreArray.size() - 1));
        } else{
          System.out.println("The Winner is Computer");
          computerScore++;
          computerScoreArray.add(computerScore);
          System.out.println(name + "'s score: " + UserScoreArray.get(UserScoreArray.size() - 1));
          System.out.println("Computer's score: " + computerScoreArray.get(computerScoreArray.size() - 1));
        }
    }

    System.out.println("______________________________________________________________________________");

    System.out.println();

    System.out.println("How does the Score look like " + name + ", Want to Play again?(y or n)");

    String playAgain = "";

    try{
      playAgain = console.readLine().toLowerCase();
    } catch(Exception e3){
      System.out.println("Error in function for playAgain: " + e3);
    }

    if(playAgain.startsWith("y")){
      System.out.println("Starting another game-");
      return playAgain;
    }
    else{
      System.out.println("Thank you for playing, see you soon..");
      System.exit(0);
    }
    return "p";
  }

}
