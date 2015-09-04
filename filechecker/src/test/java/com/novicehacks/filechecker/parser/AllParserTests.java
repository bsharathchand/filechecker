package com.novicehacks.filechecker.parser;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith (Suite.class)
@SuiteClasses ({ DirectoryParserTest.class })
public class AllParserTests {

    public static AnnotationConfigApplicationContext context;

    @BeforeClass
    public static void setup() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (
                "com.novicehacks.filechecker.parser");
    }
}
