package ch.heigvd.statique;

import ch.heigvd.statique.command.Build;
import ch.heigvd.statique.command.Clean;
import ch.heigvd.statique.command.Init;
import ch.heigvd.statique.command.Serve;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "statique",
    description = "A brand new static site generator.",
    subcommands = {Init.class, Clean.class, Build.class, Serve.class})
public class Statique implements Callable<Integer> {

  public static void main(String... args) {
    int exitCode = new CommandLine(new Statique()).execute(args);
    if (exitCode != 0) {
      System.exit(exitCode);
    }
  }

  @Override
  public Integer call() throws Exception {
    CommandLine.usage(this, System.out);
    return 0;
  }
}
