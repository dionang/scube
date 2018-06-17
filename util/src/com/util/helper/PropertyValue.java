package com.util.helper;

import java.io.Serializable;

public class PropertyValue implements Serializable{
	boolean inheritValue=false;
	private String inheritPropertyName;
	private String propertyName;
	private Object value;
	private String queryOperator;
	public PropertyValue(boolean inheritValue, String inheritPropertyName, String propertyName, Object value, String queryOperator){
		this.inheritValue=inheritValue;
		this.inheritPropertyName=inheritPropertyName;
		this.propertyName=propertyName;
		this.value=value;
		this.queryOperator=queryOperator;
	}
	public boolean isInheritValue() {
		return inheritValue;
	}
	public void setInheritValue(boolean inheritValue) {
		this.inheritValue = inheritValue;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getInheritPropertyName() {
		return inheritPropertyName;
	}
	public void setInheritPropertyName(String inheritPropertyName) {
		this.inheritPropertyName = inheritPropertyName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getQueryOperator() {
		return queryOperator;
	}
	public void setQueryOperator(String queryOperator) {
		this.queryOperator = queryOperator;
	}
}
