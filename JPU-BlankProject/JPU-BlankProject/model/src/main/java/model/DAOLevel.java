
package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static final int ROWS = 25;
    private static final int COLUMNS = 51;
    private static final int MAX_LEVEL = 5;
    private static final Logger logger = Logger.getLogger(DAOLevel.class.getName());

    /**
     * @param indLvl the number of the level to fetch in the DB
     * @return map
     * Fetch the map for the level precise in paramaters and return it
     */
    public char[][] fetchMap(int indLvl) {
        if (indLvl < 0 || indLvl > MAX_LEVEL) {
            throw new IllegalArgumentException("Invalid level index: " + indLvl);
        }

        char[][] elements = new char[ROWS][COLUMNS];
        String strCurrentline;
        int j = 0;
        try {
            final String sql = "{call fetchMapById(?)}";
            try (CallableStatement call = cnx.getConnection().prepareCall(sql)) {
                call.setInt(1, indLvl);
                call.execute();
                try (ResultSet resultSet = call.getResultSet()) {
                    if (resultSet != null) {
                        while (resultSet.next()) {
                            strCurrentline = resultSet.getString("map");
                            for (int i = 0; i < COLUMNS; i++) {
                                elements[j][i] = strCurrentline.charAt(i);
                            }
                            j++;
                        }
                    }
                }
            }
        } catch (final SQLException e) {
            logger.log(Level.SEVERE, "SQL Exception occurred", e);
        }

        return elements;
    }
}
