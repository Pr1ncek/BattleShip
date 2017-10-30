
public class PlayerData {

	int numberOfShips = 5;
	int enemyShips = 0;
	
	int numberOfHits = 0;
	
	int numberOfMisses = 0;
	
	//int counter = 0;
	

	public int getNumberOfMisses() {
		return numberOfMisses;
	}

	public void setNumberOfMisses(int numberOfMisses) {
		this.numberOfMisses = numberOfMisses;
	}

	public int getNumberOfShips() {
		return numberOfShips;
	}

	public int getNumberOfHits() {
		return numberOfHits;
	}

	public void setNumberOfHits(int numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	public void setNumberOfShips(int numberOfShips) {
		this.numberOfShips = numberOfShips;
	}

	public int getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(int enemyShips) {
		this.enemyShips = enemyShips;
	}
	
	

	SelfGrid sGrid;

	AttackGrid aGrid;

	public PlayerData(SelfGrid sGrid, AttackGrid aGrid) {

		this.sGrid = sGrid;

		this.aGrid = aGrid;

	}
	
	
	
	
	

}
