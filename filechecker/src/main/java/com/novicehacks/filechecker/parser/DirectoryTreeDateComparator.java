package com.novicehacks.filechecker.parser;

import java.util.Comparator;

import org.springframework.stereotype.Component;

/**
 * Comparator for {@link DirectoryTreeType}, based on the modified date
 * attribute.
 * Note: Feature not implemented. Do not use this comparator, only for future
 * purpose.
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 *
 * @see DirectoryTreeNameComparator
 * @see DirectoryTreeSizeComparator
 */
@Component
public class DirectoryTreeDateComparator implements DirectoryTreeTypeComparator {

    public int compare(DirectoryTreeType o1, DirectoryTreeType o2) {
        throw new UnsupportedOperationException ("Feature not implemented yet");
    }

}
