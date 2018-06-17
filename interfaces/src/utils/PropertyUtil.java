package utils;

import java.io.Serializable;
import java.lang.*;
import java.math.BigInteger;
import java.util.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class PropertyUtil implements Serializable{
	// retrieve the date field value in java.sql.Timestamp from Form object
	public static final java.sql.Timestamp getDatePropetyValue(Object formObj, String propertyName) {
		
		java.sql.Timestamp date = null;
		
		String date_yr = null;
		String date_mth = null;
		String date_day = null;
		String date_hr = null;
		String date_min = null;
		String date_sec = null;
		
		try {
			date_yr = BeanUtils.getProperty(formObj, propertyName+"Yr");
			date_mth = BeanUtils.getProperty(formObj, propertyName+"Mth");
			date_day = BeanUtils.getProperty(formObj, propertyName+"Day");
			date_hr = BeanUtils.getProperty(formObj, propertyName+"Hr");
			date_min = BeanUtils.getProperty(formObj, propertyName+"Min");
			date_sec = BeanUtils.getProperty(formObj, propertyName+"Sec");
		}
		catch(Exception ex) {
			if(!Validator.isNotNull(date_hr)) date_hr = "0";
			if(!Validator.isNotNull(date_min)) date_min = "0";
			if(!Validator.isNotNull(date_sec)) date_sec = "0";
		}
		
		if (Validator.isNotNull(date_yr) && Validator.isNotNull(date_mth) && Validator.isNotNull(date_day)) {
			if(!Validator.isNotNull(date_hr)) date_hr = "0";
			if(!Validator.isNotNull(date_min)) date_min = "0";
			if(!Validator.isNotNull(date_sec)) date_sec = "0";
			
			date = DateHelper.getTimestamp(Integer.parseInt(date_yr), Integer.parseInt(date_mth),
							Integer.parseInt(date_day), Integer.parseInt(date_hr),										
							Integer.parseInt(date_min), Integer.parseInt(date_sec));
		}
		
		return date;
	}
} 
