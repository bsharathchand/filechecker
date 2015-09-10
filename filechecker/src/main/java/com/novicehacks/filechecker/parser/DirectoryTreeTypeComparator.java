package com.novicehacks.filechecker.parser;

import java.util.Comparator;

import org.springframework.stereotype.Component;

/**
 * Supertype of all Comparators, related to {@link DirectoryTreeType}
 * 
 * @author Sharath Chand Bhaskara for NoviceHacks!
 *
 * @see DirectoryTreeDateComparator
 * @see DirectoryTreeSizeComparator
 * @see DirectoryTreeNameComparator
 */
@Component
public interface DirectoryTreeTypeComparator extends Comparator<DirectoryTreeType> {

}
