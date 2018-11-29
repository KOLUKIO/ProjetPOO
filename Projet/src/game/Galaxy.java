package game;

public class Galaxy {
	
	int nbPlanet;
	int nbPlayers;
	int nbShips;
	
	Galaxy(int nbPlanet,int nbPlayers,int nbShips){
		this.nbPlanet = nbPlanet;
		this.nbShips = nbShips;
		this.nbPlayers = nbPlayers;
	}
	
	
	
	public int getNbPlanete() {
		return nbPlanet;
	}
	public void setNbPlanete(int nbPlanete) {
		this.nbPlanet = nbPlanete;
	}
	public int getNbPlayers() {
		return nbPlayers;
	}
	public void setNbPlayers(int nbPlayers) {
		this.nbPlayers = nbPlayers;
	}
	public int getNbShips() {
		return nbShips;
	}
	public void setNbShips(int nbShips) {
		this.nbShips = nbShips;
	}
	
}
