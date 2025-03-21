package model;

import entity.Entity;

/**
 * @author Lemovou Ivan
 * this class manages the map's levels
 */


public class Level extends Entity {

    /**
     * The array to contain the map of the database
     */
    private char[][] map;

    private int levelNumber;

    /**
     * @param levelNumber The number of the level to fetch in the database
     */

    public Level(int levelNumber) {
        DAOLevel dao = new DAOLevel();
        this.levelNumber = levelNumber;
        this.map = dao.fetchMap(this.getLevelNumber());
    }

    /**
     * @return return the map of the level
     */
    public char[][] getMap() {
        return map;
    }

    /**
     * @param map to set a map for level
     */

    public void setMap(char[][] map) {
        this.map = map;
    }


    public int getLevelNumber() {
        return levelNumber;
    }
}

