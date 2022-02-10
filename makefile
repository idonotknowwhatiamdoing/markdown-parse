test: MarkdownParse.class MarkdownParseTestNew.class
	java -cp .:./lib/* org.junit.runner.JUnitCore MarkdownParseTestNew
 
MarkdownParse.class: MarkdownParse.java
	javac -cp .:./lib/* MarkdownParse.java
 
MarkdownParseTest.class: MarkdownParseTestNew.java MarkdownParse.class
	javac -cp .:./lib/* MarkdownParseTestNew.java
