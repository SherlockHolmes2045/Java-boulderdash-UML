package model;

/**
 * 
 * @author Lemovou Dachi Ivan
 *		The class DAOLevel, it is for the level 
 */

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DAOLevel {

	/**instanciate a DBConnection*/
	private static DBConnection cnx=new DBConnection();

	/**
	 * 
	 * @param ind_lvl
	 * the number of the level to fetch in the DB
	 * @return map
	 * Fetch the map for the level precise in paramaters and return it
	 */

	public char[][] fetchMap(int ind_lvl){
		
		
		char[][] elements=new char[25][51];
		String strCurrentline=null;
		int j=0;
		 try {
				final String sql = "{call fetchMapById(?)}";
				final CallableStatement call = cnx.getConnection().prepareCall(sql);
				call.setInt(1, ind_lvl);
				call.execute();
				final ResultSet resultSet = call.getResultSet();
				while(resultSet.next()) {
					strCurrentline=resultSet.getString("map");
					for(int i=0;i<51;i++) {
						elements[j][i]=strCurrentline.charAt(i);
					}
					j++;
				}
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		
		return elements;
		
	}
 	
}
