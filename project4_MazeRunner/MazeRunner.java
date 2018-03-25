import java.io.*;

class MazeRunner{
  static Maze myMap = new Maze();
  public static void main(String args[]){
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    intro(myMap);
    while(myMap.didIWin()==false){
      userMove(console);
    }
    System.out.println("Congratutions, you've made out of the maze.");
  }

  public static void intro(Maze myMap){
    System.out.println("\nWelcome to MazeRunner!\nHere is your Current Position:\n");
    myMap.printMap();
    System.out.println("---------------------------------------------------------------");
  }

  public static String userMove(BufferedReader console){
    System.out.println("Where would you like to move? (R, L, U, D)");
    String move = "";
    try{
      move = console.readLine().toLowerCase();
    } catch(Exception e1){
      System.out.println("Error in reading move: " + e1);
    }
    if (move.matches("[udlr]")) {
      System.out.println("You chose to move: " + move);
    } else{
      System.out.println("You can only move Left(L), Right(R), Up(U) or Down(D)");
      userMove(console);
    }

    switch(move){
      case "u":
        if(myMap.canIMoveUp() == false){
          System.out.println("Sorry, you've hit a wall!\npick a new Direction:");
          move = userMove(console);
        } else{
            myMap.moveUp();
        }
      case "d":
        if(myMap.canIMoveDown() == false){
          System.out.println("Sorry, you've hit a wall!\npick a new Direction:");
          move = userMove(console);
        } else{
            myMap.moveDown();
        }
      case "r":
        if(myMap.canIMoveRight() == false){
          System.out.println("Sorry, you've hit a wall!\npick a new Direction:");
          move = userMove(console);
        } else{
            myMap.moveRight();
        }
      case "l":
        if(myMap.canIMoveLeft() == false){
          System.out.println("Sorry, you've hit a wall!\npick a new Direction:");
          move = userMove(console);
        } else{
            myMap.moveLeft();
        }
    }

    return move;

  }

}
