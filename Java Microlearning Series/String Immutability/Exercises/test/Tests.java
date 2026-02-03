import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

import static org.junit.Assert.*;

public class Tests {

  // Update these strings if you change the option texts in task.md
  private static final String EXPECTED_1 =
          "The String object becomes eligible for garbage collection.";
  private static final String EXPECTED_2 =
          "Strings are immutable and concat() returns a new String.";
  private static final String EXPECTED_3 =
          "The variable now references a new String object.";

  @Test
  public void testOutputMatchesExpectedAnswers() {
    String expected = String.join("\n", EXPECTED_1, EXPECTED_2, EXPECTED_3);

    String actual = runMainAndCaptureOutput()
            .replace("\r\n", "\n")
            .trim();

    assertEquals("Final output does not match the expected answers.", expected, actual);
  }

  @Test
  public void testStudentReassignedReferencesAsRequested() throws Exception {
    String source = readMainSource();

    // Require at least two occurrences:
    // 1) declaration: String answerX = ...
    // 2) reassignment: answerX = ...
    assertTrue("You must REASSIGN answer1 (do not only edit the declaration line).",
            countAssignments(source, "answer1") >= 2);

    assertTrue("You must REASSIGN answer2 (do not only edit the declaration line).",
            countAssignments(source, "answer2") >= 2);

    assertTrue("You must REASSIGN answer3 (do not only edit the declaration line).",
            countAssignments(source, "answer3") >= 2);
  }

  @Test
  public void testDoNotChangePrintLines() throws Exception {
    String source = readMainSource();

    // Tolerant to whitespace differences, but requires the same print logic.
    assertTrue("Do not change the print line for answer1.",
            source.matches("(?s).*System\\.out\\.print\\(\\s*answer1\\s*\\+\\s*\"\\\\n\"\\s*\\)\\s*;.*"));

    assertTrue("Do not change the print line for answer2.",
            source.matches("(?s).*System\\.out\\.print\\(\\s*answer2\\s*\\+\\s*\"\\\\n\"\\s*\\)\\s*;.*"));

    assertTrue("Do not change the print line for answer3.",
            source.matches("(?s).*System\\.out\\.print\\(\\s*answer3\\s*\\)\\s*;.*"));
  }

  // ----------------- Helpers -----------------

  private String runMainAndCaptureOutput() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    try {
      System.setOut(new PrintStream(out));
      Main.main(new String[0]);
    } finally {
      System.setOut(originalOut);
    }

    return out.toString();
  }

  /** Counts occurrences of: answerX = ... (declaration + reassignment should be >= 2). */
  private int countAssignments(String source, String varName) {
    Pattern p = Pattern.compile("\\b" + Pattern.quote(varName) + "\\s*=");
    Matcher m = p.matcher(source);

    int count = 0;
    while (m.find()) count++;
    return count;
  }

  /**
   * Reads Main.java from common template locations, with a fallback search.
   * This avoids breakage across different course templates.
   */
  private String readMainSource() throws Exception {
    List<Path> candidates = List.of(
            Paths.get("src", "Main.java"),
            Paths.get("Main.java"),
            Paths.get("src", "main", "java", "Main.java")
    );

    for (Path p : candidates) {
      if (Files.exists(p)) {
        return Files.readString(p, StandardCharsets.UTF_8);
      }
    }

    Path root = Paths.get(".").toAbsolutePath().normalize();
    try (var stream = Files.walk(root)) {
      Optional<Path> found = stream
              .filter(path -> path.getFileName().toString().equals("Main.java"))
              .findFirst();

      if (found.isPresent()) {
        return Files.readString(found.get(), StandardCharsets.UTF_8);
      }
    }

    throw new FileNotFoundException("Main.java was not found. Check the task project structure.");
  }
}