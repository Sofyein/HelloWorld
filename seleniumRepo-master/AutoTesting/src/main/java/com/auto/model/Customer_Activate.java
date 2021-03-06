package com.auto.model;
 import lombok.Data;  
import org.springframework.data.mongodb.core.mapping.Document; 

@Data 
@Document 
public class Customer_Activate { 
	 private String id; 
	 private String[] name1; 
	 private String[] name2; 
	 private String[] shortName; 
	 private String customerType; 
	 private String mnemonic; 
	 private String accountOfficer; 
	 private String sector; 
	 private String industry; 
	 private String target; 
	 private String customerStatus; 
	 private String nationality; 
	 private String residence; 
	 private String dateOfBirth; 
	 private String birthIncorpDate; 
	 private String language; 
	 private String[] street; 
	 private String[][] address; 
	 private String[] townCountry; 
	 private String[] postCode; 
	 private String[] country; 
	 private String[] phone1; 
	 private String[] sms1; 
	 private String[] email1; 
	 private String[] offPhone; 
	 private String[] fax1; 
	 private String secureMessage; 
	 private String updatePrevAddress; 
	 private String[] legalId; 
	 private String[] legalDocName; 
	 private String[] legalHolderName; 
	 private String[] legalIssAuth; 
	 private String[] legalIssDate; 
	 private String[] legalExpDate; 
	 private String[] relationCode; 
	 private String[] relCustomer; 
	 private String[] reversRelCode; 
	 private String[][] relDelivOpt; 
	 private String[][] role; 
	 private String[][] roleMoreInfo; 
	 private String[][] roleNotes; 
	 private String customerLiability; 
	 private String[] previousName; 
	 private String[] changeDate; 
	 private String[] changeReason; 
	 private String customerSince; 
	 private String noOfDependents; 
	 private String[] otherNationality; 
	 private String[] spokenLanguage; 
	 private String[] interests; 
	 private String[] furtherDetails; 
	 private String[] pastimes; 
	 private String[] employmentStatus; 
	 private String[] occupation; 
	 private String[] jobTitle; 
	 private String[] employersName; 
	 private String[][] employersAdd; 
	 private String[] employersBuss; 
	 private String[] employmentStart; 
	 private String[] customerCurrency; 
	 private String[] salary; 
	 private String[] annualBonus; 
	 private String[] salaryDateFreq; 
	 private String netMonthlyIn; 
	 private String netMonthlyOut; 
	 private String[] residenceStatus; 
	 private String[] residenceType; 
	 private String[] residenceSince; 
	 private String[] residenceValue; 
	 private String[] mortgageAmt; 
	 private String[] commType; 
	 private String[] prefChannel; 
	 private String confidTxt; 
	 private String internetBankingService; 
	 private String mobileBankingService; 
	 private String contactDate; 
	 private String introducer; 
	 private String kycRelationship; 
	 private String kycComplete; 
	 private String lastKycReviewDate; 
	 private String autoNextKycReviewDate; 
	 private String manualNextKycReviewDate; 
	 private String lastSuitReviewDate; 
	 private String autoNextSuitReviewDate; 
	 private String manualNextSuitReviewDate; 
	 private String[] riskAssetType; 
	 private String[] riskLevel; 
	 private String[] riskTolerance; 
	 private String[] riskFromDate; 
	 private String amlCheck; 
	 private String amlResult; 
	 private String lastAmlResultDate; 
	 private String calcRiskClass; 
	 private String manualRiskClass; 
	 private String[] overrideReason; 
	 private String companyBook; 
	 private String issueCheques; 
	 private String allowBulkProcess; 
	 private String[] visType; 
	 private String[][] visComment; 
	 private String[][] visInternalReview; 
	 private String[] formerVisType; 
	 private String[] taxId; 
	 private String noUpdateCrm; 
	 private String[] crProfileType; 
	 private String[] crProfile; 
	 private String[] crUserProfileType; 
	 private String[] crCalcProfile; 
	 private String[] crUserProfile; 
	 private String[] crCalcResetDate; 
	 private String[] override; 
	 private String recordStatus; 
	 private String currNo; 
	 private String[] inputter; 
	 private String authoriser; 
	 private String[] dateTime; 
	 private String coCode; 
	 private String deptCode; 
	 private String auditorCode; 
	 private String auditDateTime; 
}