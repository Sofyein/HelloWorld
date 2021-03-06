package com.auto.test;

import java.util.List;

import com.auto.service.SeleniumService;

public class TestScenario {

	public static void testVersion(String username, String password, String version, List<String[]> records) {
		SeleniumService.initializeDriver();
		SeleniumService.USERNAME=username;
		SeleniumService.PASSWORD=password;
		if(SeleniumService.signIn()) {
			SeleniumService.VERSION=version;
			SeleniumService.switchToVersionApplication();
			List<String> fields=SeleniumService.getFieldsFromVersion();
			SeleniumService.T24_FIELDS=SeleniumService.convertListToArray(fields);
			SeleniumService.switchBackToMainWindow();
			SeleniumService.switchToVersion();
			records.forEach(rec->{
				SeleniumService.VALUES=rec;
				System.out.println(SeleniumService.addNewDeal());
				SeleniumService.switchBackToVersion();
			});
			SeleniumService.switchBackToMainWindow();
			SeleniumService.signOff();
			SeleniumService.closeAllWindows();
		}else
		{
			System.out.println("Sign In Failed");
			SeleniumService.closeAllWindows();
		}
	}

	public static List<String> getFieldsFromVersion(String username, String password, String version) {
		SeleniumService.initializeDriver();
		SeleniumService.USERNAME = username;
		SeleniumService.PASSWORD = password;
		if (SeleniumService.signIn()) {
			SeleniumService.VERSION = version;
			SeleniumService.switchToVersionApplication();
			List<String> fields=SeleniumService.getFieldsFromVersion();
			fields.forEach(elt -> System.out.println(elt));
			SeleniumService.switchBackToMainWindow();
			if (SeleniumService.signOff())
				System.out.println("Signed OFF");
			SeleniumService.closeAllWindows();
			return fields;
		} else
			SeleniumService.closeAllWindows();
		return null;
	
		
	}

	public static void validateNewDeal() {
		SeleniumService.initializeDriver();
		SeleniumService.signIn();
		SeleniumService.switchToVersion();
		if (SeleniumService.addNewDeal())
			System.out.println("validated");
		else
			System.out.println("failed");
		SeleniumService.switchBackToMainWindow();
		if (SeleniumService.signOff())
			System.out.println("Signed OFF");
		SeleniumService.closeAllWindows();
	}

}
