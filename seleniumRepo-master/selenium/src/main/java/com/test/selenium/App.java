package com.test.selenium;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

//		 TestScenario.getFieldsFromVersion("KHALILAR","123456", "CUSTOMER,TEST");
//		SeleniumService.VERSION="CUSTOMER,TEST";
//		TestScenario.validateNewDeal();

		List<String[]> records=new ArrayList<String[]>();
		String[] rec1 = { "TEST", "TEST1,TEST2,TEST3", "TEST",
				"ADR1.1;ADR1.2,ADR2.1;ADR2.2", "1000", "2", "1", "1000", "1", "TN", "1" };
		String[] rec2 = { "TESTA", "TESTA1,TESTA2,TESTA3", "TESTA",
				"ADR1A.1;ADR1A.2,ADR2A.1;ADR2A.2", "1000", "2", "1", "1000", "1", "TN", "1" };
		records.add(rec1);
		records.add(rec2);
		TestScenario.testVersion("KHALILAR", "123456", "CUSTOMER,TEST",records);

		
		

	}

}
