package utils;

import java.io.Serializable;
import java.lang.*;
import java.math.BigInteger;
import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public class ControlPanelAttr implements Serializable{
	protected String cssClass;
	protected String key;
	protected String label;
	protected String docMod;
	protected String fieldType;
	protected String fieldAttr1;
	protected String fieldAttr2;
	protected String fieldAttr3;
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDocMod() {
		return docMod;
	}

	public void setDocMod(String docMod) {
		this.docMod = docMod;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldAttr1() {
		return fieldAttr1;
	}

	public void setFieldAttr1(String fieldAttr1) {
		this.fieldAttr1 = fieldAttr1;
	}

	public String getFieldAttr2() {
		return fieldAttr2;
	}

	public void setFieldAttr2(String fieldAttr2) {
		this.fieldAttr2 = fieldAttr2;
	}

	public String getFieldAttr3() {
		return fieldAttr3;
	}

	public void setFieldAttr3(String fieldAttr3) {
		this.fieldAttr3 = fieldAttr3;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
} 
