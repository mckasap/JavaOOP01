
public class NinjaArena {

	public static void main(String[] args){
		Ninja n1= new Ninja();
		Ninja n2= new Ninja(55, 0.95, 0.95, BeltColor.black);
		Weapon w1 = new Sword("RED sword");
		Weapon w2 = new Sword("Yellow sword");
		
		Weapon w3 = new NonChuck("Iron NonChuck");
		Weapon w4 = new NonChuck("Wooden NonChuck");
		Weapon w5 = new Shruiken("Wooden Shruiken");
		
		
		
		n1.AddWeapon(w1);
        n1.AddWeapon(w2);
		
        n2.AddWeapon(w4);
		n2.AddWeapon(w3);
		n2.AddWeapon(w5);		
		
		int Turn=0;
		while(n1.isAlive() && n2.isAlive()){
			System.out.println(">>>>> TURN "+ ++Turn +"<<<<<<<");
			n1.Attack(n2);
			n2.Attack(n1);
			System.out.println(">>>>> TURN "+  Turn +"<<<<<<<");
			
			
		}
		
		
	}
	
}
