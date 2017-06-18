package com.gerhards;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PaperTest {

    @Test
    public void CreatePaperWithNoStartingText(){
        Paper superPaper = new Paper();
        assertEquals("", superPaper.text());
    }

    @Test
    public void CreatePaperWithStartingText(){
        Paper superPaper = new Paper("Hello world");
        assertEquals("Hello world", superPaper.text());
    }

    @Test
    public void WriteText(){
        Paper superPaper = new Paper();
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.write("Hello world", superPencil);
        assertEquals("Hello world", superPaper.text());
    }
}
