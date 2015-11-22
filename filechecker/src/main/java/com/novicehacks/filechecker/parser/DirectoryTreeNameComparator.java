package com.novicehacks.filechecker.parser;

import org.springframework.stereotype.Component;

/**
 * Comparator for {@link DirectoryTreeType}, based on the name.
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 * @see DirectoryTreeDateComparator
 * @see DirectoryTreeSizeComparator
 */
@Component
public class DirectoryTreeNameComparator implements DirectoryTreeTypeComparator {

    public int compare(DirectoryTreeType object1, DirectoryTreeType object2) {
        String filename1, filename2;
        filename1 = getFileName (object1);
        filename2 = getFileName (object2);
        return filename1.compareTo (filename2);
    }

    /**
     * gets the filename from the directory tree object.
     * 
     * Returns empty string if either object is null or if currentNode on the
     * object is null or the filename is null on the current node
     * else returns the value of the filename
     * 
     * Never returns a null, to prevent the NPE's in the comparator.
     * 
     * @param object
     * @return empty string or actual file name
     */
    private String getFileName(DirectoryTreeType object) {
        if (object == null || object.getCurrentNode () == null
                || object.getCurrentNode ().getFilename () == null)
            return "";
        else
            return object.getCurrentNode ().getFilename ();
    }

}
