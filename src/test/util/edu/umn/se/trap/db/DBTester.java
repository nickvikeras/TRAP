package edu.umn.se.trap.db;

import java.util.ArrayList;
import java.util.List;

public class DBTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PerDiemDB test = new PerDiemDB();
		
		try{
			List<Double> rate = test.getDomesticPerDiem("des moines","ia");
			System.out.println(rate.get(0));
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
