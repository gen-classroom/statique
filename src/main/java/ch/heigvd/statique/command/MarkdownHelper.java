package ch.heigvd.statique.command;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import java.io.IOException;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownHelper implements Helper<String> {

  private Parser parser = Parser.builder().build();

  private HtmlRenderer renderer = HtmlRenderer.builder().build();

  @Override
  public Object apply(String markdown, Options options) throws IOException {
    Node document = parser.parse(markdown);
    return renderer.render(document);
  }

}
