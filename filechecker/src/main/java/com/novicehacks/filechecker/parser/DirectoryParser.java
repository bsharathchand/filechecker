package com.novicehacks.filechecker.parser;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Implementation for the {@link DirectoryParserService}.
 * 
 * Will parse the directories specified in a path and create a data-structure
 * defined by {@link DirectoryTreeType} at the end of parsing.
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 *
 */
@Component
public class DirectoryParser implements DirectoryParserService {

    private static final String Path_Null_Msg = "Directory path cannot be null or empty string";
    private static final String Path_NotExists_Msg = "Directory path does not exist";
    private static final String Path_IsFile_Msg = "Input path is not a directory : ";

    Logger logger = LogManager.getLogger (getClass ());

    private String directoryPathString;
    private Path directoryPath;

    /**
     * sets the directoryPath for the parser to parse.
     * 
     * @param path
     * @throws ParserException
     *         if input is null or empty string.
     */
    public void setDirectoryPath(String path) throws ParserException {
        checkNullorEmptyString (path);
        this.directoryPathString = path;
    }

    private void checkNullorEmptyString(String path) throws ParserException {
        if (path == null || "".equals (path.trim ())) {
            throw new ParserException (Path_Null_Msg);
        }
    }

    public void parseDirectory() throws ParserException {
        logger.entry (directoryPathString);
        directoryPath = getPathFromPathString (directoryPathString);
        logger.debug ("path framed from the input string is {}", directoryPath.toString ());
        validateDirectoryPathToProceed ();
        logger.exit (directoryPathString);
    }

    private void validateDirectoryPathToProceed() throws ParserException {
        if (Files.notExists (directoryPath, LinkOption.NOFOLLOW_LINKS)) {
            throw new ParserException (Path_NotExists_Msg);
        }
        if (!Files.isDirectory (directoryPath, LinkOption.NOFOLLOW_LINKS)) {
            throw new ParserException (Path_IsFile_Msg + directoryPathString);
        }
    }

    Path getPathFromPathString(String pathString) {
        Path dirPath = Paths.get (pathString);
        return dirPath;
    }

    public DirectoryTreeType getParsedDirectoryTree() {
        logger.entry ("Creating the directory tree for the path: "+directoryPathString);
        return new DirectoryTreeType ();
    }

}
