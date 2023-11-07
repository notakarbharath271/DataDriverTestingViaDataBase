package com.guru99.utils;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DataBaseUtils;

public class TestDataSource {
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		
		data[0][0]="mngr537627";
		data[0][1]="usajehE";
		data[1][0]="mngr537627";
		data[1][1]="usajehE";
		data[2][0]="mngr537627";
		data[2][1]="usajehE";
		
		return data;
	}
	@DataProvider
	public Object[][] gateDataFromDatabase() throws SQLException {
		
		Object[][] data;
		DataBaseUtils databaseUtils = new DataBaseUtils();	
		
		String server = "localhost";
		int portNumber = 3306;
		String database = "Guru99TestData";
		String username ="root";
		String password ="admin@1234";
		
		databaseUtils.openConnection(server, database, portNumber, username,password);
		String sqlQuery = "select * from users;";
		data = databaseUtils.executeSQLSelectQuery(sqlQuery);
		databaseUtils.closeConnection();
		return data;
	}

}
