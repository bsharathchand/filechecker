package com.novicehacks.filechecker.parser;

import java.io.Serializable;
import java.util.Set;

public class DirectoryTreeType implements Serializable {

    private static final long serialVersionUID = -2080397156838252815L;
    private Set<FileAttributeType> leafNodes;
    private Set<DirectoryTreeType> subDirectoryTreeNodes;
    private FileAttributeType currentNode;

}
