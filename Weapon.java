
public abstract class Weapon {
	private int HitPoint;

	private String Description;

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Weapon(int Hp, String Desc) {
		this.HitPoint = Hp;
		this.Description = Desc;
	}

	public int getHitPoint() {
		return HitPoint;
	}

	public  void Attack(){
		 System.out.println("Attacked with"+getDescription() );
	}
	
}
