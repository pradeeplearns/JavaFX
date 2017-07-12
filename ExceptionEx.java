package sample;

public class ExceptionEx {

  public static void main(String[] args) {
    String s = "1";

    try {
      int a = Integer.parseInt(s);
      System.out.println(a);
      devide(2, 0);
    } catch (Exception e) {
      System.out.println("Please enter a correct number");
    }

    System.out.println("I am after it");
  }

  private static void devide(int a, int b) throws Exception {
    if(b == 0) {
      throw new Exception();
    }
  }

}
