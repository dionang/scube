package utils;

import java.io.Serializable;
import java.lang.*;
import java.math.BigInteger;
import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.HashSet;
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

public final class SessionClear implements Serializable{
	
	public static final void erpClear(Map<String, Object> userSession) {
		if(userSession.containsKey("erpSessionAttributeNameList")){
			HashSet<String> attributesNameSet=(HashSet)userSession.get("erpSessionAttributeNameList");
			ArrayList<String> attributesNameList=new ArrayList<>(attributesNameSet);
			if(Validator.isNotNull(attributesNameList)){
				for(int i=0; i<attributesNameList.size(); i++){
					try{
						userSession.remove(attributesNameList.get(i));
					}catch (Exception e) {
					}
				}
			}
			userSession.remove("erpSessionAttributeNameList");
		}
		
	}
} 
