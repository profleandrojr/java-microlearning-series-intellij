public class Main {
   public static void main(String[] args) {

      // GOAL: Change 'Hello, World' to 'Hello... Duke, the Decepticon'

      // String variable
      String greeting = "Hello, World";

      System.out.println(greeting); // Output: Hello, World

      // Get the index of the comma
      int indexChar = greeting.indexOf(",");

      // Change the reference by creating a new String
      greeting = greeting.substring(0, indexChar) + "... Duke, the Decepticon";

      System.out.println(greeting); // Output: Hello... Duke, the Decepticon
   }
}