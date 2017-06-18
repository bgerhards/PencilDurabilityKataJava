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

    @Test
    public void AppendText(){
        Paper superPaper = new Paper("Hello ");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.write("world", superPencil);
        assertEquals("Hello world", superPaper.text());
    }

    @Test
    public void EraseTextOneWord(){
        Paper superPaper = new Paper("Hello");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.erase("Hello", superPencil);
        assertEquals("     ", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWords(){
        Paper superPaper = new Paper("Hello world");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.erase("world", superPencil);
        assertEquals("Hello      ", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsNotEnoughDurability(){
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 2);
        superPaper.erase("beautiful", superPencil);
        assertEquals("Hello world, holder of the beautif   people", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsErasingMultipleWords(){
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.erase("the beautiful", superPencil);
        assertEquals("Hello world, holder of               people", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsErasingMultipleWordsNotEnoughDurability(){
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 11);
        superPaper.erase("the beautiful", superPencil);
        assertEquals("Hello world, holder of t             people", superPaper.text());
    }
}
