package Eksamen;

public class Palindrome {
	
	public boolean isPalindrome(String s){
		if(s.isEmpty() || s.length() == 1){
			return true;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)){
			return isPalindrome(s.substring(1,s.length()-1));
		} else {
			return false;
		}
	}
	
	public boolean isQuadraticPalindrome(IBoard board){
		if (board.getHeight() != board.getWidth()) {
			return false; //Brettet er ikke kvadratisk
		}

		String alleHorisontaleOrd = "", alleVertikaleOrd = "";

		for(int i = 0; i< board.getHeight(); i++){
			alleHorisontaleOrd += board.getWord(new Position(i, 0), Direction.VERTICAL);
			alleVertikaleOrd += board.getWord(new Position(0, i), Direction.HORIZONTAL);
		}

		return isPalindrome(alleHorisontaleOrd) && isPalindrome(alleVertikaleOrd);
	}

}
