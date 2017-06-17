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
    public void WriteLetterWithNoDurability(){
        Pencil superPencil = new Pencil(0, 100, 20, 200);
        assertEquals(false, superPencil.write());
        assertEquals(0, superPencil.getPointDurability());
    }
}
