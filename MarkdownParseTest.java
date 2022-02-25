import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException
    {
        String contents = Files.readString(Path.of("C:/Users/zhong/Desktop/markdown-parse-wk2/test-file-1.md"));
        ArrayList<String> testList = new ArrayList<>();
        assertEquals(testList, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("C:/Users/zhong/Desktop/markdown-parse-wk2/test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void testEmptyParentheses() throws IOException
    {
        String contents = Files.readString(Path.of("C:/Users/zhong/Desktop/markdown-parse-wk2/test-issue-1.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testIncompleteParentheses()  throws IOException
    {
        String contents = Files.readString(Path.of("C:/Users/zhong/Desktop/markdown-parse-wk2/test-issue-2.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testLinkWithTextBetween()  throws IOException
    {
        String contents = Files.readString(Path.of("C:/Users/zhong/Desktop/markdown-parse-wk2/test-issue-3.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
//fromwk7quiz
    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, wk7MarkdownParse.getLinks(contents));
    }
}