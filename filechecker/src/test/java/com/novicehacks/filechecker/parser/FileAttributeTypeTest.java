package com.novicehacks.filechecker.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileAttributeTypeTest {

    @Test
    public void equalsWithNullReference() {
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type2 = null;

        assertFalse ("Object will Null reference comparision should fail", type1.equals (type2));
    }

    @Test
    public void equalsWithDifferentObjectInstance() {
        FileAttributeType type1;
        DirectoryTreeType type2;
        type1 = new FileAttributeType ();
        type2 = new DirectoryTreeType ();

        assertFalse ("Objects of different types should not be equal", type1.equals (type2));
    }

    @Test
    public void equalsWithNoState() {
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type2 = new FileAttributeType ();

        assertTrue ("Objects with no state, should be equal", type1.equals (type2));
    }

    @Test
    public void equalsWithDifferentFileSize() {
        fail ("not implemented");
    }

    @Test
    public void equalsWithDifferentFileName() {
        fail ("not implemented");
    }

    @Test
    public void equalsWithDifferentModifiedDate() {
        fail ("not implemented");
    }

    @Test
    public void equalsWithDifferentLinkStatus() {
        fail ("not implemented");
    }
}
