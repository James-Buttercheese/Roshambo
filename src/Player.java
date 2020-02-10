
public abstract class Player {
	
	protected String name;
	
	public Player() {
		this.name = "Eric Cartman";
	}
	
	public Player(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract Roshambo generateRoshambo();
	
	public String toString() {
		
		return String.format("%s", name);
	}
	
	

}
