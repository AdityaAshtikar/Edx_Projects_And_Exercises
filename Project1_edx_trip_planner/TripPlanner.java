import java.io.*;
import java.lang.Math;

class TripPlanner {

  public static String checkInput(){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    try {
      input = br.readLine();
      // if(input == "")
      //   throw new Exception("This field is necessary");
    } catch(Exception e){
      System.out.println("try again!");
      greeting();
    }
    return input;
  }

  public static void greeting(){
    System.out.println("Welcome to Trip Planner");
    System.out.print("Your name please: ");
    String name = checkInput();
    System.out.println("Nice to meet you " + name + '.');

    System.out.print("Where do you want to go? ");
    String place = checkInput();
    System.out.println("Awesome! " + place + " sounds like a great trip.");
  }

  public static void TimeBudget(){
    System.out.println("How many days are you going to spend in your destination?");
    double days = Double.parseDouble(checkInput());
    System.out.println("What is your total budget for the trip in USD?");
    int budget = Integer.parseInt(checkInput());
    System.out.println("What is the currency symbol for their destination? For example, the us dollar’s is USD, the euro’s is EU etc…");
    String currencySymbol = checkInput();
    System.out.println("Enter the conversion rate for conversion in "+ currencySymbol + " : ");
    double rate = Double.parseDouble(checkInput());

    System.out.println("You will be spending: " + days*24 + " hours " + days*24*60 + " minutes " + days*24*60*60 + " seconds.");
    System.out.println("Budget: " + budget*rate + currencySymbol);
  }

  public static void HowFar(){
    System.out.println("Enter your Longitude:");
    double lon1 = Double.parseDouble(checkInput());
    System.out.println("Enter your Latitude:");
    double lat1 = Double.parseDouble(checkInput());
    System.out.println("Enter Destination's Longitude:");
    double lon2 = Double.parseDouble(checkInput());
    System.out.println("Enter Destination's Latitude:");
    double lat2 = Double.parseDouble(checkInput());

    double dis = distance(lat1, lon1, lat2, lon2);
    System.out.println("The Distance is: " + dis + " KM.");
  }

  public static double distance(double lat1, double lon1, double lat2, double lon2) {
    double p = 0.0174532925;    // Math.PI / 180
    // double c = Math.cos(a)
    double a = 0.5 - Math.cos((lat2 - lat1) * p)/2 +
            Math.cos(lat1 * p) * Math.cos(lat2 * p) *
            (1 - Math.cos((lon2 - lon1) * p))/2;

    return 12742.0 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
  }

  public static void main(String[] args){
    greeting();
    TimeBudget();
    HowFar();
  }

}
