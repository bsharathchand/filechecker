package com.novicehacks.filechecker.parser;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class DirectoryTreeType implements Serializable {

    private static final long serialVersionUID = -2080397156838252815L;
    private Set<FileAttributeType> leafNodes;
    private Set<DirectoryTreeType> subDirectoryTreeNodes;
    private FileAttributeType currentNode;

    public Set<FileAttributeType> getLeafNodes() {
        return leafNodes;
    }

    public void setLeafNodes(Set<FileAttributeType> leafNodes) {
        this.leafNodes = leafNodes;
    }

    public Set<DirectoryTreeType> getSubDirectoryTreeNodes() {
        return subDirectoryTreeNodes;
    }

    public void setSubDirectoryTreeNodes(Set<DirectoryTreeType> subDirectoryTreeNodes) {
        this.subDirectoryTreeNodes = subDirectoryTreeNodes;
    }

    public FileAttributeType getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(FileAttributeType currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public boolean equals(Object temp) {
        if (temp instanceof DirectoryTreeType) {
            DirectoryTreeType object = (DirectoryTreeType) temp;
            if (getCurrentNodeEquality (object) && getLeafNodeEquality (object)
                    && getSubDirectoriesNodeEquality (object)) {
                return true;
            }

        }
        return false;
    }

    private boolean getSubDirectoriesNodeEquality(DirectoryTreeType object) {
        if ((getSubDirectoryTreeNodes () == null && object.getSubDirectoryTreeNodes () == null)
                || (getSubDirectoryTreeNodes () != null && getSubDirectoryTreeNodes ().equals (
                        object.getSubDirectoryTreeNodes ()))) {
            return true;
        }
        return false;
    }

    private boolean getLeafNodeEquality(DirectoryTreeType object) {
        if ((getLeafNodes () == null && object.getLeafNodes () == null)
                || (getLeafNodes () != null && getLeafNodes ().equals (object.getLeafNodes ()))) {
            return true;
        }
        return false;
    }

    private boolean getCurrentNodeEquality(DirectoryTreeType object) {
        if ((getCurrentNode () == null && object.getCurrentNode () == null)
                || (getCurrentNode ().equals (object.getCurrentNode ()))) {
            return true;
        }
        return false;
    }
}
