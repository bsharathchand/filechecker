package com.novicehacks.filechecker.parser;

import org.springframework.stereotype.Component;

/**
 * Service interface for parsing the directory structures.
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 * @see DirectoryParser
 */
@Component
public interface DirectoryParserService {

    public void parseDirectory() throws ParserException;

    public void setDirectoryPath(String path) throws ParserException;

    public DirectoryTreeType getParsedDirectoryTree();
}
