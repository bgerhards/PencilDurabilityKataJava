package com.gerhards;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class PencilTest {
    @Test
    public void CreatePencilWithSomeDurability() {
        Pencil superPencil = new Pencil(100, 100, 20, 200);
    }

    @Test
    public void WriteLetterWithDurability(){
        Pencil superPencil = new Pencil (100, 100, 20, 200);
        assertEquals(true, superPencil.write('a'));
    }

    @Test
    public void WriteLetterWithNoDurability(){
        Pencil superPencil = new Pencil(0, 100, 20, 200);
        assertEquals(false, superPencil.write('a'));
    }

    @Test
    public void WriteTwoLettersWithOneDurability(){
        Pencil superPencil = new Pencil (1, 100, 20, 200);
        assertEquals(true, superPencil.write('a'));
        assertEquals(false, superPencil.write('a'));
    }

    @Test
    public void WriteOneUpperCaseLetterWithDurability(){
        Pencil superPencil = new Pencil (100, 100, 20, 200);
        assertEquals(true, superPencil.write('A'));
    }

    @Test
    public void WriteOneUpperCaseLetterWithOneDurability(){
        Pencil superPencil = new Pencil (1, 100, 20, 200);
        assertEquals(false, superPencil.write('A'));
    }

    @Test
    public void WriteTwoOneUpperCaseLettersWithThreeDurability(){
        Pencil superPencil = new Pencil (3, 100, 20, 200);
        assertEquals(true, superPencil.write('A'));
        assertEquals(false, superPencil.write('A'));
    }

    @Test
    public void WriteOneSpaceWithDurability(){
        Pencil superPencil = new Pencil (3, 100, 20, 200);
        assertEquals(true, superPencil.write(' '));
    }

    @Test
    public void WriteNewLineWithDurability(){
        Pencil superPencil = new Pencil (3, 100, 20, 200);
        assertEquals(true, superPencil.write('\n'));
    }

    @Test
    public void WriteOneSpaceWithNoDurability(){
        Pencil superPencil = new Pencil (0, 100, 20, 200);
        assertEquals(true, superPencil.write(' '));
    }

    @Test
    public void WriteOneNewLineWithNoDurability(){
        Pencil superPencil = new Pencil (0, 100, 20, 200);
        assertEquals(true, superPencil.write('\n'));
    }

    @Test
    public void SharpenPencilLengthRemaining(){
        Pencil superPencil = new Pencil(100, 100, 20, 200);
        assertEquals(true, superPencil.sharpen());
    }

    @Test
    public void SharpenPencilNoLengthRemaining(){
        Pencil superPencil = new Pencil(100, 100, 0, 200);
        assertEquals(false, superPencil.sharpen());
    }

    @Test
    public void SharpenPencilMultipleTimesOneLengthRemaining(){
        Pencil superPencil = new Pencil(100, 100, 1, 200);
        assertEquals(true, superPencil.sharpen());
        assertEquals(false, superPencil.sharpen());
    }

    @Test
    public void WriteWithPencilAfterSharpenedNoDurability(){
        Pencil superPencil = new Pencil(0, 100, 10, 200);
        assertEquals(true, superPencil.sharpen());
        assertEquals(true, superPencil.write('a'));
    }

    @Test
    public void WriteWithPencilAfterSharpenNoDurabilityNoLength(){
        Pencil superPencil = new Pencil(0, 100, 0, 200);
        assertEquals(false, superPencil.sharpen());
        assertEquals(false, superPencil.write('a'));
    }

    @Test
    public void EraseWithDurability(){
        Pencil superPencil = new Pencil(100, 100, 100, 200);
        assertEquals(true, superPencil.erase('a'));

    }

    @Test
    public void EraseWithNoDurability(){
        Pencil superPencil = new Pencil(100, 100, 100, 0);
        assertEquals(false, superPencil.erase('A'));
    }

    @Test
    public void EraseSpaceWithNoDurability(){
        Pencil superPencil = new Pencil(100, 100, 100, 0);
        assertEquals(true, superPencil.erase(' '));
    }

    @Test
    public void EraseNewLineWithNoDurability(){
        Pencil superPencil = new Pencil(100, 100, 100, 0);
        assertEquals(true, superPencil.erase('\n'));
    }

}