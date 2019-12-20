package com.auto.service;

import java.util.List;

import java.util.ArrayList;
import com.auto.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.model.Customer_Test;
import com.auto.repository.Customer_TestRepository;
@Service 
public class Customer_TestService {

	@Autowired
	private Customer_TestRepository customer_testRepository;
	
	public List<Customer_Test> findAll() {
		return customer_testRepository.findAll();
	}
	
	public Customer_Test find(String id) {
		return customer_testRepository.findById(id).orElse(null);
	}
	
	
	public Customer_Test save(Customer_Test customer_test) {
		return customer_testRepository.save(customer_test);
	}
	public void delete(String id) {
		customer_testRepository.deleteById(id);
	}


public List<String[]> convertVersionsToArrays(List<Customer_Test> Customer_Tests) {
		List<String[]> res=new ArrayList<String[]>();
		for(Customer_Test customer_test : Customer_Tests)
			res.add(SeleniumService.convertListToArray(convertVersionToArray(customer_test)));
		return res;
	}

public List<String> convertVersionToArray(Customer_Test customer_test) {
List<String> res=new ArrayList<String>();
res.add(customer_test.getMnemonic());
String[] var1=customer_test.getShortName();
String value1="";
for(int i=0; i<var1.length  ;i++) 
if(i==var1.length-1) value1+=var1[i];
else value1+=var1[i]+SeleniumService.MV_DELIMITER;
res.add(value1);
String[] var2=customer_test.getName1();
String value2="";
for(int i=0; i<var2.length  ;i++) 
if(i==var2.length-1) value2+=var2[i];
else value2+=var2[i]+SeleniumService.MV_DELIMITER;
res.add(value2);
String[][] var3=customer_test.getAddress();
String value3="";
for(int i=0; i<var3.length  ;i++) 
{
String value="";
String[] elts=var3[i];
value+=elts[0];
for(int j=1; j<elts.length; j++) 
value+=SeleniumService.SV_DELIMITER+elts[j];
if(i==var3.length-1) value3+=value;
else 
value3+=value+SeleniumService.MV_DELIMITER;
}
res.add(value3);
res.add(customer_test.getSector());
res.add(customer_test.getLanguage());
res.add(customer_test.getAccountOfficer());
res.add(customer_test.getIndustry());
res.add(customer_test.getTarget());
res.add(customer_test.getNationality());
res.add(customer_test.getCustomerStatus());
return res; 
 }
}