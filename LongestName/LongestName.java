import java.util.Scanner;
class LongestName {
  public static void longest(Scanner console, int n) {

    String name = "";
    int tie = 0;
    String longerName = "";

    for(int i=1; i<=n; i++){
      System.out.print("name #" + i + "? ");
      String currentName = console.next().toLowerCase();

      if(name.length() > currentName.length()){
          longerName = name;
      } else if(name.length() == currentName.length()){
          tie = 1;
          longerName = name;
      } else {
          tie = 0;
          longerName = currentName;
      }
      name = longerName;
    }

    if(tie == 0){
        System.out.println(capitalize(longerName) + "'s name is the longest.");
    } else{
        System.out.println(capitalize(longerName) + "'s name is the longest.\n(There was a tie!)");
    }
  }

public static String capitalize(String name){
    String s1 = name.substring(0, 1).toUpperCase();
    name = s1 + name.substring(1);
    return name;
}

public static void main(String args[]){
  Scanner console = new Scanner(System.in);
  System.out.println("Enter number of names to check for the longest name: ");
  int n = Integer.parseInt(console.next());
  longest(console, n);
}

}
