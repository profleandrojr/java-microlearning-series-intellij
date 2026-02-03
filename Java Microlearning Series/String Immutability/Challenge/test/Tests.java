import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

  @Test
  public void testFinalOutput() {
    String expected = "Hello... Duke! Not a Dog! But a Codecepticon!!!";

    String result = getProgramOutput().trim();

    assertEquals(expected, result);
  }

  private String getProgramOutput() {
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    java.io.PrintStream originalOut = System.out;

    System.setOut(new java.io.PrintStream(out));
    Main.main(new String[0]);
    System.setOut(originalOut);

    return out.toString();
  }
}