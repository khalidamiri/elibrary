package org.elibrary.db;

import java.util.HashMap;

import org.elibrary.doc.*;

public class Drivers extends HashMap{
	
	public Drivers(){
		this.put("mysql-native", "com.mysql.jdbc.Driver");
		this.put("oracle-native", "oracle.jdbc.driver.OracleDriver");
	}
	
	public String get(String driverName){
		return super.get(driverName).toString();
	}
}
