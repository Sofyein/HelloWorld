package com.auto.model;
 import lombok.Data;  
import org.springframework.data.mongodb.core.mapping.Document; 

@Data 
@Document 
public class Customer_Test { 
	 private String id; 
	 private String mnemonic; 
	 private String[] shortName; 
	 private String[] name1; 
	 private String[][] address; 
	 private String sector; 
	 private String language; 
	 private String accountOfficer; 
	 private String industry; 
	 private String target; 
	 private String nationality; 
	 private String customerStatus; 
}