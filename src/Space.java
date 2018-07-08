
public class Space {
	private String multiplier;
	private char letter;
	
	public Space(String multiplier) {
		this.multiplier = multiplier;
		this.letter = ' ';
	}
	
	public String getMultiplier() {
		return multiplier;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	@Override
	public String toString() {
		return multiplier;
	}
}
