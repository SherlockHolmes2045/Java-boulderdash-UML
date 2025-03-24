
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The class DAOLevel, it is for the level
 */
public class DAOLevel {

    /**
     * instanciate a DBConnection
     */
    private static final DBConnection cnx = DBConnection.getInstance();
    private static final int COLUMN = 25;
    private static final Logger logger = Logger.getLogger(DAOLevel.class.getName());



    /**
     * @param levels the number of the level to fetch in the DB
     * @return map
     * Fetch the map for the level precise in paramaters and return it
     */
    public char[][] fetchMap(int levels,int maxLevel) {
        if (levels < 1 || levels > maxLevel) {
            throw new IllegalArgumentException("Invalid level index: " + levels);
        }

        char[][] elements = new char[COLUMN][GameConstants.ROW];
        String strCurrentline;
        int j = 0;
        try {
            final String sql = "{call fetchMapById(?)}";
            try (CallableStatement call = cnx.getConnection().prepareCall(sql)) {
                call.setInt(1, levels);
                call.execute();
                try (ResultSet resultSet = call.getResultSet()) {
                    if (resultSet != null && resultSet.next()) {
                        do {
                            strCurrentline = resultSet.getString("map");
                            for (int i = 0; i < GameConstants.ROW; i++) {
                                elements[j][i] = strCurrentline.charAt(i);
                            }
                            j++;
                        } while (resultSet.next());
                    }
                }
            }
        } catch (final SQLException e) {
            logger.log(Level.SEVERE, "SQL Exception occurred", e);
        }

        return elements;
    }

    public List<Map<String, Integer>> getLevelsData() {
        List<Map<String, Integer>> levelsData = new ArrayList<>();
        try {
            final String sql = "SELECT * FROM levels_properties;";
            try (PreparedStatement stmt = cnx.getConnection().prepareStatement(sql)) {
                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet != null) {
                        while (resultSet.next()) {
                            Map<String, Integer> data = new HashMap<>();
                            data.put("level", resultSet.getInt("level"));
                            data.put("dashX", resultSet.getInt("dashX"));
                            data.put("dashY", resultSet.getInt("dashY"));
                            data.put("exitX", resultSet.getInt("exitX"));
                            data.put("exitY", resultSet.getInt("exitY"));
                            data.put("diamond_count", resultSet.getInt("diamond_count"));
                            data.put("game_duration", resultSet.getInt("game_duration"));
                            levelsData.add(data);
                        }
                    }
                }
            }

        } catch (final SQLException e) {
            logger.log(Level.SEVERE, "SQL Exception occurred", e);
        }
        return levelsData;
    }
}
