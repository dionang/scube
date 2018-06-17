package utils;

import java.io.Serializable;
import java.lang.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.STRING;

import org.apache.commons.beanutils.PropertyUtils;

import action.Form;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class ItemPopulateHelper implements Serializable{
	public boolean debug=false;
	public ItemPopulateHelper(){
		
	}
	public ItemPopulateHelper(boolean debug){
		setDebug(debug);
	}
	public ArrayList<String> splitString(String value,String seperator){
		ArrayList<String> returnList=new ArrayList<>();
		if(Validator.isNotNull(value)&&Validator.isNotNull(seperator)){
			String valueClone=value;
			int sl=seperator.length();
			while(valueClone.contains(seperator)){
				int cutPotion=valueClone.indexOf(seperator);
				String extractValue=valueClone.substring(0,cutPotion);
				returnList.add(extractValue);
				int extractValueLenght=extractValue.length();
				valueClone=valueClone.substring(extractValueLenght+sl,valueClone.length());
			}
		}
		return returnList;
	}
	public void populateContentAttrListHelper(Object target,String configAttrString){
		populateContentAttrListHelper(target, configAttrString, "@", "|") ;
	}
	public void populateContentAttrListHelper(Object target,String configAttrString,String keyValueSeperator,String endSeperator){
		if(Validator.isNotNull(configAttrString)&&Validator.isNotNull(target)&&Validator.isNotNull(keyValueSeperator)&&Validator.isNotNull(endSeperator)){
			if(configAttrString.contains(endSeperator)){
				String[] configAttrStringA=configAttrString.split("\\"+endSeperator);
				if(configAttrStringA.length>0){
					for(int i=0; i<configAttrStringA.length; i++){
						String configAttrStringSet=configAttrStringA[i];
						if(configAttrStringSet.contains(keyValueSeperator)){
							String[] configAttrStringSetA=configAttrStringSet.split("\\"+keyValueSeperator);
							if(configAttrStringSetA.length>1){
								String attr=configAttrStringSetA[0];
								String attrValue=configAttrStringSetA[1];
								try{
									String propertyType=PropertyUtils.getPropertyType(target,attr).getName();
									if("java.lang.String".equals(propertyType)){
										PropertyUtils.setProperty(target, attr, attrValue);
									}else if("int".equals(propertyType)){
										PropertyUtils.setProperty(target, attr, NumberFormatter.parseInt(attrValue));
									}else if("double".equals(propertyType)){
										PropertyUtils.setProperty(target, attr, NumberFormatter.parseDouble(attrValue));
									}else if("boolean".equals(propertyType)){
										PropertyUtils.setProperty(target, attr,Boolean.parseBoolean(attrValue));
									}else{
										PropertyUtils.setProperty(target, attr, attrValue);
									}
									
								}catch (Exception e) {
									if(debug){
										System.out.println("Error in setting attrValue in method populateContentAttrListHelper()");
										System.out.println("Souce: "+target.toString());
										System.out.println("configAttrString: "+configAttrString);
										System.out.println("keyValueSeperator: "+keyValueSeperator);
										System.out.println("endSeperator: "+endSeperator);
										System.out.println("Setting attr: "+attr);
										System.out.println("Setting attrValue: "+attrValue);
									}
								}
							}
						}
					}
				}
				
			}
		}
		
	}
	public String getContentAttrValueListHelper(String key,String configAttrString){
		return getContentAttrValueListHelper(key,configAttrString, "@", "|") ;
	}
	public String getContentAttrValueListHelper(String key,String configAttrString,String keyValueSeperator,String endSeperator){
		if(Validator.isNotNull(configAttrString)&&Validator.isNotNull(key)&&Validator.isNotNull(keyValueSeperator)&&Validator.isNotNull(endSeperator)){
			if(configAttrString.contains(endSeperator)){
				String[] configAttrStringA=configAttrString.split("\\"+endSeperator);
				if(configAttrStringA.length>0){
					for(int i=0; i<configAttrStringA.length; i++){
						String configAttrStringSet=configAttrStringA[i];
						if(configAttrStringSet.contains(keyValueSeperator)){
							String[] configAttrStringSetA=configAttrStringSet.split("\\"+keyValueSeperator);
							if(configAttrStringSetA.length>1){
								String attr=configAttrStringSetA[0];
								String attrValue=configAttrStringSetA[1];
								if(key.equals(attr)){
									return attrValue;
								}
							}
						}
					}
				}
				
			}
		}
		return null;
	}
	public void populateContentAttrHelper(Object af,String propertyName, String value){
		if(Validator.isNotNull(af)&&Validator.isNotNull(propertyName)&&Validator.isNotNull(value)){
			try{
				String propertyType=PropertyUtils.getPropertyType(af, propertyName).getName();
				if("java.lang.String".equals(propertyType)){
					PropertyUtils.setProperty(af, propertyName, value);
				}else if("int".equals(propertyType)){
					PropertyUtils.setProperty(af, propertyName, NumberFormatter.parseInt(value));
				}else if("double".equals(propertyType)){
					PropertyUtils.setProperty(af, propertyName, NumberFormatter.parseDouble(value));
				}else if("boolean".equals(propertyType)){
					PropertyUtils.setProperty(af, propertyName,Boolean.parseBoolean(value));
				}else{
					PropertyUtils.setProperty(af, propertyName, value);
				}
			}catch (Exception e) {
				if(debug){
					System.out.println("FAILED! Populate Content Attribute Name:"+propertyName+" value:"+value);
				}
			}
		}
	}
	public String contentAttrHelper(Object af,String propertyName){
		return contentAttrHelper(af, propertyName,"@","|");
	}
	public String contentAttrHelper(Object af,String propertyName,String keyValueSeperator,String endSeperator){
		String contentAttrsConfigString="";
		 
		if(Validator.isNotNull(af)&&Validator.isNotNull(propertyName)){
			try{
				Object value=PropertyUtils.getProperty(af, propertyName);
				contentAttrsConfigString+=propertyName+keyValueSeperator+value+endSeperator;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return contentAttrsConfigString;
	}
	public ArrayList removeEmptyRow(ArrayList list){
		if(Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				boolean empty=true;
				try{
					empty=(boolean)PropertyUtils.getProperty(row, "empty");
				}catch (Exception e) {
				}
				if(empty){
					list.remove(i);
					i--;
				}
			}
		}
		return list;
	}
	public ArrayList addEmptyRow(ArrayList list, Object newRow, int noOfRow,int nextItemId){
		return addEmptyRow(list, newRow, noOfRow,null, nextItemId);
		
	}
	public ArrayList addEmptyRow(ArrayList list, Object newRow, int noOfRow, HashMap<String, Object> defaultValueMap,int nextItemId){
		if(Validator.isNull(list)){
			list=new ArrayList();
		}
	//	int nextItemId=getNextItemId(list);
			
		
		int itemNo=list.size()+1;
		for(int i=0; i<noOfRow; i++){
			Object addRow=new Object();
			try{
				addRow=Class.forName(newRow.getClass().getName()).newInstance();
			}catch (Exception e) {
			}
			try{
				PropertyUtils.setProperty(addRow, "itemNo", itemNo+"");
				itemNo++;
			}catch (Exception e) {
			}
			try{
				PropertyUtils.setProperty(addRow, "itemId", nextItemId);
				nextItemId++;
			}catch (Exception e) {
			}
			if(defaultValueMap!=null){
				Iterator it = defaultValueMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					String propertyName=(String)entry.getKey();
					Object propertyValue=entry.getValue();
					if("cloneArrayListMap".equals(propertyName)){
						HashMap<String, Object> cloneArrayListMap=(HashMap<String, Object>)propertyValue;
						Iterator it2 = cloneArrayListMap.entrySet().iterator();
						ItemPopulateHelper iph=new ItemPopulateHelper();
						while (it2.hasNext()) {
							Map.Entry entry2 = (Map.Entry) it2.next();
							String propertyName2=(String)entry2.getKey();
							ArrayList propertyValue2=(ArrayList)entry2.getValue();
							ArrayList cloneList=iph.arrayListClone(propertyValue2);
							try{
								PropertyUtils.setProperty(addRow, propertyName2, cloneList);
							}catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}else{
						
						try{
							PropertyUtils.setProperty(addRow, propertyName, propertyValue);
						}catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
				}
			}
			list.add(addRow);
		}
		return list;
	}
	public Object objectClone(Object objectSrc){
		try{
			Object objectDesc=Class.forName(objectSrc.getClass().getName()).newInstance();
			PropertyUtils.copyProperties(objectDesc,objectSrc);
			return objectDesc;
		}catch (Exception e) {
			return null;
		}
	}
	public ArrayList arrayListClone(ArrayList srcList){
		ArrayList descList=new ArrayList<>();
		if(Validator.isNotNull(srcList)){
			for(int i=0; i<srcList.size(); i++){
				Object srcRow=srcList.get(i);
				Object descRow=new Object();
				try{
					descRow=Class.forName(srcRow.getClass().getName()).newInstance();
					PropertyUtils.copyProperties(descRow, srcRow);
					Class.forName(srcRow.getClass().getName()).newInstance();
				}catch (Exception e) {
				}
				descList.add(descRow);
			}
		}
		
		return descList;
	}
	public void populateSelectedItemToList(ArrayList list, String[] selected, String checkProperty,String setProperty, Boolean setValue){
		Boolean defaultValue=false;
		if(!setValue)
			defaultValue=true;
		if(Validator.isNotNull(list)&& Validator.isNotNull(selected)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				String compareV=null;
				try{
					PropertyUtils.setProperty(row, setProperty, defaultValue);
					compareV=(String)PropertyUtils.getProperty(row, checkProperty);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if(Validator.isNotNull(selected)){
					for(int s=0; s<selected.length; s++){
						String selectedV=selected[s];
						if(Validator.isNotNull(selectedV)&&selectedV.equals(compareV)){
							try{
								PropertyUtils.setProperty(row, setProperty, setValue);
							}catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}
				}
				
			}
			
		}
		
	}
	
	public String[] populateListToSelectedArray(ArrayList list, String[] selected, String checkProperty){
		if(Validator.isNotNull(list)){
			selected=new String[list.size()];
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				String selectedArrayValue=null;
				try{
					selectedArrayValue=(String)PropertyUtils.getProperty(row, checkProperty);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				selected[i]=selectedArrayValue;
			}
		}
		return selected;
	}
	public Object getSelectedRow(String selectedValue,ArrayList list, String checkProperty){
		if(Validator.isNotNull(selectedValue)&&Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					String value=(String)PropertyUtils.getProperty(row, checkProperty);
					if(selectedValue.equals(value)){
						return row;
					}
				}catch (Exception e) {
				}
			}
		}
		return null;
	}
	public int getNextItemIdNew(ArrayList list){
		int count=0;
		if(Validator.isNull(list)){
			return 1;
		}else{
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					int itemId=(Integer)PropertyUtils.getProperty(row, "itemId");
					if(itemId>count)
						count=itemId;
				}catch (Exception e) {
					return 0;
				}
			}
		}
		return count+1;
	}
	public void reWriteItemNo(ArrayList list){
		if(Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					String itemNo=(i+1)+"";
					PropertyUtils.setProperty(row, "itemNo", itemNo);
				}catch (Exception e) {
					int itemNo=(i+1);
					try {
						PropertyUtils.setProperty(row, "itemNo", itemNo);
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	public void repopulateItemNo(ArrayList list){
		list=SortUtil.sortByIntValue(list, "itemNo", "ASC", true);
		if(Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					String itemNo=(i+1)+"";
					PropertyUtils.setProperty(row, "itemNo", itemNo);
				}catch (Exception e) {
					int itemNo=(i+1);
					try {
						PropertyUtils.setProperty(row, "itemNo", itemNo);
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	public void repopulateNo(ArrayList list,String fieldName){
		repopulateNo(list, fieldName,"ASC");
	}
	public void repopulateNo(ArrayList list,String fieldName,String orderToSort){
		list=SortUtil.sortByIntValue(list, fieldName, "ASC", true);
		if(Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					String itemNo=(i+1)+"";
					PropertyUtils.setProperty(row, fieldName, itemNo);
				}catch (Exception e) {
					int itemNo=(i+1);
					try {
						PropertyUtils.setProperty(row, fieldName, itemNo);
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if("DSC".equals(orderToSort)){
			list=SortUtil.sortByIntValue(list, fieldName, "DSC", true);
		}
		
	}
	public int getNextRunningNo(ArrayList list, String runningField){
		int returnValue=0;
		if(Validator.isNotNull(list)){
			for(int i=0; i<list.size(); i++){
				Object row=list.get(i);
				try{
					Object value=PropertyUtils.getProperty(row, runningField);
					int thisValue=0;
					if(value instanceof String){
						String valueString=(String)value;
						thisValue=NumberFormatter.parseInt(valueString);
					}else if(value instanceof Integer){
						thisValue=(int)value;
					}
					if(thisValue>returnValue){
						returnValue=thisValue;
					}
				}catch (Exception e) {
				}
			}
		}
		return returnValue+1;
	}
	
	public boolean checkSelectOptionExist(ArrayList<SelectOption> soList,String checkValue){
		boolean found=false;
		
		if(Validator.isNotNull(soList)&&Validator.isNotNull(checkValue)){
			for(int i=0; i<soList.size(); i++){
				SelectOption so=soList.get(i);
				String value=so.getValue();
				if(checkValue.equals(value)){
					found=true;
					break;
				}
			}
		}
		
		return found;
	}
	
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
} 
