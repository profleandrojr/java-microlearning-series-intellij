public class Main {
    public static void main(String[] args) {

        String greeting = "Hello, World";

        int n = greeting.indexOf(",");
        greeting = greeting.substring(0, n) + "... Duke! Not a Dog! But a Codecepticon";

        // BUG: this does NOT change the original String
        greeting.concat("!!!");

        System.out.print(greeting);
    }
}