class SpaceAndTriangle {

  public static void main(String args[]){

    int i=1, j=1, k=1;

    for(i=1; i<=5; i++){
      for(j=5; j>i; j--){
        System.out.print(" ");
      }
      for(k=1; k<=i; k++){
        System.out.print(i);
      }
      System.out.println();
    }

  }
}
