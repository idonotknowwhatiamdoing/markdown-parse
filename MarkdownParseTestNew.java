import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTestNew {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void noBrackets() throws IOException {
        String contents = Files.readString(Path.of("./test-issue-1.md"));
        assertEquals(new ArrayList<>(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void hasImage() throws IOException {
        ArrayList<String> hasImage = new ArrayList<String>();
        hasImage.add("link.com");
        String contents = Files.readString(Path.of("./test-issue-2.md"));
        assertEquals(hasImage, MarkdownParse.getLinks(contents));
    }

    @Test
    public void textBetween() throws IOException {
        String contents = Files.readString(Path.of("./test-issue-3.md"));
        assertEquals(new ArrayList<>(), MarkdownParse.getLinks(contents));
    }

}