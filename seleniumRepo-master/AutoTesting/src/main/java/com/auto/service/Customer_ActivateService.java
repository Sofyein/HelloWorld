package com.auto.service;

import java.util.List;

import java.util.ArrayList;
import com.auto.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.model.Customer_Activate;
import com.auto.repository.Customer_ActivateRepository;

@Service
public class Customer_ActivateService {

	@Autowired
	private Customer_ActivateRepository customer_activateRepository;

	public List<Customer_Activate> findAll() {
		return customer_activateRepository.findAll();
	}

	public Customer_Activate find(String id) {
		return customer_activateRepository.findById(id).orElse(null);
	}

	public Customer_Activate save(Customer_Activate customer_activate) {
		return customer_activateRepository.save(customer_activate);
	}

	public void delete(String id) {
		customer_activateRepository.deleteById(id);
	}

	public List<String[]> convertVersionsToArrays(List<Customer_Activate> Customer_Activates) {
		List<String[]> res = new ArrayList<String[]>();
		for (Customer_Activate customer_activate : Customer_Activates)
			res.add(SeleniumService.convertListToArray(convertVersionToArray(customer_activate)));
		return res;
	}

	public List<String> convertVersionToArray(Customer_Activate customer_activate) {
		List<String> res = new ArrayList<String>();
		String[] var0 = customer_activate.getName1();
		String value0 = "";
		for (int i = 0; i < var0.length; i++)
			if (i == var0.length - 1)
				value0 += var0[i];
			else
				value0 += var0[i] + SeleniumService.MV_DELIMITER;
		res.add(value0);
		String[] var1 = customer_activate.getName2();
		String value1 = "";
		for (int i = 0; i < var1.length; i++)
			if (i == var1.length - 1)
				value1 += var1[i];
			else
				value1 += var1[i] + SeleniumService.MV_DELIMITER;
		res.add(value1);
		String[] var2 = customer_activate.getShortName();
		String value2 = "";
		for (int i = 0; i < var2.length; i++)
			if (i == var2.length - 1)
				value2 += var2[i];
			else
				value2 += var2[i] + SeleniumService.MV_DELIMITER;
		res.add(value2);
		res.add(customer_activate.getCustomerType());
		res.add(customer_activate.getMnemonic());
		res.add(customer_activate.getAccountOfficer());
		res.add(customer_activate.getSector());
		res.add(customer_activate.getIndustry());
		res.add(customer_activate.getTarget());
		res.add(customer_activate.getCustomerStatus());
		res.add(customer_activate.getNationality());
		res.add(customer_activate.getResidence());
		res.add(customer_activate.getDateOfBirth());
		res.add(customer_activate.getBirthIncorpDate());
		res.add(customer_activate.getLanguage());
		String[] var15 = customer_activate.getStreet();
		String value15 = "";
		for (int i = 0; i < var15.length; i++)
			if (i == var15.length - 1)
				value15 += var15[i];
			else
				value15 += var15[i] + SeleniumService.MV_DELIMITER;
		res.add(value15);
		String[][] var16 = customer_activate.getAddress();
		String value16 = "";
		for (int i = 0; i < var16.length; i++) {
			String value = "";
			String[] elts = var16[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var16.length - 1)
				value16 += value;
			else
				value16 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value16);
		String[] var17 = customer_activate.getTownCountry();
		String value17 = "";
		for (int i = 0; i < var17.length; i++)
			if (i == var17.length - 1)
				value17 += var17[i];
			else
				value17 += var17[i] + SeleniumService.MV_DELIMITER;
		res.add(value17);
		String[] var18 = customer_activate.getPostCode();
		String value18 = "";
		for (int i = 0; i < var18.length; i++)
			if (i == var18.length - 1)
				value18 += var18[i];
			else
				value18 += var18[i] + SeleniumService.MV_DELIMITER;
		res.add(value18);
		String[] var19 = customer_activate.getCountry();
		String value19 = "";
		for (int i = 0; i < var19.length; i++)
			if (i == var19.length - 1)
				value19 += var19[i];
			else
				value19 += var19[i] + SeleniumService.MV_DELIMITER;
		res.add(value19);
		String[] var20 = customer_activate.getPhone1();
		String value20 = "";
		for (int i = 0; i < var20.length; i++)
			if (i == var20.length - 1)
				value20 += var20[i];
			else
				value20 += var20[i] + SeleniumService.MV_DELIMITER;
		res.add(value20);
		String[] var21 = customer_activate.getSms1();
		String value21 = "";
		for (int i = 0; i < var21.length; i++)
			if (i == var21.length - 1)
				value21 += var21[i];
			else
				value21 += var21[i] + SeleniumService.MV_DELIMITER;
		res.add(value21);
		String[] var22 = customer_activate.getEmail1();
		String value22 = "";
		for (int i = 0; i < var22.length; i++)
			if (i == var22.length - 1)
				value22 += var22[i];
			else
				value22 += var22[i] + SeleniumService.MV_DELIMITER;
		res.add(value22);
		String[] var23 = customer_activate.getOffPhone();
		String value23 = "";
		for (int i = 0; i < var23.length; i++)
			if (i == var23.length - 1)
				value23 += var23[i];
			else
				value23 += var23[i] + SeleniumService.MV_DELIMITER;
		res.add(value23);
		String[] var24 = customer_activate.getFax1();
		String value24 = "";
		for (int i = 0; i < var24.length; i++)
			if (i == var24.length - 1)
				value24 += var24[i];
			else
				value24 += var24[i] + SeleniumService.MV_DELIMITER;
		res.add(value24);
		res.add(customer_activate.getSecureMessage());
		res.add(customer_activate.getUpdatePrevAddress());
		String[] var27 = customer_activate.getLegalId();
		String value27 = "";
		for (int i = 0; i < var27.length; i++)
			if (i == var27.length - 1)
				value27 += var27[i];
			else
				value27 += var27[i] + SeleniumService.MV_DELIMITER;
		res.add(value27);
		String[] var28 = customer_activate.getLegalDocName();
		String value28 = "";
		for (int i = 0; i < var28.length; i++)
			if (i == var28.length - 1)
				value28 += var28[i];
			else
				value28 += var28[i] + SeleniumService.MV_DELIMITER;
		res.add(value28);
		String[] var29 = customer_activate.getLegalHolderName();
		String value29 = "";
		for (int i = 0; i < var29.length; i++)
			if (i == var29.length - 1)
				value29 += var29[i];
			else
				value29 += var29[i] + SeleniumService.MV_DELIMITER;
		res.add(value29);
		String[] var30 = customer_activate.getLegalIssAuth();
		String value30 = "";
		for (int i = 0; i < var30.length; i++)
			if (i == var30.length - 1)
				value30 += var30[i];
			else
				value30 += var30[i] + SeleniumService.MV_DELIMITER;
		res.add(value30);
		String[] var31 = customer_activate.getLegalIssDate();
		String value31 = "";
		for (int i = 0; i < var31.length; i++)
			if (i == var31.length - 1)
				value31 += var31[i];
			else
				value31 += var31[i] + SeleniumService.MV_DELIMITER;
		res.add(value31);
		String[] var32 = customer_activate.getLegalExpDate();
		String value32 = "";
		for (int i = 0; i < var32.length; i++)
			if (i == var32.length - 1)
				value32 += var32[i];
			else
				value32 += var32[i] + SeleniumService.MV_DELIMITER;
		res.add(value32);
		String[] var33 = customer_activate.getRelationCode();
		String value33 = "";
		for (int i = 0; i < var33.length; i++)
			if (i == var33.length - 1)
				value33 += var33[i];
			else
				value33 += var33[i] + SeleniumService.MV_DELIMITER;
		res.add(value33);
		String[] var34 = customer_activate.getRelCustomer();
		String value34 = "";
		for (int i = 0; i < var34.length; i++)
			if (i == var34.length - 1)
				value34 += var34[i];
			else
				value34 += var34[i] + SeleniumService.MV_DELIMITER;
		res.add(value34);
		String[] var35 = customer_activate.getReversRelCode();
		String value35 = "";
		for (int i = 0; i < var35.length; i++)
			if (i == var35.length - 1)
				value35 += var35[i];
			else
				value35 += var35[i] + SeleniumService.MV_DELIMITER;
		res.add(value35);
		String[][] var36 = customer_activate.getRelDelivOpt();
		String value36 = "";
		for (int i = 0; i < var36.length; i++) {
			String value = "";
			String[] elts = var36[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var36.length - 1)
				value36 += value;
			else
				value36 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value36);
		String[][] var37 = customer_activate.getRole();
		String value37 = "";
		for (int i = 0; i < var37.length; i++) {
			String value = "";
			String[] elts = var37[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var37.length - 1)
				value37 += value;
			else
				value37 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value37);
		String[][] var38 = customer_activate.getRoleMoreInfo();
		String value38 = "";
		for (int i = 0; i < var38.length; i++) {
			String value = "";
			String[] elts = var38[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var38.length - 1)
				value38 += value;
			else
				value38 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value38);
		String[][] var39 = customer_activate.getRoleNotes();
		String value39 = "";
		for (int i = 0; i < var39.length; i++) {
			String value = "";
			String[] elts = var39[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var39.length - 1)
				value39 += value;
			else
				value39 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value39);
		res.add(customer_activate.getCustomerLiability());
		String[] var41 = customer_activate.getPreviousName();
		String value41 = "";
		for (int i = 0; i < var41.length; i++)
			if (i == var41.length - 1)
				value41 += var41[i];
			else
				value41 += var41[i] + SeleniumService.MV_DELIMITER;
		res.add(value41);
		String[] var42 = customer_activate.getChangeDate();
		String value42 = "";
		for (int i = 0; i < var42.length; i++)
			if (i == var42.length - 1)
				value42 += var42[i];
			else
				value42 += var42[i] + SeleniumService.MV_DELIMITER;
		res.add(value42);
		String[] var43 = customer_activate.getChangeReason();
		String value43 = "";
		for (int i = 0; i < var43.length; i++)
			if (i == var43.length - 1)
				value43 += var43[i];
			else
				value43 += var43[i] + SeleniumService.MV_DELIMITER;
		res.add(value43);
		res.add(customer_activate.getCustomerSince());
		res.add(customer_activate.getNoOfDependents());
		String[] var46 = customer_activate.getOtherNationality();
		String value46 = "";
		for (int i = 0; i < var46.length; i++)
			if (i == var46.length - 1)
				value46 += var46[i];
			else
				value46 += var46[i] + SeleniumService.MV_DELIMITER;
		res.add(value46);
		String[] var47 = customer_activate.getSpokenLanguage();
		String value47 = "";
		for (int i = 0; i < var47.length; i++)
			if (i == var47.length - 1)
				value47 += var47[i];
			else
				value47 += var47[i] + SeleniumService.MV_DELIMITER;
		res.add(value47);
		String[] var48 = customer_activate.getInterests();
		String value48 = "";
		for (int i = 0; i < var48.length; i++)
			if (i == var48.length - 1)
				value48 += var48[i];
			else
				value48 += var48[i] + SeleniumService.MV_DELIMITER;
		res.add(value48);
		String[] var49 = customer_activate.getFurtherDetails();
		String value49 = "";
		for (int i = 0; i < var49.length; i++)
			if (i == var49.length - 1)
				value49 += var49[i];
			else
				value49 += var49[i] + SeleniumService.MV_DELIMITER;
		res.add(value49);
		String[] var50 = customer_activate.getPastimes();
		String value50 = "";
		for (int i = 0; i < var50.length; i++)
			if (i == var50.length - 1)
				value50 += var50[i];
			else
				value50 += var50[i] + SeleniumService.MV_DELIMITER;
		res.add(value50);
		String[] var51 = customer_activate.getEmploymentStatus();
		String value51 = "";
		for (int i = 0; i < var51.length; i++)
			if (i == var51.length - 1)
				value51 += var51[i];
			else
				value51 += var51[i] + SeleniumService.MV_DELIMITER;
		res.add(value51);
		String[] var52 = customer_activate.getOccupation();
		String value52 = "";
		for (int i = 0; i < var52.length; i++)
			if (i == var52.length - 1)
				value52 += var52[i];
			else
				value52 += var52[i] + SeleniumService.MV_DELIMITER;
		res.add(value52);
		String[] var53 = customer_activate.getJobTitle();
		String value53 = "";
		for (int i = 0; i < var53.length; i++)
			if (i == var53.length - 1)
				value53 += var53[i];
			else
				value53 += var53[i] + SeleniumService.MV_DELIMITER;
		res.add(value53);
		String[] var54 = customer_activate.getEmployersName();
		String value54 = "";
		for (int i = 0; i < var54.length; i++)
			if (i == var54.length - 1)
				value54 += var54[i];
			else
				value54 += var54[i] + SeleniumService.MV_DELIMITER;
		res.add(value54);
		String[][] var55 = customer_activate.getEmployersAdd();
		String value55 = "";
		for (int i = 0; i < var55.length; i++) {
			String value = "";
			String[] elts = var55[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var55.length - 1)
				value55 += value;
			else
				value55 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value55);
		String[] var56 = customer_activate.getEmployersBuss();
		String value56 = "";
		for (int i = 0; i < var56.length; i++)
			if (i == var56.length - 1)
				value56 += var56[i];
			else
				value56 += var56[i] + SeleniumService.MV_DELIMITER;
		res.add(value56);
		String[] var57 = customer_activate.getEmploymentStart();
		String value57 = "";
		for (int i = 0; i < var57.length; i++)
			if (i == var57.length - 1)
				value57 += var57[i];
			else
				value57 += var57[i] + SeleniumService.MV_DELIMITER;
		res.add(value57);
		String[] var58 = customer_activate.getCustomerCurrency();
		String value58 = "";
		for (int i = 0; i < var58.length; i++)
			if (i == var58.length - 1)
				value58 += var58[i];
			else
				value58 += var58[i] + SeleniumService.MV_DELIMITER;
		res.add(value58);
		String[] var59 = customer_activate.getSalary();
		String value59 = "";
		for (int i = 0; i < var59.length; i++)
			if (i == var59.length - 1)
				value59 += var59[i];
			else
				value59 += var59[i] + SeleniumService.MV_DELIMITER;
		res.add(value59);
		String[] var60 = customer_activate.getAnnualBonus();
		String value60 = "";
		for (int i = 0; i < var60.length; i++)
			if (i == var60.length - 1)
				value60 += var60[i];
			else
				value60 += var60[i] + SeleniumService.MV_DELIMITER;
		res.add(value60);
		String[] var61 = customer_activate.getSalaryDateFreq();
		String value61 = "";
		for (int i = 0; i < var61.length; i++)
			if (i == var61.length - 1)
				value61 += var61[i];
			else
				value61 += var61[i] + SeleniumService.MV_DELIMITER;
		res.add(value61);
		res.add(customer_activate.getNetMonthlyIn());
		res.add(customer_activate.getNetMonthlyOut());
		String[] var64 = customer_activate.getResidenceStatus();
		String value64 = "";
		for (int i = 0; i < var64.length; i++)
			if (i == var64.length - 1)
				value64 += var64[i];
			else
				value64 += var64[i] + SeleniumService.MV_DELIMITER;
		res.add(value64);
		String[] var65 = customer_activate.getResidenceType();
		String value65 = "";
		for (int i = 0; i < var65.length; i++)
			if (i == var65.length - 1)
				value65 += var65[i];
			else
				value65 += var65[i] + SeleniumService.MV_DELIMITER;
		res.add(value65);
		String[] var66 = customer_activate.getResidenceSince();
		String value66 = "";
		for (int i = 0; i < var66.length; i++)
			if (i == var66.length - 1)
				value66 += var66[i];
			else
				value66 += var66[i] + SeleniumService.MV_DELIMITER;
		res.add(value66);
		String[] var67 = customer_activate.getResidenceValue();
		String value67 = "";
		for (int i = 0; i < var67.length; i++)
			if (i == var67.length - 1)
				value67 += var67[i];
			else
				value67 += var67[i] + SeleniumService.MV_DELIMITER;
		res.add(value67);
		String[] var68 = customer_activate.getMortgageAmt();
		String value68 = "";
		for (int i = 0; i < var68.length; i++)
			if (i == var68.length - 1)
				value68 += var68[i];
			else
				value68 += var68[i] + SeleniumService.MV_DELIMITER;
		res.add(value68);
		String[] var69 = customer_activate.getCommType();
		String value69 = "";
		for (int i = 0; i < var69.length; i++)
			if (i == var69.length - 1)
				value69 += var69[i];
			else
				value69 += var69[i] + SeleniumService.MV_DELIMITER;
		res.add(value69);
		String[] var70 = customer_activate.getPrefChannel();
		String value70 = "";
		for (int i = 0; i < var70.length; i++)
			if (i == var70.length - 1)
				value70 += var70[i];
			else
				value70 += var70[i] + SeleniumService.MV_DELIMITER;
		res.add(value70);
		res.add(customer_activate.getConfidTxt());
		res.add(customer_activate.getInternetBankingService());
		res.add(customer_activate.getMobileBankingService());
		res.add(customer_activate.getContactDate());
		res.add(customer_activate.getIntroducer());
		res.add(customer_activate.getKycRelationship());
		res.add(customer_activate.getKycComplete());
		res.add(customer_activate.getLastKycReviewDate());
		res.add(customer_activate.getAutoNextKycReviewDate());
		res.add(customer_activate.getManualNextKycReviewDate());
		res.add(customer_activate.getLastSuitReviewDate());
		res.add(customer_activate.getAutoNextSuitReviewDate());
		res.add(customer_activate.getManualNextSuitReviewDate());
		String[] var84 = customer_activate.getRiskAssetType();
		String value84 = "";
		for (int i = 0; i < var84.length; i++)
			if (i == var84.length - 1)
				value84 += var84[i];
			else
				value84 += var84[i] + SeleniumService.MV_DELIMITER;
		res.add(value84);
		String[] var85 = customer_activate.getRiskLevel();
		String value85 = "";
		for (int i = 0; i < var85.length; i++)
			if (i == var85.length - 1)
				value85 += var85[i];
			else
				value85 += var85[i] + SeleniumService.MV_DELIMITER;
		res.add(value85);
		String[] var86 = customer_activate.getRiskTolerance();
		String value86 = "";
		for (int i = 0; i < var86.length; i++)
			if (i == var86.length - 1)
				value86 += var86[i];
			else
				value86 += var86[i] + SeleniumService.MV_DELIMITER;
		res.add(value86);
		String[] var87 = customer_activate.getRiskFromDate();
		String value87 = "";
		for (int i = 0; i < var87.length; i++)
			if (i == var87.length - 1)
				value87 += var87[i];
			else
				value87 += var87[i] + SeleniumService.MV_DELIMITER;
		res.add(value87);
		res.add(customer_activate.getAmlCheck());
		res.add(customer_activate.getAmlResult());
		res.add(customer_activate.getLastAmlResultDate());
		res.add(customer_activate.getCalcRiskClass());
		res.add(customer_activate.getManualRiskClass());
		String[] var93 = customer_activate.getOverrideReason();
		String value93 = "";
		for (int i = 0; i < var93.length; i++)
			if (i == var93.length - 1)
				value93 += var93[i];
			else
				value93 += var93[i] + SeleniumService.MV_DELIMITER;
		res.add(value93);
		res.add(customer_activate.getCompanyBook());
		res.add(customer_activate.getIssueCheques());
		res.add(customer_activate.getAllowBulkProcess());
		String[] var97 = customer_activate.getVisType();
		String value97 = "";
		for (int i = 0; i < var97.length; i++)
			if (i == var97.length - 1)
				value97 += var97[i];
			else
				value97 += var97[i] + SeleniumService.MV_DELIMITER;
		res.add(value97);
		String[][] var98 = customer_activate.getVisComment();
		String value98 = "";
		for (int i = 0; i < var98.length; i++) {
			String value = "";
			String[] elts = var98[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var98.length - 1)
				value98 += value;
			else
				value98 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value98);
		String[][] var99 = customer_activate.getVisInternalReview();
		String value99 = "";
		for (int i = 0; i < var99.length; i++) {
			String value = "";
			String[] elts = var99[i];
			value += elts[0];
			for (int j = 1; j < elts.length; j++)
				value += SeleniumService.SV_DELIMITER + elts[j];
			if (i == var99.length - 1)
				value99 += value;
			else
				value99 += value + SeleniumService.MV_DELIMITER;
		}
		res.add(value99);
		String[] var100 = customer_activate.getFormerVisType();
		String value100 = "";
		for (int i = 0; i < var100.length; i++)
			if (i == var100.length - 1)
				value100 += var100[i];
			else
				value100 += var100[i] + SeleniumService.MV_DELIMITER;
		res.add(value100);
		String[] var101 = customer_activate.getTaxId();
		String value101 = "";
		for (int i = 0; i < var101.length; i++)
			if (i == var101.length - 1)
				value101 += var101[i];
			else
				value101 += var101[i] + SeleniumService.MV_DELIMITER;
		res.add(value101);
		res.add(customer_activate.getNoUpdateCrm());
		String[] var103 = customer_activate.getCrProfileType();
		String value103 = "";
		for (int i = 0; i < var103.length; i++)
			if (i == var103.length - 1)
				value103 += var103[i];
			else
				value103 += var103[i] + SeleniumService.MV_DELIMITER;
		res.add(value103);
		String[] var104 = customer_activate.getCrProfile();
		String value104 = "";
		for (int i = 0; i < var104.length; i++)
			if (i == var104.length - 1)
				value104 += var104[i];
			else
				value104 += var104[i] + SeleniumService.MV_DELIMITER;
		res.add(value104);
		String[] var105 = customer_activate.getCrUserProfileType();
		String value105 = "";
		for (int i = 0; i < var105.length; i++)
			if (i == var105.length - 1)
				value105 += var105[i];
			else
				value105 += var105[i] + SeleniumService.MV_DELIMITER;
		res.add(value105);
		String[] var106 = customer_activate.getCrCalcProfile();
		String value106 = "";
		for (int i = 0; i < var106.length; i++)
			if (i == var106.length - 1)
				value106 += var106[i];
			else
				value106 += var106[i] + SeleniumService.MV_DELIMITER;
		res.add(value106);
		String[] var107 = customer_activate.getCrUserProfile();
		String value107 = "";
		for (int i = 0; i < var107.length; i++)
			if (i == var107.length - 1)
				value107 += var107[i];
			else
				value107 += var107[i] + SeleniumService.MV_DELIMITER;
		res.add(value107);
		String[] var108 = customer_activate.getCrCalcResetDate();
		String value108 = "";
		for (int i = 0; i < var108.length; i++)
			if (i == var108.length - 1)
				value108 += var108[i];
			else
				value108 += var108[i] + SeleniumService.MV_DELIMITER;
		res.add(value108);
		String[] var109 = customer_activate.getOverride();
		String value109 = "";
		for (int i = 0; i < var109.length; i++)
			if (i == var109.length - 1)
				value109 += var109[i];
			else
				value109 += var109[i] + SeleniumService.MV_DELIMITER;
		res.add(value109);
		res.add(customer_activate.getRecordStatus());
		res.add(customer_activate.getCurrNo());
		String[] var112 = customer_activate.getInputter();
		String value112 = "";
		for (int i = 0; i < var112.length; i++)
			if (i == var112.length - 1)
				value112 += var112[i];
			else
				value112 += var112[i] + SeleniumService.MV_DELIMITER;
		res.add(value112);
		res.add(customer_activate.getAuthoriser());
		String[] var114 = customer_activate.getDateTime();
		String value114 = "";
		for (int i = 0; i < var114.length; i++)
			if (i == var114.length - 1)
				value114 += var114[i];
			else
				value114 += var114[i] + SeleniumService.MV_DELIMITER;
		res.add(value114);
		res.add(customer_activate.getCoCode());
		res.add(customer_activate.getDeptCode());
		res.add(customer_activate.getAuditorCode());
		res.add(customer_activate.getAuditDateTime());
		return res;
	}
}