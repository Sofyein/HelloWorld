package com.auto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.auto.service.GenerationService;

@SpringBootApplication
public class AutoTestingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AutoTestingApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		 GenerationService.generateAllFromVersion("KHALILAR","123456",
		 "CUSTOMER,ACTIVATE");

//		CSVReader csvReader = new CSVReader(new FileReader(new File("testcase.csv")));
//		List<String[]> records = csvReader.readAll();
//		TestScenario.testVersion("KHALILAR", "123456", "CUSTOMER,TEST", records);
//		csvReader.close();
		
		
	

		//		Customer_Test customer_Test=new Customer_Test();
//		customer_Test.setId("1");
//		String[][] adr= {{"adr1.1","adr1.2"},{"adr2.1","adr2.2"}};
//		customer_Test.setAddress(adr);
//		customer_Test.setAccountOfficer("Account Officer");
//		customer_Test.setCustomerStatus("1");
//		customer_Test.setIndustry("dd");
//		customer_Test.setLanguage("1");
//		customer_Test.setMnemonic("MNEMONIC");
//		String[] shortNames= {"Name1","Name2","Name3"};
//		customer_Test.setName1(shortNames);
//		customer_Test.setNationality("dd");
//		customer_Test.setSector("sector");
//		customer_Test.setTarget("ss");
//		customer_Test.setShortName(shortNames);
		
//		Customer_TestController customer_TestController=new Customer_TestController();
//		System.out.println(customer_TestController.convertVersionToArray(customer_Test));
		

	}
}
