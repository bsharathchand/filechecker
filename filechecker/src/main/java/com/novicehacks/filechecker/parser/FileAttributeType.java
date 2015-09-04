package com.novicehacks.filechecker.parser;

import java.io.Serializable;

public class FileAttributeType implements Serializable {

    private String filename;
    private String fileSize;
    private String modifiedDate;
    private boolean isSymbolicLink;

}
