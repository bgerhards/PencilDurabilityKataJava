package com.gerhards;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class PencilTest {
    @Test
    public void CreatePencilWithSomeDurability() {
        Pencil superPencil = new Pencil(100, 100, 20, 200);
        assertEquals(100, superPencil.getPointDurability());
    }

    @Test
    public void WriteLetterWithDurability(){
        Pencil superPencil = new Pencil (100, 100, 20, 200);
        assertEquals(true, superPencil.write());
        assertEquals(99, superPencil.getPointDurability());
    }

    @Test
    public void WriteTwoLettersWithDurability(){
        Pencil superPencil = new Pencil (100, 100, 20, 200);
        assertEquals(true, superPencil.write());
        assertEquals(99, superPencil.getPointDurability());
        assertEquals(true, superPencil.write());
        assertEquals(98, superPencil.getPointDurability());
    }

    @Test
    public void WriteLetterWithNoDurability(){
        Pencil superPencil = new Pencil(0, 100, 20, 200);
        assertEquals(false, superPencil.write());
        assertEquals(0, superPencil.getPointDurability());
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
        assertEquals(true, superPencil.write());

    }
}
