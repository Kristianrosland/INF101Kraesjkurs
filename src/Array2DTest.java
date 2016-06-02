import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test for Array2D-klassen
 */
public class Array2DTest {

    @Test
    public void testGetWidth() {
        Array2D array = new Array2D<String>(10, 20);

        assertEquals(10, array.getHeight());
        assertEquals(20, array.getWidth());
    }

    @Test
    public void testThatAnElementIsAddedToTheGivenPosition() {
        Array2D array = new Array2D<String>(20, 20);
        Position pos1 = new Position(10, 10), pos2 = new Position(12, 12);


        array.setPosition(pos1, "Kristian");
        array.setPosition(pos2, "Markus");

        assertEquals("Kristian", array.getPosition(pos1));
        assertEquals("Markus", array.getPosition(pos2));
    }

    @Test
    public void testThatOverridingAnExistingElementWorks() {
        Array2D array = new Array2D<String>(20, 20);
        Position pos1 = new Position(10, 10);

        array.setPosition(pos1, "Kristian");
        array.setPosition(pos1, "Markus");

        assertEquals("Markus", array.getPosition(pos1));
    }

    @Test
    public void testThatGettingAnEmptyPositionReturnsNull() {
        Array2D array = new Array2D<String>(20, 20);
        Position pos = new Position(10, 10), otherPos = new Position(5, 5);

        array.setPosition(pos, "Kristian");

        assertEquals(null, array.getPosition(otherPos));
    }

}
