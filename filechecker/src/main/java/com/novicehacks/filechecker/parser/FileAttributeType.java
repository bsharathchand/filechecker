package com.novicehacks.filechecker.parser;

import java.io.Serializable;

public class FileAttributeType implements Serializable {

    private String filename;
    private String fileSize;
    private String modifiedDate;
    private boolean isSymbolicLink;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isSymbolicLink() {
        return isSymbolicLink;
    }

    public void setSymbolicLink(boolean isSymbolicLink) {
        this.isSymbolicLink = isSymbolicLink;
    }

    @Override
    public boolean equals(Object temp) {
        if (temp instanceof FileAttributeType) {
            FileAttributeType object = (FileAttributeType) temp;
            if (isFilenameEqual (object) && isFileSizeEqual (object)
                    && isModifiedDateEqual (object) && isSymbolicLinkStatusEqual (object)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSymbolicLinkStatusEqual(FileAttributeType object) {
        return isSymbolicLink () == object.isSymbolicLink ();
    }

    private boolean isModifiedDateEqual(FileAttributeType object) {
        return getFieldEquality (getModifiedDate (), object.getModifiedDate ());
    }

    private boolean isFileSizeEqual(FileAttributeType object) {
        return getFieldEquality (getFileSize (), object.getFileSize ());
    }

    private boolean isFilenameEqual(FileAttributeType object) {
        return getFieldEquality (getFilename (), object.getFilename ());
    }

    private boolean getFieldEquality(String actual, String other) {
        if ((actual == null && other == null) || (actual != null && actual.equals (other))) {
            return true;
        }
        return false;
    }
}
