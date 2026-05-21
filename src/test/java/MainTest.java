import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testValidateText_EmptyText() {
        String text = "";
        assertThrows(IllegalArgumentException.class, () -> {
            Main.validateText(text);
        });
    }

    @Test
    public void testCalculateText() {
        StringBuilder text = new StringBuilder("Абв123аА1($*@1АААаа");

        StringBuilder expectedNewText = new StringBuilder("Абв1231($*@1");
        StringBuilder actualNewText = Main.calculateText(text);
        assertEquals(expectedNewText.toString(), actualNewText.toString());
    }

    @Test
    public void testCalculateText_FirstCharacterIsNotLetter() {
        StringBuilder text = new StringBuilder("((Абв123аА1($*@1АААаа");

        StringBuilder expectedNewText = new StringBuilder("(Абв123аА1$*@1АААаа");
        StringBuilder actualNewText = Main.calculateText(text);
        assertEquals(expectedNewText.toString(), actualNewText.toString());
    }
}