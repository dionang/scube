package com.util.helper;

import java.io.Serializable;
import java.util.ArrayList;

import utils.Validator;

public class GeneralException extends Exception implements Serializable{
	private ArrayList<ExceptionDetail> errorList=new ArrayList<>();

	public GeneralException(ExceptionDetail exDetail){
		if(Validator.isNotNull(errorList)){
			errorList.add(exDetail);
		}else{
			errorList = new ArrayList<ExceptionDetail>();
			errorList.add(exDetail);
		}
		
	}
	public GeneralException(){}
	
	public GeneralException(ArrayList<ExceptionDetail> errorList){
		this.errorList=errorList;
	}
	public ArrayList<ExceptionDetail> getErrorList() {
		return errorList;
	}
	public void setErrorList(ArrayList<ExceptionDetail> errorList) {
		this.errorList = errorList;
	}
}
