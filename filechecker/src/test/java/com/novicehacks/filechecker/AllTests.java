package com.novicehacks.filechecker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.novicehacks.filechecker.parser.AllParserTests;

@RunWith (Suite.class)
@SuiteClasses ({ AllParserTests.class })
public class AllTests {
    private Logger logger = LogManager.getLogger (getClass ());

    @Before
    public void setUp() {
        logger.trace ("********* TestMethod Execution Start ******************");
    }

    @After
    public void teardown() {
        logger.trace ("********* TestMethod Execution Complete ******************");
    }
}
