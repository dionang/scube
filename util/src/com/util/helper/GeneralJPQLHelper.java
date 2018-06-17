package com.util.helper;

import utils.Validator;



public final class GeneralJPQLHelper {

	
	public static String FormCriteriaInStatement(String statement, String fieldName, String fieldValue, String logicOperator, String setOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (Validator.isNotNull(fieldValue)) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}
			String[] fieldArray = fieldValue.split("@@");
			String newFieldValue = "";
			if(Validator.isNotNull(fieldArray)){
				for(int i=0; i<fieldArray.length; i++){
					if(i==0){
					newFieldValue = " '"+fieldArray[i]+"' ";
					}else{
					newFieldValue = newFieldValue+ " ,'"+fieldArray[i]+"' ";
					}
				}
			}
			if (setOperator.compareTo("IN") == 0) {
				stmt.append(" "+ logicOperator +" " + fieldName +" IN ("+newFieldValue+") " );
			} 
		}
		return stmt.toString();
	}

	public static String FormCriteriaString(String statement, String fieldName, String fieldValue, String logicOperator, String setOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (Validator.isNotNull(fieldValue)) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}
			if (setOperator.compareTo("=") == 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " = \'" + QuoteMarkFilter(fieldValue) + "\'");
			} else if(setOperator.compareTo("LIKE") == 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " LIKE \'%" + QuoteMarkFilter(fieldValue) + "%\'");
			} else if(setOperator.compareTo("!=") == 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " != \'" + QuoteMarkFilter(fieldValue) + "\'))");
			}
		}
		return stmt.toString();
	}
	public static String FormCriteriaInt(String statement, String fieldName, int fieldValue, String logicOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (fieldValue != 0) {
			if((fieldName.equals("PROD.SERIALISED") || fieldName.equals("SERIALISED") ) && fieldValue == 3)
				fieldValue = 0;
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}
			stmt.append(" " + logicOperator + " " + fieldName + " = \'" + fieldValue + "\'");
		}
		return stmt.toString();
	}

	public static String FormCriteriaIntRange(String statement, String fieldName, int fieldValueMin, int fieldValueMax, String logicOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (fieldValueMin != 0 || fieldValueMax != 0) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}

			stmt.append(" " + logicOperator + " " + fieldName + " BETWEEN " + fieldValueMin + " AND " + fieldValueMax);
		}
		return stmt.toString();
	}

	public static String FormCriteriaDateRange(String statement, String fieldName, java.sql.Timestamp fieldValueMin, java.sql.Timestamp fieldValueMax, String logicOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (fieldValueMin != null || fieldValueMax != null) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}

			if (fieldValueMin != null && fieldValueMax != null) {
				stmt.append(" " + logicOperator + " " + fieldName + " BETWEEN '" + fieldValueMin + "' AND '" + fieldValueMax+"' ");
			}else if (fieldValueMin != null && fieldValueMax == null) {
				stmt.append(" " + logicOperator + " " + fieldName + " >= '" + fieldValueMin+"' " );
			}else if (fieldValueMin == null && fieldValueMax != null) {
				stmt.append(" " + logicOperator + " " + fieldName + " <= '" + fieldValueMax+"' " );
			}
		}
		return stmt.toString();
	}

	public static String FormCriteriaDoubleRange(String statement, String fieldName, double fieldValueMin, double fieldValueMax, String logicOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (fieldValueMin != 0 || fieldValueMax != 0) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}

			if (fieldValueMin != 0 && fieldValueMax != 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " BETWEEN " + fieldValueMin + " AND " + fieldValueMax);
			}else if (fieldValueMin != 0 && fieldValueMax == 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " >= " + fieldValueMin );
			}else if (fieldValueMin == 0 && fieldValueMax != 0) {
				stmt.append(" " + logicOperator + " " + fieldName + " <= " + fieldValueMax );
			}
			
		}
		return stmt.toString();
	}

	public static String FormCriteriaDouble(String statement, String fieldName, java.sql.Timestamp fieldValueMin, java.sql.Timestamp fieldValueMax, String logicOperator) {
		StringBuffer stmt = new StringBuffer("");

		if (fieldValueMin != null || fieldValueMax != null) {
			if (statement.indexOf("WHERE") == -1) {
				logicOperator = "WHERE";
			}
			if (fieldValueMin != null && fieldValueMax != null) {
				stmt.append(" " + logicOperator + " " + fieldName + " BETWEEN " + fieldValueMin + " AND " + fieldValueMax);
			}else if (fieldValueMin != null && fieldValueMax == null) {
				stmt.append(" " + logicOperator + " " + fieldName + " >= " + fieldValueMin );
			}else if (fieldValueMin == null && fieldValueMax != null) {
				stmt.append(" " + logicOperator + " " + fieldName + " <= " + fieldValueMax );
			}
		}
		
		return stmt.toString();
	}

	public static String QuoteMarkFilter(String value) {
		String result = null;

		if (Validator.isNotNull(value)) {
			result = value.replaceAll("\"", "\\\\\"");
			result = result.replaceAll("\'", "\\\\\'");
		}
		return result;
	}

}

