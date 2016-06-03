package Eksamen;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {
	
	@Test
	public void testThatABoardWithQuadraticPalindromeReturnsTrue() {
		Palindrome p = new Palindrome();
		Board b = new Board(5, 5, new Dictionary());
		b.putWord(new Position(0, 0), Direction.HORIZONTAL, "SATOR");
		b.putWord(new Position(0, 1), Direction.HORIZONTAL, "AREPO");
		b.putWord(new Position(0, 2), Direction.HORIZONTAL, "TENET");
		b.putWord(new Position(0, 3), Direction.HORIZONTAL, "OPERA");
		b.putWord(new Position(0, 4), Direction.HORIZONTAL, "ROTAS");

		assertTrue(p.isQuadraticPalindrome(b));
	}

	@Test
	public void testThatABoardWithNoQuadraticPalindromeReturnsFalse() {
		Palindrome p = new Palindrome();
		Board b = new Board(5, 5, new Dictionary());
		b.putWord(new Position(0, 0), Direction.HORIZONTAL, "ABCDE");
		b.putWord(new Position(0, 1), Direction.HORIZONTAL, "DFGHJ");
		b.putWord(new Position(0, 2), Direction.HORIZONTAL, "HJKDW");
		b.putWord(new Position(0, 3), Direction.HORIZONTAL, "GHJKL");
		b.putWord(new Position(0, 4), Direction.HORIZONTAL, "CVBNM");

		assertFalse(p.isQuadraticPalindrome(b));
	}

}
