package com.novicehacks.filechecker.parser;

import java.util.Comparator;

import org.springframework.stereotype.Component;

/**
 * Comparator for the {@link DirectoryTreeType}, based on the size attribute
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 * @see DirectoryTreeDateComparator
 * @see DirectoryTreeNameComparator
 */
@Component
public class DirectoryTreeSizeComparator implements DirectoryTreeTypeComparator {

    public int compare(DirectoryTreeType object1, DirectoryTreeType object2) {
        String filesize1, filesize2;
        filesize1 = getFileSize (object1);
        filesize2 = getFileSize (object2);
        return filesize1.compareTo (filesize2);
    }

    /**
     * gets the filename from the directorytree object.
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
    private String getFileSize(DirectoryTreeType object) {
        if (object == null || object.getCurrentNode () == null
                || object.getCurrentNode ().getFileSize () == null)
            return "";
        else
            return object.getCurrentNode ().getFileSize ();
    }

}
