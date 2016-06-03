package Eksamen;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Set;

public class Board implements IBoard {

	/** OPPGAVE 2A. */
	private IArray2D<Character> data;
	private IDictionary dict;

	public Board(int height, int width, IDictionary dict) {
		data = new Array2D<Character>(height, width);
		this.dict = dict;
	}


	/** OPPGAVE 2B.
	 *
	 *		Datainvariant for et gyldig brett:
	 *			- Høyde og bredde er større enn 1
	 *			- data != null og dict != null
	 *			- Alle ord som er plassert på brettet er gyldige ord i følge dict
	 *
	 * 		(Her trenger man ikke skrive kode i det hele tatt, ettersom oppgaven sier ".. med ord eller pseudokode")
	 **/
	public void checkstate() {
		if (data == null || dict == null || getWidth() <= 1 || getHeight() <= 1) {
			throw new IllegalArgumentException("Board eller dict er feil");
		}

		//Sjekker at alle ord på brettet er gyldig.
		for (int i = 0; i < data.getHeight(); i++) {
			for (int j = 0; j < data.getWidth(); j++) {
				if (!dict.isValidWord(getWord(new Position(i, j), Direction.HORIZONTAL))) {
					throw new IllegalStateException("Ugyldig ord på brettet");
				}
				if (!dict.isValidWord(getWord(new Position(i, j), Direction.VERTICAL))) {
					throw new IllegalStateException("Ugyldig ord på brettet");
				}
			}
		}
	}

	/**
	 * 	Hjelpemetoder i OPPGAVE 2C
     */
	private Position findStart(Position pos, Direction dir) {
		Position start = pos;
		Character character = data.getPosition(pos);

		if (character == null) {
			return null;
		}

		pos = pos.stepBackwards(dir);
		while (data.isValid(pos) && data.getPosition(pos) != null) {
			start = pos;
			pos = pos.stepBackwards(dir);
		}
		return start;
	}

	private int findLength(Position pos, Direction dir) {
		int length = 0;

		while (data.isValid(pos) && data.getPosition(pos) != null) {
			length++;
			pos = pos.stepForward(dir);
		}
		return length;
	}

	private String getLetters(Position pos, Direction dir, int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append(data.getPosition(pos));
			pos = pos.stepForward(dir);
		}
		return builder.toString();
	}

	/** OPPGAVE 2C **/
	@Override
	public String getWord(Position pos, Direction dir) {
		Position start = findStart(pos, dir);
		if (pos != null) {
			int length = findLength(start, dir);
			if (length >= 2) {
				String word = getLetters(start, dir, length);
				return word;
			}
		}
		return null;
	}

	/** OPPGAVE 2F **/
	@Override
	public void putWord(Position pos, Direction dir, String letters) {
		IArray2D<Character> backup = data.copy();
		try {
			putLetters(pos, dir, letters);
			Position start = findStart(pos, dir);
			int length = findLength(pos, dir);
			Set<String> allWords = getXWords(start, dir, length);
			allWords.add(getWord(pos, dir));

			for (String s : allWords) {
				if (!dict.isValidWord(s)) {
					throw new IllegalWordException();
				}
			}
		} catch (IllegalWordException e) {
			data = backup;
			throw e;
		} catch(InvalidPlacementException e) {
			data = backup;
			throw e;
		}
	}

	/** OPPGAVE 2D **/
	private void putLetters(Position pos, Direction dir, String letters) throws InvalidPlacementException {
		Position nextPos = pos;
		for (int i = 0; i < letters.length(); i++) {
			if (!data.isValid(nextPos)) {
				throw new InvalidPlacementException();
			}
			if (letters.charAt(i) == '.') {
				if (data.getPosition(nextPos) == null) {
					throw new InvalidPlacementException();
				}
			} else {
				if (data.getPosition(nextPos) != null) {
					throw new InvalidPlacementException();
				} else {
					data.setPosition(nextPos, letters.charAt(i));
				}
			}
			nextPos = nextPos.stepForward(dir);
		}
	}


	/** OPPGAVE 2E **/
	private Set<String> getXWords(Position start, Direction dir, int length) {
		Set<String> result = new HashSet<String>();
		Direction xDir = dir.rotate();
		Position pos = start;
		for (int i = 0; i < length; i++) {
			String word = getWord(pos, xDir);
			if (word != null) {
				result.add(word);
			}
			pos = pos.stepForward(dir);
		}
		return result;
	}

	/** OPPGAVE 2G
	 * 		putWord() opprettholder datainvarianten, fordi den ikke gjør endringer på brettet som kan føre til at
	 * 		datainvarianten brytes: den sjekker ordet den puttet inn, og alle andre tegnsekvenser ordet kommer
	 * 		i kontakt med.
     */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i < getHeight(); i++){
			for(int j = 0; j < getWidth(); j++){
				builder.append(data.getPosition(new Position(i, j)) + "");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public int getHeight() {
		return data.getHeight();
	}

	@Override
	public int getWidth() {
		return data.getWidth();
	}

}
