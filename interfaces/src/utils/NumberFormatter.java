package utils;

import java.lang.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.math.BigDecimal;
//WY 9-2-07
import java.math.*;
import java.util.*;




/**
 *  This class contains helper methods to conform double into specific format
 *
 *@author     PKTAN
*/

public final class NumberFormatter {
	public static final Integer parseInt(String number){
		int returnValue=0;
		if(Validator.isNotNull(number)){
			try{
				number=number.trim();
				returnValue=Integer.parseInt(number);
			}catch (Exception e) {
			}
		}
		return returnValue;
	}
	public static final Double parseDouble(String number){
		double returnValue=0;
		if(Validator.isNotNull(number)){
			try{
				returnValue=Double.parseDouble(number);
			}catch (Exception e) {
			}
		}
		return returnValue;
	}
	public static final Integer divideRoundUp(Double value1,Double value2){
		return (int)Math.ceil(value1/value2);
	}
	public static final Integer roundUp(Double value1){
		return (int)Math.ceil(value1/1.0);
	}
	public static final Integer roundDown(Double value1){
		return (int)Math.floor(value1);
	}
}
