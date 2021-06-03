package ch.heigvd.statique.command;

import static org.junit.jupiter.api.Assertions.*;

import ch.heigvd.statique.Statique;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

class CleanTest {

  Path site;
  Path build;
  Path f1;
  Path f2;

  @BeforeEach
  void setUp() throws IOException {
    site = Files.createTempDirectory("site");
    build = Files.createDirectories(site.resolve("build"));
    f1 = Files.createFile(build.resolve("f1"));
    f2 = Files.createFile(build.resolve("f2"));
  }

  @AfterEach
  void tearDown() throws IOException {
    Utils.deleteRecursive(site);
  }

  @Test
  public void clean() {
    assertTrue(Files.exists(f1));
    assertTrue(Files.exists(f2));
    assertTrue(Files.exists(build));
    int exitCode = new CommandLine(new Statique()).execute("clean", site.toString());
    assertFalse(Files.exists(f1));
    assertFalse(Files.exists(f2));
    assertFalse(Files.exists(build));
    assertEquals(exitCode, 0);
  }

}