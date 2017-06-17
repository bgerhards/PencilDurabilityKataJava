import com.gerhards.Pencil;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class PencilTest {
    @Test
    public void CreatePencilWithSomeDurability() {
        Pencil superPencil = new Pencil(100, 100, 20, 200);
        assertEquals(100, superPencil.getDurability());
    }

}
