import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class wk8labreporttest {
        @Test
        public void snippetOne() throws IOException {
        List<String> expect = List.of("google.com, google.com, ucsd.edu");
        String contents = Files.readString(Path.of("./wk8labreport/snippet1.md"));
        assertEquals(expect, MarkdownParse.getLinks(contents));
        }

        @Test
        public void snippetTwo() throws IOException {
        List<String> expect = List.of("a.com, a.com(()), example.com");
        String contents = Files.readString(Path.of("./wk8labreport/snippet2.md"));
        assertEquals(expect, MarkdownParse.getLinks(contents));
        }

        @Test
        public void snippetThree() throws IOException {
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        String contents = Files.readString(Path.of("./wk8labreport/snippet3.md"));
        assertEquals(expect, MarkdownParse.getLinks(contents));
        }
}
