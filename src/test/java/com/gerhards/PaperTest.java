package com.gerhards;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PaperTest {

    @Test
    public void CreatePaperWithNoStartingText() {
        Paper superPaper = new Paper();
        assertEquals("", superPaper.text());
    }

    @Test
    public void CreatePaperWithStartingText() {
        Paper superPaper = new Paper("Hello world");
        assertEquals("Hello world", superPaper.text());
    }

    @Test
    public void WriteText() {
        Paper superPaper = new Paper();
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.write("Hello world", superPencil);
        assertEquals("Hello world", superPaper.text());
    }

    @Test
    public void AppendText() {
        Paper superPaper = new Paper("Hello ");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        superPaper.write("world", superPencil);
        assertEquals("Hello world", superPaper.text());
    }

    @Test
    public void AppendTextNoDurability() {
        Paper superPaper = new Paper("Hello ");
        Pencil superPencil = new Pencil(0, 100, 100, 100);
        superPaper.write("world", superPencil);
        assertEquals("Hello      ", superPaper.text());
    }

    @Test
    public void AppendTextNotEnoughDurabilityLowerCase() {
        Paper superPaper = new Paper("Hello ");
        Pencil superPencil = new Pencil(3, 100, 100, 100);
        superPaper.write("world", superPencil);
        assertEquals("Hello wor  ", superPaper.text());
    }

    @Test
    public void AppendTextNotEnoughDurabilityUpperCase() {
        Paper superPaper = new Paper("Hello ");
        Pencil superPencil = new Pencil(3, 100, 100, 100);
        superPaper.write("World", superPencil);
        assertEquals("Hello Wo   ", superPaper.text());
    }

    @Test
    public void AppendTextNotEnoughDurabilitySpacesAndNewLine() {
        Paper superPaper = new Paper("Hello");
        Pencil superPencil = new Pencil(5, 100, 100, 100);
        superPaper.write(" u s\n        abcde", superPencil);
        assertEquals("Hello u s\n        abc  ", superPaper.text());
    }

    @Test
    public void EraseTextOneWord() {
        Paper superPaper = new Paper("Hello");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        assertEquals(0, superPaper.erase("Hello", superPencil));
        assertEquals("     ", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWords() {
        Paper superPaper = new Paper("Hello world");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        assertEquals(6, superPaper.erase("world", superPencil));
        assertEquals("Hello      ", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsNotEnoughDurability() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 2);
        assertEquals(27, superPaper.erase("beautiful", superPencil));
        assertEquals("Hello world, holder of the beautif   people", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsErasingMultipleWords() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        assertEquals(23, superPaper.erase("the beautiful", superPencil));
        assertEquals("Hello world, holder of               people", superPaper.text());
    }

    @Test
    public void EraseTextMultipleWordsErasingMultipleWordsNotEnoughDurability() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 11);
        assertEquals(23, superPaper.erase("the beautiful", superPencil));
        assertEquals("Hello world, holder of t             people", superPaper.text());
    }

    @Test
    public void EditWordSameSize() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        int positionOfErasedText = superPaper.erase("holder", superPencil);
        assertEquals(13, positionOfErasedText);
        superPaper.edit("keeper", positionOfErasedText, superPencil);
        assertEquals("Hello world, keeper of the beautiful people", superPaper.text());
    }

    @Test
    public void EditWordSmaller() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        int positionOfErasedText = superPaper.erase("holder", superPencil);
        assertEquals(13, positionOfErasedText);
        superPaper.edit("keep", positionOfErasedText, superPencil);
        assertEquals("Hello world, keep   of the beautiful people", superPaper.text());
    }

    @Test
    public void EditWordNotEnoughDurability() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(4, 100, 100, 100);
        int positionOfErasedText = superPaper.erase("holder", superPencil);
        assertEquals(13, positionOfErasedText);
        superPaper.edit("keeper", positionOfErasedText, superPencil);
        assertEquals("Hello world, keep   of the beautiful people", superPaper.text());
    }

    @Test
    public void EditWordLargerOverlappingLettersDifferent() {
        Paper superPaper = new Paper("Hello world, holder of the beautiful people");
        Pencil superPencil = new Pencil(100, 100, 100, 100);
        int positionOfErasedText = superPaper.erase("holder", superPencil);
        assertEquals(13, positionOfErasedText);
        superPaper.edit("keepings", positionOfErasedText, superPencil);
        assertEquals("Hello world, keeping@f the beautiful people", superPaper.text());
    }


}
