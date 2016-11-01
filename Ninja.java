import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Ninja {

	
	private int HitPoint = 50;
	private double pod = 0.9;
	private double poa = 0.9;
	private Queue<Weapon> wBackPak = new LinkedList<Weapon>();
	private BeltColor bc = BeltColor.white;
	private Weapon WatHand;

	public boolean isAlive(){
		if(HitPoint>0)
			return true;
		else 
			return false;
		
	}
	
	public Ninja(){
		
	}
	public Ninja(int Hp, double pod, double poa, BeltColor Bc) {
		this.bc = Bc;
		this.HitPoint = Hp;
		this.pod = pod;
		this.poa = poa;

	}

	public void AddWeapon(Weapon w) {
		wBackPak.offer(w);
	}

	public Weapon changeWeapon() {
		if (WatHand != null)
			wBackPak.offer(WatHand);
		WatHand = wBackPak.poll();
		return WatHand;

	}

	public void Defend(Ninja enemy) {

		Random rnd = new Random();

		double overallProbability = pod * (double) Util.BetColorConverter(bc) / 9.0;
		if (overallProbability > rnd.nextDouble()) {
			System.out.println("HA HA I defended");
			
		}
		else 
		{
			System.out.println("Agh!! Auch.. It hurts");
			
			this.HitPoint-=enemy.WatHand.getHitPoint();
			if(!isAlive())
				System.out.println("I'm dying");
		}
		
		
	}

	public void Attack(Ninja enemy) {

		Random rnd = new Random();

		double overallProbability = poa * (double) Util.BetColorConverter(bc) / 9.0;

		if (overallProbability > rnd.nextDouble()) {
			System.out.println("Eat This");
			changeWeapon();
			WatHand.Attack();
			
			enemy.Defend(this);

		}
		else 
			System.out.println("Next Time !!");

	}

}
