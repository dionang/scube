package com.util.helper;

import java.io.Serializable;
import java.util.HashMap;

public class ExceptionDetail implements Serializable {
	private String errorCode;
	private HashMap errorMap;
	private String fieldName;
	private String error;
	public ExceptionDetail(String errorCode, HashMap errorMap, String fieldName){
		this.errorCode=errorCode;
		this.errorMap=errorMap;
		this.fieldName=fieldName;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public HashMap getErrorMap() {
		return errorMap;
	}
	public void setErrorMap(HashMap errorMap) {
		this.errorMap = errorMap;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
