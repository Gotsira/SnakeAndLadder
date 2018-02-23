import java.util.Random;

public class Die {
	public static final int MAX_FACE = 6;
	
	private int face;
	
	public Die() {
		face = 1;
	}
	
	public void roll() {
		Random rand = new Random();
		face = (int) rand.nextInt(MAX_FACE) + 1;
	}
	
	public int getFace() {
		return this.face;
	}
}
