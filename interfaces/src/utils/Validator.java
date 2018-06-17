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

import org.hibernate.collection.internal.PersistentBag;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class Validator implements Serializable{
	public static final void lameCheck(ArrayList list) {
		String abc="daf";
		String ac="adfa";
		
	}
	public static final void lameCheck(Object list) {
		String abc="daf";
		String ac="adfa";
		
	}
	public static final boolean isNotNull(Object object) {
		if(object==null){
			return false;
		}else{
			return true;
		}
	}
	public static final boolean isNull(Object object) {
		if(object==null){
			return true;
		}else{
			return false;
		}
	}
 
	public static final boolean isNotNull(Double value) {
		if(value==null||value==0){
			return false;
		}else{
			return true;
		}
	}
	public static final boolean isNull(Double value) {
		if(value==null||value==0){
			return true;
		}else{
			return false;
		}
	}
	public static final boolean isNotNull(String[] str) {
		if ((str != null) && (str.length > 0)){
			return true;
		}else{
			return false;
		}
	}
	public static final boolean isNull(String[] str) {
		if ((str != null) && (str.length > 0)){
			return false;
		}else{
			return true;
		}
	}
	

	
	
	public static final boolean isNotNull(String str) {
		if ((str != null) && (str.length() > 0) &&!"null".equals(str) ){
			return true;
		}else{
			return false;
		}
	}
	public static final boolean isNull(String str) {
		if ((str != null) && (str.length() > 0) && !"null".equals(str)){
			return false;
		}else{
			return true;
		}
	}
	public static final boolean isNotNull(PersistentBag bag) {
		if ((bag != null) && (!bag.isEmpty())){
			return true;
		}else{
			return false;
		}
	}
	public static final boolean isNull(PersistentBag bag) {
		if ((bag != null) && (!bag.isEmpty())){
			return false;
		}else{
			return true;
		}
	}
	public static final boolean isNotNull(List list) {
		try{
		if ((list != null) && (list.size() > 0)){
			return true;
		}else{
			return false;
		}
		}catch (Exception e) {
			PersistentBag bag=(PersistentBag)list;
			return isNotNull(bag);
		}
	}
	public static final boolean isNull(List list) {
		try{
		if ((list != null) && (list.size() > 0)){
			return false;
		}else{
			return true;
		}
		}catch (Exception e) {
			PersistentBag bag=(PersistentBag)list;
			return isNull(bag);
		}
	}
	public static final boolean isNotNull(ArrayList list) {
		if ((list != null) && (list.size() > 0)){
			return true;
		}else{
			return false;
		}
	}
	public static final boolean isNull(ArrayList list) {
		if ((list != null) && (list.size() > 0)){
			return false;
		}else{
			return true;
		}
	}

	
} 
