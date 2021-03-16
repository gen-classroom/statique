package ch.heigvd.statique;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class StatiqueTest {

  private final ByteArrayOutputStream ouptu = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(ouptu));
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void result() throws Exception {
    int exitCode = new CommandLine(new Statique()).execute();
    assertEquals(exitCode, 0);
  }

  @Test
  void output() throws Exception {
    new CommandLine(new Statique()).execute("init");
    assertTrue(ouptu.toString().contains("init"));
  }

}