import java.util.ArrayList;
import java.util.List;

public class Palindrom {
	
	public boolean isPalindrom(String s){
		if(s.isEmpty() || s.length() == 1){
			return true;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)){
			return isPalindrom(s.substring(1,s.length()-1));
		}
		
		return false;
	}
	
	public boolean isKvadPalindrom(IBoard board){
		StringBuilder horizontal = new StringBuilder();
		for(int i = 0; i< board.getHeight(); i++){
			horizontal.append(board.getWord(new Position(i, 0), Direction.VERTICAL));
		}
		StringBuilder vertical = new StringBuilder();
		for(int j = 0; j < board.getWidth(); j++){
			vertical.append(board.getWord(new Position(0, j), Direction.HORIZONTAL));
		}
		return isPalindrom(horizontal.toString()) && isPalindrom(vertical.toString());
	}

}
