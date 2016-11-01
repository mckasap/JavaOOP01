import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class MineSweeperBoard {
	public  int NUMBER_OF_COLUMNS = 10;
	public  int NUMBER_OF_ROWS = 10;
	public  int NUMBER_OF_MINES = 30;

	private Cell[][] field;
	
	
    public MineSweeperBoard(int Columns, int Rows, int Mines){
    		
    		NUMBER_OF_COLUMNS= Columns;
    		NUMBER_OF_ROWS=Rows;
    		NUMBER_OF_MINES=Mines;
    	     Replay();
    }
	public MineSweeperBoard() {
		field = new Cell[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];
		Replay();

	}

	public void Replay() {

		IniateField(); // Initiate the matrix so that each field is full
		RandomlyPlaceMines();// Randomly select a location and change value to
		DisplayTheField(); // -1
		CalculateNeigbours();// Calculate the number of mines for 1 adjacent
								// neighbor for each field
		DisplayTheField();
	}

	private void ClearConsole() {
		final String operatingSystem = System.getProperty("os.name");

		if (operatingSystem.contains("Windows")) {
			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void IniateField() {

		for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			for (int j = 0; j < NUMBER_OF_ROWS; j++) {
				Cell c = new Cell();
				c.setX(i);
				c.setY(j);
				field[i][j] = c;
			}

	}

	private void RandomlyPlaceMines() {

		Random num = new Random();

		for (int i = 0; i < NUMBER_OF_MINES; i++) {
			int x = num.nextInt(NUMBER_OF_COLUMNS);
			int y = num.nextInt(NUMBER_OF_ROWS);

			if (field[x][y].getValue() != -1) {
				field[x][y].setValue(-1);
			} else {

				i--;

			}

		}
	}

	private boolean Check(int x, int y, Deque<Cell> theStack) {
		// border condition
		if (x < 0 || y < 0 || y > NUMBER_OF_COLUMNS - 1 || x > NUMBER_OF_ROWS - 1)
			return false;
		// Already in the stack??
		if (theStack.contains(field[x][y]))
			return false;
		if (field[x][y].isRevealed())
			return false;

		return true;
	}

	private void CalculateNeigbours() {

		for (int i = 0; i < NUMBER_OF_COLUMNS; i++)
			for (int j = 0; j < NUMBER_OF_ROWS; j++) {
				if (field[i][j].getValue() != -1) {
					int theValue = 0;
					for (int t = -1; t <= 1; t++)
						for (int z = -1; z <= 1; z++) {
							if (i + t < 0 || i + t > NUMBER_OF_COLUMNS - 1 || j + z < 0 || j + z > NUMBER_OF_ROWS - 1
									|| (z == 0 && t == 0))
								continue;
							if (field[i + t][j + z].getValue() == -1)
								theValue++;
						}
					field[i][j].setValue(theValue);
				}
			}

	}

	public void DisplayTheField() {
		ClearConsole();
		System.out.println();
		System.out.println("    0   1   2   3   4   5   6   7   8   9");
		for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
			System.out.print(i + "   ");
			for (int j = 0; j < NUMBER_OF_ROWS; j++) {
				if (field[i][j].isRevealed())
					if (field[i][j].getValue() != -1)
						System.out.print(field[i][j].getValue() + "   ");
					else
						System.out.print("M   ");
				else
					System.out.print("?   ");

			}
			System.out.println();
		}

	}

	public Cell CheckLocation(int x, int y) {
		Deque<Cell> theStack = new LinkedList<Cell>();

		theStack.push(field[x][y]);

		while (!theStack.isEmpty()) {

			Cell c = theStack.pop();

			RevealLocation(c);
			if (c.getValue() == -1) {
				System.out.println("Auch!! YOU STEP ON THE MINE!! GAME OVER");
			    System.exit(0);
				break;
			}
			if (c.getValue() == 0) {
				if (Check(c.getX() - 1, c.getY(), theStack))
					theStack.push(field[c.getX() - 1][c.getY()]);
				if (Check(c.getX(), c.getY() + 1, theStack))
					theStack.push(field[c.getX()][c.getY() + 1]);
				if (Check(c.getX() + 1, c.getY(), theStack))
					theStack.push(field[c.getX() + 1][c.getY()]);
				if (Check(c.getX(), c.getY() - 1, theStack))
					theStack.push(field[c.getX()][c.getY() - 1]);
			}

		}
		DisplayTheField();
		return field[x][y];
	}

	private void RevealLocation(Cell x) {
		x.setRevealed(true);
	}

}
