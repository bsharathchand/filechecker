package com.novicehacks.filechecker.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith (Suite.class)
@SuiteClasses ({ DirectoryParserTest.class, DirectoryTreeTypeComparatorsTest.class,
        DirectoryTreeTypeTest.class, FileAttributeTypeTest.class })
public class AllParserTests {

    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (
            "com.novicehacks.filechecker.parser");

}
