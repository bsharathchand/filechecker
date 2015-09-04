package com.novicehacks.filechecker.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class DirectoryParserTest {
    private static final String PathPrefix = "target/test-classes/";

    private Logger logger = LogManager.getLogger (getClass ());

    private DirectoryParserService parser;
    @Rule
    public ExpectedException exception = ExpectedException.none ();

    @Before
    public void setup() {
        parser = Mockito.spy (DirectoryParser.class);
    }

    @Test
    public void inputPathIsNull() throws ParserException {
        logger.trace ("TestMethod : InputPathIsNull");
        final String inputPath = null;

        exception.expect (ParserException.class);
        exception.expectMessage ("Directory path cannot be null or empty string");
        parser.setDirectoryPath (inputPath);

        fail ("Directory Path cannot be null, ParserException expected");
    }

    @Test
    public void inputPathIsEmptyStringWithSpaces() throws ParserException {
        logger.trace ("TestMethod: InputPathIsEmptyString");
        final String inputPath = "    ";

        exception.expect (ParserException.class);
        exception.expectMessage ("Directory path cannot be null or empty string");
        parser.setDirectoryPath (inputPath);

        fail ("Directory Path cannot be empty string, ParserException expected");
    }

    @Test
    public void inputPathDoesNotExists() throws ParserException {
        logger.trace ("TestMethod: InputpathDoesNotExist");
        final String inputPath = "/invalidDirectory/childDirectory";

        parser.setDirectoryPath (PathPrefix + inputPath);
        exception.expect (ParserException.class);
        exception.expectMessage ("Directory path does not exist");
        parser.parseDirectory ();

        assertTrue ("Directory Path cannot be null string", true);
    }

    @Test
    public void inputPathIsADirectory() throws ParserException {
        logger.trace ("TestMethod: InputPathIsADirectory");
        final String inputPath = "..";

        parser.setDirectoryPath (inputPath);
        parser.parseDirectory ();
        Object directoryTree = parser.getParsedDirectoryTree ();

        assertNotNull ("Directory tree should not be null after parsing", directoryTree);
    }

    @Test
    public void inputPathIsAFile() throws ParserException {
        logger.trace ("TestMethod : inputPathIsAFile");
        final String inputPath = "parser-test-file.txt";

        parser.setDirectoryPath (PathPrefix + inputPath);
        exception.expect (ParserException.class);
        exception.expectMessage ("Input path is not a directory");
        exception.expectMessage (inputPath);
        parser.parseDirectory ();

        fail ("Input path cannot be a file, ParserException expected");
    }

    @Test
    public void testFileExists() {
        logger.trace ("TestMethod: testFileExists-learning");
        final String filename = PathPrefix + "parser-test-file.txt";

        File file = new File (filename);
        logger.debug ("File exists if using File : {}", file.getAbsolutePath ());
        assertTrue ("File should be referenced, as it is in the class path.", file.exists ());

        Path filePath = Paths.get (filename);
        assertTrue ("Path should resolve, as it is in the class path",
                Files.exists (filePath, LinkOption.NOFOLLOW_LINKS));
    }

}
