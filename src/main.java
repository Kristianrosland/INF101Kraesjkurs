
public class main {
	
	public static void main(String... orange){
		Palindrom p = new Palindrom();
		Board b = new Board(5, 5, new Dictionary());
		b.putWord(new Position(0, 0), Direction.HORIZONTAL, "SATOR");
		b.putWord(new Position(0, 1), Direction.HORIZONTAL, "AREPO");
		b.putWord(new Position(0, 2), Direction.HORIZONTAL, "TENET");
		b.putWord(new Position(0, 3), Direction.HORIZONTAL, "OPERA");
		b.putWord(new Position(0, 4), Direction.HORIZONTAL, "ROTAS");
		System.out.println(b.toString());
		System.out.println(p.isKvadPalindrom(b));
		
		
		
		
	}

}
