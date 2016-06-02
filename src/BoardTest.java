import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	IDictionary dict;

	@Before
	public void setUp() throws Exception {
		dict = new IDictionary() {

			@Override
			public boolean isValidWord(String word) {
				List<String> validWords = Arrays.asList("mango", "banan",
						"papaya");
				return validWords.contains(word);
			}
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() throws Exception {
		Board b = new Board(10, 10, dict);

		b.putWord(new Position(2, 4), Direction.HORIZONTAL, "mango");

		assertEquals("mango",
				b.getWord(new Position(2, 4), Direction.HORIZONTAL));
	}

	@Test
	public void test2() {
		Board b = new Board(10, 10, dict);

		b.putWord(new Position(2, 4), Direction.HORIZONTAL, "mango");
		try {
			b.putWord(new Position(1, 4), Direction.HORIZONTAL, "p");
			fail("Should throw illegalwordexception");
		} catch (IllegalWordException e) {

		}

	}
	@Test
	public void test3() {
		Board b = new Board(10, 10, dict);

		b.putWord(new Position(2, 4), Direction.HORIZONTAL, "mango");
		b.putWord(new Position(3, 1), Direction.VERTICAL, "ban.n");
		
		assertEquals("mango",
				b.getWord(new Position(3, 4), Direction.HORIZONTAL));
		assertEquals("banan",
				b.getWord(new Position(3, 4), Direction.VERTICAL));

	}


	public void addGetProperty(IVector vec1, IVector vec2, int index) {
		double a = vec1.get(index);
		double b = vec2.get(index);
		
		assertEquals(a+b, vec1.add(vec2).get(index), 0.0001);
	}
}