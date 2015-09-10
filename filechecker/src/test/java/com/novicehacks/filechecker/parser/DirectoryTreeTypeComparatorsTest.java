package com.novicehacks.filechecker.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DirectoryTreeTypeComparatorsTest {

    private Logger logger = LogManager.getLogger (getClass ());
    DirectoryTreeTypeComparator nameComparator;
    DirectoryTreeTypeComparator sizeComparator;
    DirectoryTreeTypeComparator dateComparator;

    @Rule
    public ExpectedException exception = ExpectedException.none ();

    @Before
    public void setup() {
        nameComparator = AllParserTests.context.getBean (DirectoryTreeNameComparator.class);
        sizeComparator = AllParserTests.context.getBean (DirectoryTreeSizeComparator.class);
        dateComparator = AllParserTests.context.getBean (DirectoryTreeDateComparator.class);
    }

    @Test
    public void testNullInstanceOnNameComparator() {
        logger.entry ("TestMethod: Null Instances as arguments for Name comparator");
        DirectoryTreeType instance1, instance2;
        instance1 = instance2 = null;
        final int expectedStatus = 0;

        int actualStatus = nameComparator.compare (instance1, instance2);
        assertEquals ("Comparision of two null instances should be equal", actualStatus,
                expectedStatus);
        logger.exit ();
    }

    @Test
    public void testNullInstanceOnSizeCompartor() {
        logger.entry ("TestMethod: Null instances as arguments for Size comparator");
        DirectoryTreeType instance1, instance2;
        instance1 = instance2 = null;
        final int expectedStatus = 0;

        int actualStatus = sizeComparator.compare (instance1, instance2);
        assertEquals ("Comparision of two null instances should be equal", actualStatus,
                expectedStatus);
        logger.exit ();
    }

    @Test
    public void compareDirectoriesWithNames() {
        logger.entry ("TestMethod: Comparing with names of the directory nodes");

        final int expectedStatus = -1;
        DirectoryTreeType instance1, instance2;
        FileAttributeType attrib1, attrib2;

        instance1 = mock (DirectoryTreeType.class);
        instance2 = mock (DirectoryTreeType.class);
        attrib1 = mock (FileAttributeType.class);
        attrib2 = mock (FileAttributeType.class);
        when (attrib1.getFilename ()).thenReturn ("abc.txt");
        when (attrib2.getFilename ()).thenReturn ("def.txt");
        when (instance1.getCurrentNode ()).thenReturn (attrib1);
        when (instance2.getCurrentNode ()).thenReturn (attrib2);

        int actualStatus = nameComparator.compare (instance1, instance2);

        assertTrue ("Sorting should be in alphabetical order: " + actualStatus,
                actualStatus <= expectedStatus);
        logger.exit ();
    }

    @Test
    public void compareDirectoriesWithSameNames() {
        logger.entry ("TestMethod: Comparing with same names of the directory nodes");

        final int expectedStatus = 0;
        DirectoryTreeType instance1, instance2;
        FileAttributeType attrib1;

        instance1 = mock (DirectoryTreeType.class);
        instance2 = mock (DirectoryTreeType.class);
        attrib1 = mock (FileAttributeType.class);
        when (attrib1.getFilename ()).thenReturn ("abc.txt");
        when (instance1.getCurrentNode ()).thenReturn (attrib1);
        when (instance2.getCurrentNode ()).thenReturn (attrib1);

        int actualStatus = nameComparator.compare (instance1, instance2);

        assertTrue ("Sorting should be in alphabetical order: " + actualStatus,
                actualStatus == expectedStatus);
        logger.exit ();
    }

    @Test
    public void compareDirectoriesWithSizes() {
        logger.entry ("TestMethod: Comparing with sizes of the directory nodes");

        final int expectedStatus = -1;
        DirectoryTreeType instance1, instance2;
        FileAttributeType attrib1, attrib2;

        instance1 = mock (DirectoryTreeType.class);
        instance2 = mock (DirectoryTreeType.class);
        attrib1 = mock (FileAttributeType.class);
        attrib2 = mock (FileAttributeType.class);
        when (attrib1.getFileSize ()).thenReturn ("100");
        when (attrib2.getFileSize ()).thenReturn ("200");
        when (instance1.getCurrentNode ()).thenReturn (attrib1);
        when (instance2.getCurrentNode ()).thenReturn (attrib2);

        int actualStatus = sizeComparator.compare (instance1, instance2);

        assertTrue ("Sorting should be in numerical order: " + actualStatus,
                actualStatus <= expectedStatus);
        logger.exit ();
    }

    @Test
    public void compareDirectoriesWithSameSizes() {
        logger.entry ("TestMethod: Comparing with same sizes of the directory nodes");

        final int expectedStatus = 0;
        DirectoryTreeType instance1, instance2;
        FileAttributeType attrib1, attrib2;

        instance1 = mock (DirectoryTreeType.class);
        instance2 = mock (DirectoryTreeType.class);
        attrib1 = mock (FileAttributeType.class);
        attrib2 = mock (FileAttributeType.class);
        when (attrib1.getFileSize ()).thenReturn ("100");
        when (attrib2.getFileSize ()).thenReturn ("100");
        when (instance1.getCurrentNode ()).thenReturn (attrib1);
        when (instance2.getCurrentNode ()).thenReturn (attrib2);

        int actualStatus = sizeComparator.compare (instance1, instance2);

        assertTrue ("Sorting should be in numerical order: " + actualStatus,
                actualStatus == expectedStatus);
        logger.exit ();
    }

    @Test
    public void compareDirectoriesWithDates() {
        logger.entry ("TestMethod: Comparing with dates of the directory nodes");
        DirectoryTreeType instance = null;
        exception.expect (UnsupportedOperationException.class);
        dateComparator.compare (instance, instance);

        fail ("Feature not implemented");
        logger.exit ();
    }
}
