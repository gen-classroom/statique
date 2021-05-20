package ch.heigvd.statique.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "clean", description = "Clean a static site")
public class Clean implements Callable<Integer> {

  @Parameters(paramLabel = "SITE", description = "The site to build")
  public Path site;

  @Override public Integer call() throws IOException {
    Path build = site.resolve("build");
    Utils.deleteRecursive(build);
    return 0;
  }

}