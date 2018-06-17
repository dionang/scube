package com.util.helper;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.commons.beanutils.PropertyUtils;

import utils.Validator;

public class JPQLHelper {
	public static String getByCriteria(Object searchDetail, Class entityClass , String docType){
		StringBuffer stmt = new StringBuffer();
		String alias="u.";
		stmt.append("SELECT u FROM "+entityClass.getName()+" u ");
		ArrayList criteriaList = SearchCriteriaHelper.getCriteriaList(docType);
		if(Validator.isNotNull(criteriaList)){
			for(int z=0; z<criteriaList.size(); z++){
				String criteriaString = (String)criteriaList.get(z);
				String[] criteriaDetail = criteriaString.split("\\|");
				String type = criteriaDetail[0].replace("type@", "");
				String entityProperty = criteriaDetail[1].replace("entity@", "");
				String searchdetailProperty = criteriaDetail[2].replace("searchdetail@", "");
				String operator = criteriaDetail[3].replace("operator@", "");
				try{
				if("string".equals(type)){
					String fieldValue = (String)PropertyUtils.getProperty(searchDetail, searchdetailProperty);
					stmt.append(GeneralJPQLHelper.FormCriteriaString(stmt.toString(), alias+entityProperty, fieldValue, "AND", operator));
				}
				if("int".equals(type)){
					int fieldValue = (Integer)PropertyUtils.getProperty(searchDetail, searchdetailProperty);
					stmt.append(GeneralJPQLHelper.FormCriteriaInt(stmt.toString(), alias+entityProperty, fieldValue, "AND"));
				}
				if("dateRange".equals(type)){
					String[] dateRange = searchdetailProperty.split("$%");
					Timestamp fieldValueMin = (Timestamp)PropertyUtils.getProperty(searchDetail, dateRange[0]);
					Timestamp fieldValueMax = (Timestamp)PropertyUtils.getProperty(searchDetail, dateRange[1]);
					stmt.append(GeneralJPQLHelper.FormCriteriaDateRange(stmt.toString(), alias+entityProperty, fieldValueMin, fieldValueMax, "AND"));
				}
				
				}catch(NoSuchMethodException nsme){
					System.out.println("No Such Method For "+searchDetail.getClass().getName()+" Property:"+searchdetailProperty);
				}catch(Exception ex){
					System.out.println("error getting criteria ");
				}
			}
		}
		return stmt.toString();
	}
}
