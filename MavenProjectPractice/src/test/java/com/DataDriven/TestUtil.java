package com.DataDriven;

import java.util.ArrayList;

public class TestUtil {
	public static Xls_Reader reader;

	public static ArrayList<Object[]> getDataExcel() {
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader(".\\src\\test\\java\\com\\DataDriven\\LoginTestData.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount("login");rowNum++) {
			String username=reader.getCellData("login", "username", rowNum);
			String password=reader.getCellData("login", "password", rowNum);
			
			Object ob[]= {username,password};
			myData.add(ob);
			//myData.add(new Object[] {username,password});
		}
		return myData;
	}
	
}
