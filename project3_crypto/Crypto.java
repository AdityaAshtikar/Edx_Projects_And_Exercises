class Crypto{
  public static void main(String[] args){
    text = normalizeText("Hello, !@#$%^&*() World. Oh re chori BAAT MORI DIL SE(**(&$&&)(:}{:{:>NIKLI}}))");
    System.out.print(text);
    text = caesarify(text, 1);
  }

  public static String normalizeText(String text){
    // text = text.replaceAll("[\\s.,'\"!?@#$%^&*()]", "").toUpperCase();
    text = text.replaceAll("[^a-zA-Z]", "").toUpperCase();
    return text;
  }

  public static String caesarify(String text, int shiftValue){
    
  }

}
