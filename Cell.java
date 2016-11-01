
public class Cell {
	private int x;
	private int y;
	private int Value=0;
	private boolean revealed=false;
	//private boolean flagged=false;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) { 
			
		this.y = y;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		// Remember value can not be greater then 8 and smaller then -1
		Value = value;
	}
	public boolean isRevealed() {
		return revealed;
	}
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	
}
