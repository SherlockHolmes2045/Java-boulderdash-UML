package model;

import entity.Entity;

/**
 * 
 * @author Lemovou Ivan
 *		this class manages the map's levels
 */


public class Level extends Entity{

	/** The array to contain the map of the database*/
	private char[][] map;

	/**
	 * 
	 * @param indice
	 *The number of the level to fetch in the database
	 */
	
	public Level(int indice) {
		DAOLevel niveau = new DAOLevel();
		this.map=niveau.fetchMap(indice);
	}
/**
 * 
 * @return
 * return the map of the level
 */
	public char[][] getMap() {
		return map;
	}
	/**
	 * 
	 * @param map
	 *		to set a map for level
	 */
	
	public void setMap(char[][] map) {
		this.map = map;
	}

}

