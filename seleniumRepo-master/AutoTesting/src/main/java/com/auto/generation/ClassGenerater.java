package com.auto.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.auto.test.TestScenario;


public class ClassGenerater {

	public static String DEFAULT_PACKAGE_MODEL = "com.auto.model";
	public static String DEFAULT_PACKAGE_REPO = "com.auto.repository";
	public static String DEFAULT_PACKAGE_SERV = "com.auto.service";
	public static String DEFAULT_PACKAGE_CONTRL = "com.auto.controller";
	public static String VERSION = "";
	public static String USERNAME = "KHALILAR";
	public static String PASSWORD = "123456";

	public static void generateModel(String className, String[] fields) {
		String script = "package " + DEFAULT_PACKAGE_MODEL + ";";
		script += "\n import lombok.Data;  \n" + "import org.springframework.data.mongodb.core.mapping.Document; \n"
				+ "\n" + "@Data \n" + "@Document \n" + "public class " + className + " { \n";
		for (int i = 0; i < fields.length; i++)
			if (fields[i].endsWith("-1.1"))
				script += "\t private String[][] " + formatField(fields[i].substring(0, fields[i].length() - 4))
						+ "; \n";
			else if (fields[i].endsWith("-1"))
				script += "\t private String[] " + formatField(fields[i].substring(0, fields[i].length() - 2)) + "; \n";
			else
				script += "\t private String " + formatField(fields[i]) + "; \n";
		script += "}";

		String path = "src\\main\\java\\";
		String[] packagePath = DEFAULT_PACKAGE_MODEL.split("\\.");
		for (int i = 0; i < packagePath.length; i++)
			path += packagePath[i] + "\\";
		writeJavaFile(path + className + ".java", script);

	}

	public static void generateRepository(String className) {
		String script = "package " + DEFAULT_PACKAGE_REPO + ";";
		script += "\nimport org.springframework.stereotype.Repository;\n" + "import com.auto.model." + className + ";\n"
				+ "import org.springframework.data.mongodb.repository.MongoRepository;\n" + "\n" + "@Repository\n"
				+ "public interface " + className + "Repository extends MongoRepository<" + className + ",String> {\n}";

		String path = "src\\main\\java\\";
		String[] packagePath = DEFAULT_PACKAGE_REPO.split("\\.");
		for (int i = 0; i < packagePath.length; i++)
			path += packagePath[i] + "\\";
		writeJavaFile(path + className + "Repository.java", script);

	}

	public static void generateService(String className) {
		String script = "package " + DEFAULT_PACKAGE_SERV + ";\r\n" + "\r\n" + "import java.util.List;\r\n" + "\r\n"
				+ "import java.util.ArrayList;\r\n" + "import com.auto.service.SeleniumService;\r\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\r\n"
				+ "import org.springframework.stereotype.Service;\r\n" + "\r\n" + "import " + DEFAULT_PACKAGE_MODEL
				+ "." + className + ";\r\n" + "import " + DEFAULT_PACKAGE_REPO + "." + className + "Repository;\r\n"
				+ "@Service \r\n" + "public class " + className + "Service {\r\n" + "\r\n" + "	@Autowired\r\n"
				+ "	private " + className + "Repository " + className.toLowerCase() + "Repository;\r\n" + "	\r\n"
				+ "	public List<" + className + "> findAll() {\r\n" + "		return " + className.toLowerCase()
				+ "Repository.findAll();\r\n" + "	}\r\n" + "	\r\n" + "	public " + className
				+ " find(String id) {\r\n" + "		return " + className.toLowerCase()
				+ "Repository.findById(id).orElse(null);\r\n" + "	}\r\n" + "	\r\n" + "	\r\n" + "	public "
				+ className + " save(" + className + " " + className.toLowerCase() + ") {\r\n" + "		return "
				+ className.toLowerCase() + "Repository.save(" + className.toLowerCase() + ");\r\n" + "	}\r\n"
				+ "	public void delete(String id) {\r\n" + "		" + className.toLowerCase()
				+ "Repository.deleteById(id);\r\n" + "	}\r\n";

		script += "\n\n" + generateConvertVersionToArray() + "\n}";
		String path = "src\\main\\java\\";
		String[] packagePath = DEFAULT_PACKAGE_SERV.split("\\.");
		for (int i = 0; i < packagePath.length; i++)
			path += packagePath[i] + "\\";
		writeJavaFile(path + className + "Service.java", script);
	}

	public static void generateController(String className) {
		String script = "package " + DEFAULT_PACKAGE_CONTRL + ";\r\n" + "\r\n" + "import java.util.List;\r\n" + "\r\n"
				+ "import org.springframework.beans.factory.annotation.Autowired;\r\n"
				+ "import org.springframework.web.bind.annotation.PutMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.CrossOrigin;\r\n"
				+ "import org.springframework.web.bind.annotation.DeleteMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.GetMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.PathVariable;\r\n"
				+ "import org.springframework.web.bind.annotation.PostMapping;\r\n"
				+ "import org.springframework.web.bind.annotation.RequestBody;\r\n"
				+ "import org.springframework.web.bind.annotation.RestController;\r\n" + "\r\n" + "import "
				+ DEFAULT_PACKAGE_MODEL + "." + className + ";\r\n" + "import " + DEFAULT_PACKAGE_SERV + "." + className
				+ "Service;\r\n" + "\r\n" + "@RestController\r\n" + "@CrossOrigin\r\n" + "public class " + className
				+ "Controller {\r\n" + "\r\n" + "	@Autowired\r\n" + "	private " + className + "Service "
				+ className.toLowerCase() + "Service;\r\n" + "	\r\n" + "	@GetMapping(\"/" + className.toLowerCase()
				+ "s" + "\")\r\n" + "	public List<" + className + "> findAll() {\r\n" + "		return "
				+ className.toLowerCase() + "Service.findAll();\r\n" + "	}\r\n" + "	\r\n" + "	@GetMapping(\"/"
				+ className.toLowerCase() + "s" + "/{id}\")\r\n" + "	public " + className
				+ " find(@PathVariable String id) {\r\n" + "		return " + className.toLowerCase()
				+ "Service.find(id);\r\n" + "	}\r\n" + "	\r\n" + "	\r\n" + "	@PostMapping(\"/"
				+ className.toLowerCase() + "s" + "\")\r\n" + "	public " + className + " save(@RequestBody " + className
				+ " " + className.toLowerCase() + ") {\r\n" + "		return " + className.toLowerCase() + "Service.save("
				+ className.toLowerCase() + ");\r\n" + "	}\r\n" + "	\r\n" + "	@DeleteMapping(\"/"
				+ className.toLowerCase() + "s" + "/{id}\")\r\n"
				+ "	public void delete(@PathVariable String id) {\r\n" + "		" + className.toLowerCase()
				+ "Service.delete(id);\r\n" + "	}\r\n\n"
						+ "	@PutMapping(\"/"+className.toLowerCase()+"s/convertoarray\")\r\n" + 
						"	public List<String[]> convertVersionsToArrays(@RequestBody List<"+className+"> "+className.toLowerCase()+"s) {\r\n" + 
						"		return "+className.toLowerCase()+"Service.convertVersionsToArrays("+className.toLowerCase()+"s);\r\n" + 
						"	}\n"
						+ " }";

		String path = "src\\main\\java\\";
		String[] packagePath = DEFAULT_PACKAGE_CONTRL.split("\\.");
		for (int i = 0; i < packagePath.length; i++)
			path += packagePath[i] + "\\";
		writeJavaFile(path + className + "Controller.java", script);
	}

	public static void generateAll(String className, String[] fields) {
		generateModel(className, fields);
		generateRepository(className);
		generateService(className);
		generateController(className);
	}

	public static void writeJavaFile(String filePath, String script) {
		try {
			FileWriter fileWriter = new FileWriter(new File(filePath));
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(script);
			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String formatField(String field) {
		field = field.toLowerCase();
		char[] car = field.toCharArray();
		String res = "";
		for (int i = 0; i < car.length; i++) {
			if (car[i] == '.' && i != car.length)
				car[i + 1] = Character.toUpperCase(car[i + 1]);
			res += car[i];
		}

		res = res.replace(".", "");
		return res;

	}

	public static String formatClassName(String version) {
		version = version.toLowerCase();
		char[] car = version.toCharArray();
		String className = "";
		car[0] = Character.toUpperCase(car[0]);
		className += car[0];
		for (int i = 1; i < car.length; i++) {
			if (car[i] == '.' && i != car.length)
				car[i + 1] = Character.toUpperCase(car[i + 1]);
			else if (car[i] == ',' && i != car.length) {
				car[i] = '_';
				car[i + 1] = Character.toUpperCase(car[i + 1]);
			}
			className += car[i];
		}

		className = className.replace(".", "");
		return className;

	}

	public static String toUpperCaseFirstLetter(String ch) {
		char[] car = ch.toCharArray();
		car[0] = Character.toUpperCase(car[0]);
		String res = "";
		for (int i = 0; i < car.length; i++)
			res += car[i];
		return res;
	}

	public static String generateConvertVersionToArray() {
		String script = "";
		script+="public List<String[]> convertVersionsToArrays(List<"+formatClassName(VERSION)+"> "+formatClassName(VERSION) +"s) {\r\n" + 
				"		List<String[]> res=new ArrayList<String[]>();\r\n" + 
				"		for("+formatClassName(VERSION)+" "+formatClassName(VERSION).toLowerCase()+" : "+ formatClassName(VERSION)+"s)\r\n" + 
				"			res.add(SeleniumService.convertListToArray(convertVersionToArray("+formatClassName(VERSION).toLowerCase()+")));\r\n" + 
				"		return res;\r\n" + 
				"	}\n\n";
		
		List<String> T24_FIELDS = TestScenario.getFieldsFromVersion(USERNAME, PASSWORD, VERSION);
		List<String> classFields = new ArrayList<String>();
		for (String field : T24_FIELDS) {
			if (field.endsWith("-1.1"))
				classFields.add(formatField(field.substring(0, field.length() - 4)));
			else if (field.endsWith("-1"))
				classFields.add(formatField(field.substring(0, field.length() - 2)));
			else
				classFields.add(formatField(field));
		}
		
		script += "public List<String> convertVersionToArray(" + formatClassName(VERSION) + " "
				+ formatClassName(VERSION).toLowerCase() + ") {\n" + "List<String> res=new ArrayList<String>();\n";
		for (int i = 0; i < T24_FIELDS.size(); i++) {
			if (T24_FIELDS.get(i).endsWith("-1.1")) {
				script += "String[][] var" + i + "=" + formatClassName(VERSION).toLowerCase() + ".get"
						+ toUpperCaseFirstLetter(classFields.get(i)) + "();\n" + "String value" + i + "=\"\";\n"
						+ "for(int i=0; i<var" + i + ".length  ;i++) \n" + "{\n" + "String value=\"\";\n"
						+ "String[] elts=var" + i + "[i];\n" + "value+=elts[0];\n"
						+ "for(int j=1; j<elts.length; j++) \n" + "value+=SeleniumService.SV_DELIMITER+elts[j];\n"
						+ "if(i==var" + i + ".length-1) value" + i + "+=value;\n" + "else \n" + "value" + i
						+ "+=value+SeleniumService.MV_DELIMITER;\n" + "}\n" + "res.add(value" + i + ");\n";
			} else if (T24_FIELDS.get(i).endsWith("-1")) {
				script += "String[] var" + i + "=" + formatClassName(VERSION).toLowerCase() + ".get"
						+ toUpperCaseFirstLetter(classFields.get(i)) + "();\n" + "String value" + i + "=\"\";\n"
						+ "for(int i=0; i<var" + i + ".length  ;i++) \n" + "if(i==var" + i + ".length-1) value" + i
						+ "+=var" + i + "[i];\n" + "else value" + i + "+=var" + i
						+ "[i]+SeleniumService.MV_DELIMITER;\n" + "res.add(value" + i + ");\n";
			} else {
				script += "res.add(" + formatClassName(VERSION).toLowerCase() + ".get"
						+ toUpperCaseFirstLetter(classFields.get(i)) + "());\n";
			}

		}
		script += "return res; \n }";
		return script;
	}

}
