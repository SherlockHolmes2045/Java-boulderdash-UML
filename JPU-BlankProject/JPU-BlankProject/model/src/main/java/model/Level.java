package model;

import entity.Entity;

public class Level extends Entity{

	private char[][] map;

	public Level(int indice) {
		DAOLevel niveau = new DAOLevel();
		this.map=niveau.fetchMap(indice);
	}

	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

}

