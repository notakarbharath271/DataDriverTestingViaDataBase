package commonLibs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {
	  
	private Connection connection;
	
	public void openConnection(String server, String database, 
			int portNumber, String username, String password)
	{
		String connectionString = String.format("jdbc:mysql://%s:%d/%s", server, portNumber,database);
		try {
			connection = DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 public void closeConnection() {
		 try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 public  Object[][] executeSQLSelectQuery(String sqlQuery) throws SQLException{
		 
		Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = stm.executeQuery(sqlQuery);
		resultSet.last();
		int rowCount = resultSet.getRow();
		int cellCount = resultSet.getMetaData().getColumnCount();
		Object[][] data = new Object[rowCount][cellCount];
		
		for(int row=1;row<=rowCount;row++) {
			for(int cell=1;cell<=cellCount;cell++) {
				data[row-1][cell-1]=resultSet.getString(cell);
			}
		}	
		 
		return data;
		 
	 }
}
