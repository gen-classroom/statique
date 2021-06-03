package ch.heigvd.statique;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class StatiqueTest {

  @Test
  void result() throws Exception {
    int exitCode = new CommandLine(new Statique()).execute();
    assertEquals(exitCode, 0);
    assertThrows(Exception.class, () -> {
      throw new Exception();
    });
  }

  @Test
  void output() throws Exception {
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(output));
      new CommandLine(new Statique()).execute();
      assertTrue((output.toString().contains("A brand new static site generator.")));
    }
  }

}