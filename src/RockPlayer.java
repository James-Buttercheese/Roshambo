
public class RockPlayer extends Player {

	public RockPlayer() {
		super();
	}
	
	public RockPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}

}
