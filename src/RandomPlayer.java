
public class RandomPlayer extends Player{

	public RandomPlayer() {
		super();
	}
	public RandomPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		
		int num = (((int) (Math.random() *10)) %3);
		
		if (num == 0) {
			return Roshambo.ROCK;
		} else if (num == 1) {
			return Roshambo.PAPER;
		} else if (num == 2) {
			return Roshambo.SCISSORS;
		}
		
		return null;
	}

}
