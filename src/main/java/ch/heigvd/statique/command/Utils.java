package ch.heigvd.statique.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class Utils {

  public static void deleteRecursive(Path directory) throws IOException {
    if (Files.exists(directory)) {
      Files.walk(directory)
          .sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          .forEach(File::delete);
    }
  }

}
