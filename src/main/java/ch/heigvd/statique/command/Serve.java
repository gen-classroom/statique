package ch.heigvd.statique.command;

import com.sun.net.httpserver.HttpServer;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "serve", description = "Serve a static site")
public class Serve implements Callable<Integer> {

  @Parameters(paramLabel = "SITE", description = "The site to serve")
  public Path site;

  @Override public Integer call() {
    // Build the site
    new CommandLine(new Build()).execute(site.toString());

    // Serve the site
    Javalin.create(config -> {
      config.addStaticFiles(site.resolve("build").toAbsolutePath().toString(), Location.EXTERNAL);
    }).start(8080);

    return 0;
  }

}