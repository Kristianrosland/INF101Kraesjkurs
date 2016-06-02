package Eksamen;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Set;

public class Board implements IBoard {

	private IArray2D<Character> data;
	private IDictionary dict;

	public Board(int height, int width, IDictionary dict) {
		data = new Array2D<>(height, width);
		this.dict = dict;
	}

	public void checkstate() {
		if (data == null || dict == null) {
			throw new IllegalArgumentException("Board eller dict er feil");
		}
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

	@Override
	public int getWidth() {
		return data.getWidth();
	}

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

	@Override
	public int getHeight() {
		return data.getHeight();
	}

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
		} catch (IllegalWordException | InvalidPlacementException e) {
			data = backup;
			throw e;
		}
	}

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
	
	

}
