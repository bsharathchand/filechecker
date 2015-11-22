package com.novicehacks.filechecker.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class DirectoryParserTest {
    private static final String PathPrefix = "target/test-classes/";

    private static final String ParseDirectory1 = "parser-sample-directory";
    private static final String ParseDirectory2 = "parser-sample-directory2";

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
        DirectoryTreeType directoryTree = parser.getParsedDirectoryTree ();

        assertNotNull ("Directory tree should not be null after parsing", directoryTree);
        assertThat ("Return type of parsed directory must be DirectoryTreeType", directoryTree,
                CoreMatchers.isA (DirectoryTreeType.class));
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

    @Test
    public void testDirectoryStructureFromParser() throws ParserException {
        logger.entry ("TestMethod: testDirectoryStructureFromParser");
        final String fileName = PathPrefix + ParseDirectory1;
        DirectoryTreeType expected = getExpectedDirectoryTree (ParseDirectory1);

        parser.setDirectoryPath (fileName);
        parser.parseDirectory ();
        DirectoryTreeType actual = parser.getParsedDirectoryTree ();

        assertNotNull ("Feature not implemented", actual);
    }

    private DirectoryTreeType getExpectedDirectoryTree(String directoryName) {
        if (directoryName.equals (ParseDirectory1)) {
            DirectoryTreeType directory = new DirectoryTreeType ();
            FileAttributeType directoryAttribute = new FileAttributeType ();
            directoryAttribute.setFilename ("parser-sample-director");
            directoryAttribute.setFileSize ("170");
            directory.setCurrentNode (directoryAttribute);

            Set<FileAttributeType> leafNodes = new HashSet<FileAttributeType> ();
            FileAttributeType childNode1 = new FileAttributeType ();
            childNode1.setFilename ("samplefile1.xml");
            childNode1.setFileSize ("0");
            leafNodes.add (childNode1);
            FileAttributeType childNode2 = new FileAttributeType ();
            childNode2.setFilename ("samplefile2.xml");
            childNode2.setFileSize ("0");
            leafNodes.add (childNode2);
            directory.setLeafNodes (leafNodes);

            Set<DirectoryTreeType> subDirectoryTreeNodes = new HashSet<DirectoryTreeType> ();
            DirectoryTreeType subDirectory1 = new DirectoryTreeType ();
            FileAttributeType subDirectory1Node = new FileAttributeType ();
            subDirectory1Node.setFilename ("dir1");
            subDirectory1Node.setFileSize ("136");
            subDirectory1.setCurrentNode (subDirectory1Node);
            Set<FileAttributeType> subDirectoryLeafNodes = new HashSet<FileAttributeType> ();
            FileAttributeType subChildNode1 = new FileAttributeType ();
            childNode1.setFilename ("file1");
            childNode1.setFileSize ("0");
            leafNodes.add (subChildNode1);
            FileAttributeType subChildNode2 = new FileAttributeType ();
            childNode2.setFilename ("file2");
            childNode2.setFileSize ("0");
            leafNodes.add (subChildNode2);
            subDirectory1.setLeafNodes (subDirectoryLeafNodes);

            subDirectoryTreeNodes.add (subDirectory1);
            directory.setSubDirectoryTreeNodes (subDirectoryTreeNodes);
        } else {
            DirectoryTreeType directory = new DirectoryTreeType ();
            FileAttributeType directoryAttribute = new FileAttributeType ();
            directoryAttribute.setFilename ("parser-sample-directory2");
            directoryAttribute.setFileSize ("102");
            directory.setCurrentNode (directoryAttribute);

        }
        return null;
    }

}
