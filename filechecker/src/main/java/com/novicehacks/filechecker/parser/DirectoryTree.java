package com.novicehacks.filechecker.parser;

import java.io.Serializable;
import java.util.Set;

public class DirectoryTree implements Serializable {

    private Set<FileAttributeType> leafNodes;
    private Set<DirectoryTree> subDirectoryTreeNodes;
    private FileAttributeType currentNode;

}
