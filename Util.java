
public class Util {

	public static int BetColorConverter(BeltColor bc) {

		if (bc == BeltColor.white)
			return 1;
		else if (bc == BeltColor.yellow)
			return 2;
		else if (bc == BeltColor.orange)
			return 3;
		else if (bc == BeltColor.red)
			return 4;
		else if (bc == BeltColor.blue)
			return 6;
		else if (bc == BeltColor.purple)
			return 7;
		else if (bc == BeltColor.green)
			return 5;
		else if (bc == BeltColor.brown)
			return 8;
		else
			return 9;

	}
}
