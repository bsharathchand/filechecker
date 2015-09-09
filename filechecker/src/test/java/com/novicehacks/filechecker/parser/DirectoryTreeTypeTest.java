package com.novicehacks.filechecker.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.mockito.Mockito;

public class DirectoryTreeTypeTest {

    private Logger logger = LogManager.getLogger (getClass ());

    @Test
    public void testEqualsWithNullReference() {
        logger.entry ("TestMethod: Test Directory Type equals passing null reference");
        DirectoryTreeType type1, type2;
        type1 = new DirectoryTreeType ();
        type2 = null;

        assertFalse ("Null object returns false for equals", type1.equals (type2));
    }

    @Test
    public void testEualsWithNoState() {
        logger.entry ("TestMethod: Test Directory Type equals with no state set");
        DirectoryTreeType type1, type2;
        type1 = new DirectoryTreeType ();
        type2 = new DirectoryTreeType ();

        assertTrue ("Two instances with no state set will be equal", type1.equals (type2));
    }

    @Test
    public void testEualsWithInheritedTypes() {
        logger.entry ("TestMethod: Test Directory Type equals with inherited types");
        DirectoryTreeType type1, type2;
        type1 = new DirectoryTreeType ();
        // mocking creates an object with type extended from base class.
        type2 = Mockito.spy (DirectoryTreeType.class);

        assertTrue ("Inherited types will be equal, based on the state", type1.equals (type2));
    }

    @Test
    public void testEqualsWithAttributesSet() {
        logger.entry ("TestMethod: Test directory with directory attributes set");
        DirectoryTreeType type1, type2;
        type1 = mockedTypeWithAttrubuteSet ();
        type2 = mockedTypeWithAttrubuteSet ();
        final boolean expectedStatus = false;

        boolean actualStatus = type1.equals (type2);
        assertEquals ("Two different data sets should not be equal", actualStatus, expectedStatus);
    }

    @Test
    public void testEqualsOnSameObjectWithAttributesSet() {
        logger.entry ("TestMethod: Test directory with directory attributes set");
        DirectoryTreeType type1, type2;
        type1 = mockedTypeWithAttrubuteSet ();
        type2 = type1;
        final boolean expectedStatus = true;

        boolean actualStatus = type1.equals (type2);
        // functionality not completed
        assertEquals ("Same object should be equal", actualStatus, expectedStatus);
    }

    /**
     * Creates a different tree object every time, its invoked.
     * 
     * @return
     */
    private DirectoryTreeType mockedTypeWithAttrubuteSet() {
        DirectoryTreeType type = new DirectoryTreeType ();
        Set<FileAttributeType> childNodes;
        Set<DirectoryTreeType> childDirectories;

        childNodes = new HashSet<FileAttributeType> ();
        childNodes.add (mock (FileAttributeType.class));
        childDirectories = new HashSet<DirectoryTreeType> ();
        childDirectories.add (mock (DirectoryTreeType.class));

        type.setCurrentNode (mock (FileAttributeType.class));
        type.setLeafNodes (childNodes);
        type.setSubDirectoryTreeNodes (childDirectories);

        return type;
    }

}
