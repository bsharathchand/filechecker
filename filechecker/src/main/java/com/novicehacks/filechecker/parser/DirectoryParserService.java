package com.novicehacks.filechecker.parser;

public interface DirectoryParserService {

    public void parseDirectory() throws ParserException;

    public void setDirectoryPath(String path) throws ParserException;

    public DirectoryTreeType getParsedDirectoryTree();
}
