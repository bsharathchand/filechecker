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
        final String fileSize1 = "100";
        final String fileSize2 = "500";
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type1.setFileSize (fileSize1);

        type2 = new FileAttributeType ();
        type2.setFileSize (fileSize2);
        assertFalse ("Files with different sizes cannot be equal",type1.equals (type2));
    }

    @Test
    public void equalsWithDifferentFileName() {
        final String fileName1 = "abc.txt";
        final String fileName2 = "ab.txt";
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type1.setFilename (fileName1);

        type2 = new FileAttributeType ();
        type2.setFilename (fileName2);
        assertFalse ("Files with different names cannot be equal",type1.equals (type2));
    }

    @Test
    public void equalsWithDifferentModifiedDate() {
        final String fileModifiedDt1 = "10/09/2015";
        final String fileModifiedDt2 = "11/09/2015";
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type1.setModifiedDate (fileModifiedDt1);

        type2 = new FileAttributeType ();
        type2.setModifiedDate (fileModifiedDt2);
        assertFalse ("Files with different modified dates cannot be equal",type1.equals (type2));
    }

    @Test
    public void equalsWithDifferentLinkStatus() {
        final boolean fileIsLink1 = true;
        final boolean fileIsLink2 = false;
        FileAttributeType type1, type2;
        type1 = new FileAttributeType ();
        type1.setIsSymbolicLink (fileIsLink1); 

        type2 = new FileAttributeType ();
        type2.setIsSymbolicLink (fileIsLink2);
        assertFalse ("A Link will not be equal to a file",type1.equals (type2));
    }
}
