package com.auto.service;

import java.util.ArrayList;
import java.util.List;

import com.auto.generation.ClassGenerater;
import com.auto.test.TestScenario;

public class GenerationService {

	public static void generateAllFromVersion(String username,String password,String version) {
		ClassGenerater.USERNAME=username;
		ClassGenerater.PASSWORD=password;
		ClassGenerater.VERSION=version;
		List<String> fields =TestScenario.getFieldsFromVersion(username,password,version);
		List<String> fieldsWithId=new ArrayList<String>();
		fieldsWithId.add("ID");
		fieldsWithId.addAll(fields);
		ClassGenerater.generateAll(ClassGenerater.formatClassName(version), SeleniumService.convertListToArray(fieldsWithId));
	}
}
