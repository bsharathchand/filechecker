package com.novicehacks.filechecker.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTreeTypeComparatorTest {

    private Logger logger = LogManager.getLogger (getClass ());
    DirectroyTreeTypeComparator comparator;

    @Before
    public void setup() {
        comparator = AllParserTests.context.getBean (DirectroyTreeTypeComparator.class);
    }

    @Test
    public void testNullComparatorInstances() {
        logger.entry ("TestMethod: Null Instances as arguments");
        DirectoryTreeType instance1 = null;
        DirectoryTreeType instance2 = null;

        comparator.compare (instance1, instance2);
    }
}
