import java.util.Scanner;

public class MineTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MineSweeperBoard myBoard = new MineSweeperBoard();

		// myBoard.CheckLocation(0, 0);
		// myBoard.CheckLocation(1, 1);
		// myBoard.CheckLocation(2, 2);
		// myBoard.CheckLocation(3, 3);
		// myBoard.CheckLocation(4, 4);
		Scanner sca = new Scanner(System.in);
		while (true) {
			int x = sca.nextInt();
			System.out.println();
			int y = sca.nextInt();
			myBoard.CheckLocation(x, y);

		}
	}

}
