package ch.heigvd.statique.command;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;


@Command(name = "init", description = "Initialize a static site directory")
public class Init implements Callable<Integer> {

  @Parameters(paramLabel = "SITE", description = "The site to build")
  public Path site;

  @Override public Integer call() throws URISyntaxException, IOException {
    URI uri = this.getClass().getResource("/init").toURI();

    // Initialize the zip file system
    Map<String, String> env = new HashMap<>();
    env.put("create", "true");
    FileSystems.newFileSystem(uri, env);

    Path template = Paths.get(uri);
    Files.walk(template).forEach(source -> {
      try {
        if (Files.isRegularFile(source)) {
          // The FileSystem (file or jar) is inferred by the path.
          // As we copy files from the jar to the filesystem,
          // the toString method is called to prevent a wrong inference.
          Path target = site.resolve(template.relativize(source).toString());
          Files.createDirectories(target.getParent());
          Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    return 0;
  }

}