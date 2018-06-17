package utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class SortUtil implements Serializable{
	 
	 /**
    	* The default Locale for our server.
    	*/
   	protected static final Locale locale = Locale.getDefault();
   	
	/**
    	* The message resources for this package.
    	*/
	
	/**
	 *  Gets the order to be sorted
	 *
	 *@param  String  	The current order of the list
	 *@return               A String value of "ASC"/"DSC" representing the order to be sorted next
	 */
	public static final String getSortedOrder(String currOrder) {
		
		String sortedOrder = "ASC";
		
		if(!Validator.isNotNull(currOrder))
			sortedOrder = "ASC";
		else if(currOrder.equals("ASC"))
			sortedOrder = "DSC";
		else if(currOrder.equals("DSC"))
			sortedOrder = "ASC";
		
		return sortedOrder;
	}
	
	/**
	 *  Sort the items (of Date value in java.sql.Timestamp) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByDateInTimestamp(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					java.sql.Timestamp sl1 = null;
					java.sql.Timestamp sl2 = null;
					
					try {
						sl1 = (java.sql.Timestamp) PropertyUtils.getProperty(o1, fieldName);
						sl2 = (java.sql.Timestamp) PropertyUtils.getProperty(o2, fieldName);
					}
					catch(Exception ex) { 
						System.out.println("Error in getting value for " + fieldName); 
					}
					
					return timestampComparison(sl1, sl2, order);
				}
			});
			
			
		}
		
		return listToSort;
	}
	
	public static final ArrayList sortByDate(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					Date sl1 = null;
					Date sl2 = null;
					
					try {
						sl1 = (Date) PropertyUtils.getProperty(o1, fieldName);
						sl2 = (Date) PropertyUtils.getProperty(o2, fieldName);
					}
					catch(Exception ex) { 
						System.out.println("Error in getting value for " + fieldName); 
					}
					
					return dateComparison(sl1, sl2, order);
				}
			});
			
			
		}
		
		return listToSort;
	}
	
	/**
	 *  Sort the items (of String value) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByMultiStringProperty(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					String sl1 = null;
					String sl2 = null;
					
					try {
						sl1 = BeanUtils.getProperty(o1, fieldName);
						sl2 = BeanUtils.getProperty(o2, fieldName);
					}
					catch(Exception ex) { 
						System.out.println("sortByStringValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
					}
					
					return stringComparison(sl1, sl2, order);
				}
			});
		}
		return listToSort;
	};
	
	/**
	 *  Sort the items (of Date value in String) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByDateInStringValue(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					java.sql.Timestamp sl1 = PropertyUtil.getDatePropetyValue(o1, fieldName);
					java.sql.Timestamp sl2 = PropertyUtil.getDatePropetyValue(o2, fieldName);
					
					return timestampComparison(sl1, sl2, order);
				}
			});
			
			
		}
		
		return listToSort;
	}
	
	
	/**
	 *  Sort the items (of String value) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByStringValue(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					String sl1 = null;
					String sl2 = null;
					
					try {
						sl1 = BeanUtils.getProperty(o1, fieldName);
						sl2 = BeanUtils.getProperty(o2, fieldName);
					}
					catch(Exception ex) { 
						System.out.println("sortByStringValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
					}
					
					return stringComparison(sl1, sl2, order);
				}
			});
		}
		return listToSort;
	};
	
	
//	public static final ArrayList sortByMultiObj(ArrayList listToSort,final ArrayList<String> fieldsToSort){
//		
//		final String fieldName = null;
//		
//		
//		
//		final String order = null;
//		
//		if(listToSort != null && listToSort.size() > 0) {
//			Collections.sort(listToSort, new Comparator() {
//				public final int compare(Object o1, Object o2) {
//					
//					String sl1 = null;
//					String sl2 = null;
//					
//					try {
//						sl1 = BeanUtils.getProperty(o1, fieldName);
//						sl2 = BeanUtils.getProperty(o2, fieldName);
//					}
//					catch(Exception ex) { 
//						System.out.println("sortByStringValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
//					}
//					
//					return stringComparison(sl1, sl2, order);
//				}
//			});
//		}
//		return listToSort;
//	};

	public static final ArrayList sortByMultipleParam(ArrayList listToSort, final ArrayList<String> fieldsToSort){
		
		
		
		
//		for(int l=0;l<fieldsToSort.size();l++){
//			String fieldComb = (String)fieldsToSort.get(l);
//			String[] fieldDef=fieldComb.split("\\|");
//			String fieldName=fieldDef[0];
//			String fieldType=fieldDef[1];
//			String order=fieldDef[2];
//			int fsdsd=0;
//			
//		}
		
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				
				
				public final int compare(Object o1, Object o2) {
					if(fieldsToSort!=null && fieldsToSort.size()>0){
						for(String fieldComb:fieldsToSort){
							String[] fieldDef=fieldComb.split("\\|");
							String fieldName=fieldDef[0];
							String fieldType=fieldDef[1];
							String order=fieldDef[2];
							int switchIt=0;
							if(fieldType.equals(CodeHelper.FIELD_STRING)){
								String sl1="";
								String sl2="";
								try {
									sl1 = BeanUtils.getProperty(o1, fieldName);
									sl2 = BeanUtils.getProperty(o2, fieldName);
								}
								catch(Exception ex) { 
									System.out.println("sortByStringValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
								}
								return stringComparison(sl1, sl2, order);
							}else if(fieldType.equals(CodeHelper.FIELD_DOUBLE)){
								double db1=0.0;
								double db2=0.0;
								try {
									db1 = (Double)PropertyUtils.getProperty(o1, fieldName);
									db2 = (Double)PropertyUtils.getProperty(o2, fieldName);
								}
								catch(Exception ex) { 
									System.out.println("sortByDoubleValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
								}
								return doubleComparison(db1, db2, order);
							}else if(fieldType.equals(CodeHelper.FIELD_INT)){
								int int1=0;
								int int2=0;
								try {
									int1 = (Integer)PropertyUtils.getProperty(o1, fieldName);
									int2 = (Integer)PropertyUtils.getProperty(o2, fieldName);
								}catch(Exception ex) { 
									System.out.println("sortByIntegerValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
								}
								return intComparison(int1, int2, order);
							}else if(fieldType.equals(CodeHelper.FIELD_TIMESTAMP)){
								Timestamp tmp1=null;
								Timestamp tmp2=null;
								//timestamp compare
							}
						}
					}
					return 0;
				}
			});
		
		
		
		
		}
		return listToSort;
	};

	/**
	 *  Sort the items (of String value) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByStringValue(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag, int rowsIgnoredTop, int rowsIgnoredBottom){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		int fromIndex = 0; //List will be sorted from this index
		int toIndex = 0; //List will be sorted only until this index
		
		if(listToSort != null && listToSort.size() > 0) {

			//Check if rowsIgnoredTop is positive
			if (rowsIgnoredTop > 0) {
				//Check if rowsIgnoredTop is within range
				if (rowsIgnoredTop < listToSort.size()) {
					//Check if rowsIgnoredTop is less than rowsIgnoredBottom
					if (rowsIgnoredTop < rowsIgnoredBottom)
						fromIndex = rowsIgnoredTop - 1;		
				}
				else 
					if (rowsIgnoredBottom < listToSort.size())
						fromIndex = listToSort.size() - rowsIgnoredBottom - 1; //Make sure that the fromIndex will not be bigger than the toIndex
					else
						fromIndex = listToSort.size() - 1 - 1; //If rowsIgnoredTop is greater than rowsIgnoredBottom, make fromIndex one less than the toIndex
			}
			
			//Check if rowsIgnoredBottom is positive
			if (rowsIgnoredBottom > 0) {
				//Check if rowsIgnoredBottom is within range
				if (rowsIgnoredBottom < listToSort.size())
					toIndex = listToSort.size() - rowsIgnoredBottom - 1 - 1;
				else
					toIndex = listToSort.size() - rowsIgnoredBottom - 1;
			}
			else
				toIndex = fromIndex + 1;
			
			
			Collections.sort(listToSort.subList(fromIndex, toIndex), new Comparator() {
				public final int compare(Object o1, Object o2) {
				
					String sl1 = null;
					String sl2 = null;
				
					try {
						sl1 = BeanUtils.getProperty(o1, fieldName);
						sl2 = BeanUtils.getProperty(o2, fieldName);
					}
					catch(Exception ex) { 
						System.out.println("Error in getting value for " + fieldName); 
					}
				
					return stringComparison(sl1, sl2, order);
				}
			});	
		}
		
		return listToSort;
	};
	@SuppressWarnings("unchecked")
	public static final ArrayList sortByIntValue(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					int sl1 = 0;
					int sl2 = 0;
					
					try {
						sl1 = NumberFormatter.parseInt(BeanUtils.getProperty(o1, fieldName));
						sl2 = NumberFormatter.parseInt(BeanUtils.getProperty(o2, fieldName));
					}
					catch(Exception ex) { 
						System.out.println("sortByIntValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
					}
					
					return intComparison(sl1, sl2, order);
				}
			});
		}
		
		return listToSort;
	};
	/**
	 *  Sort the items (of Integer value) in an arraylist
	 *
	 *@param  listToSort  	The ArrayList to be sorted
	 *@param  fldToSort     The name of the Object(Form)'s field to be sorted
	 *@param  orderToSort   The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByDoubleValue(ArrayList listToSort, String fldToSort, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		if(listToSort != null && listToSort.size() > 0) {
			Collections.sort(listToSort, new Comparator() {
				public final int compare(Object o1, Object o2) {
					
					double sl1 = 0;
					double sl2 = 0;
					String tmp = null;
					
					try {
						tmp = BeanUtils.getProperty(o1, fieldName);
						if (order.equals("ASC") && Validator.isNull(tmp)){						
								tmp = "999999";
						}
						
						sl1 = 0.0;
						
						tmp = BeanUtils.getProperty(o2, fieldName);
						if (order.equals("ASC") && Validator.isNull(tmp)){
								tmp = "999999";
						}
						
						sl2 = 0.0;
					}
					catch(Exception ex) { 
						System.out.println("sortByDoubleValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
					}
					
					return doubleComparison(sl1, sl2, order);
				}
			});
		}
		
		return listToSort;
	};
	
	/**
	 *  Removes the Digit Group Separator (",") for numbers(String type) formatted for display
	 *
	 *@param  String   	The string to format
	 *@return               The sorted ArrayList
	 */
	//digits before or after the decimal mark may be divided into groups using a delimiter(digit group separator)
	private static String removeDigitGroupSeparator(String str){
		if(Validator.isNull(str))return new String("0");
		
		if(str.contains(","))
			str = str.replace(",","");
		
		return str;
	}
	/**
	 *  Sort the items (of String & Number combination value) in an arraylist
	 *
	 *@param  ArrayList  	The ArrayList to be sorted
	 *@param  String     	The name of the Object(Form)'s field to be sorted
	 *@param  int		startIndex to sort
	 *@param  int		endIndex to sort
	 *@param  String   	The sorting order in "ASC"/"DSC" (Ascending/Descending)
	 *@param  boolean   	A flag to indicate whether to sort according(true)/contrast(false) to the sorting order
	 *@return               The sorted ArrayList
	 */
	public static final ArrayList sortByStringNumberValue(ArrayList listToSort, String fldToSort, int startIndex, int endIndex, String orderToSort, boolean flag){
		
		final String fieldName = fldToSort;
		
		if(!flag) orderToSort = getSortedOrder(orderToSort);
		
		final String order = orderToSort;
		
		if(listToSort != null && listToSort.size() > 0) {
			if(startIndex > -1 && endIndex > -1) {
				Object[] listToSortArrays = listToSort.toArray();
				Arrays.sort(listToSortArrays, startIndex, endIndex, new Comparator() {
					public final int compare(Object o1, Object o2) {
						
						String sl1 = null;
						String sl2 = null;
						
						try {
							sl1 = BeanUtils.getProperty(o1, fieldName);
							sl2 = BeanUtils.getProperty(o2, fieldName);
						}
						catch(Exception ex) { 
							System.out.println("sortByStringNumberValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
						}
						
						return stringNumberComparison(sl1, sl2, order);
					}
				});
			}
			else {
				Collections.sort(listToSort, new Comparator() {
					public final int compare(Object o1, Object o2) {
						
						String sl1 = null;
						String sl2 = null;
						
						try {
							sl1 = BeanUtils.getProperty(o1, fieldName);
							sl2 = BeanUtils.getProperty(o2, fieldName);
						}
						catch(Exception ex) { 
							System.out.println("sortByStringNumberValue: Error in getting value for " + fieldName + " Reason: " + ex.toString()); 
						}
						
						return stringNumberComparison(sl1, sl2, order);
					}
				});
			} 
		}
		
		return listToSort;
	};
	private static int dateComparison(Date sl1, Date sl2, String order) {
		
		/*if(sl1 == null && sl2 == null)
			return 0;
		else if(sl1 == null && sl2 != null) {
			if(order.equals("ASC"))
				return -1;
			else if(order.equals("DSC"))
				return 1;
		}
		else if(sl1 != null && sl2 == null) {
			if(order.equals("ASC"))
				return 1;
			else if(order.equals("DSC"))
				return -1;
		}
		else {
			if(order.equals("ASC"))
				return sl1.compareTo(sl2);
			else if(order.equals("DSC"))
				return sl2.compareTo(sl1);
		}*/
		
		if(order.equals("ASC")) {
			if(sl1 == null && sl2 == null)
				return 0;
			else if(sl1 == null && sl2 != null) {
				return 1;
			}
			else if(sl1 != null && sl2 == null) {
				return -1;
			}
			return sl1.compareTo(sl2);
			
		}
		else if(order.equals("DSC")) {
			if(sl1 == null && sl2 == null)
				return 0;
			else if (sl1 != null && sl2 != null)
				return sl2.compareTo(sl1);
		}
		return 0;
	}
	
	private static int timestampComparison(java.sql.Timestamp sl1, java.sql.Timestamp sl2, String order) {
		
		/*if(sl1 == null && sl2 == null)
			return 0;
		else if(sl1 == null && sl2 != null) {
			if(order.equals("ASC"))
				return -1;
			else if(order.equals("DSC"))
				return 1;
		}
		else if(sl1 != null && sl2 == null) {
			if(order.equals("ASC"))
				return 1;
			else if(order.equals("DSC"))
				return -1;
		}
		else {
			if(order.equals("ASC"))
				return sl1.compareTo(sl2);
			else if(order.equals("DSC"))
				return sl2.compareTo(sl1);
		}*/
		
		if(order.equals("ASC")) {
			if(sl1 == null && sl2 == null)
				return 0;
			else if(sl1 == null && sl2 != null) {
				return 1;
			}
			else if(sl1 != null && sl2 == null) {
				return -1;
			}
			return sl1.compareTo(sl2);
			
		}
		else if(order.equals("DSC")) {
			if(sl1 == null && sl2 == null)
				return 0;
			else if (sl1 != null && sl2 != null)
				return sl2.compareTo(sl1);
		}
		return 0;
	}
	
//	private static int objectComparison(Object obj1, Object obj2, )
	
	private static int stringComparison(String sl1, String sl2, String order) {
		
		if(sl1 == null) sl1 = "";
		if(sl2 == null) sl2 = "";
		
		sl1 = sl1.toString().toUpperCase();
		sl2 = sl2.toString().toUpperCase();
		
		if(order.equals("ASC")) {
			if(sl1.equals("") && !sl2.equals("")) {
				return 1;
			}
			else if(!sl1.equals("") && sl2.equals("")) {
				return -1;
			}
			return sl1.compareTo(sl2);
			
		}
		else if(order.equals("DSC")) {
			return sl2.compareTo(sl1);
		}
		
		return 0;
	}
	
	private static int doubleComparison(double sl1, double sl2, String order) {
		
		if (sl1 < sl2) {
			if("ASC".equals(order))
				return -1;
			else if("DSC".equals(order))
				return 1;
		}
		else if (sl1 > sl2){
			if("ASC".equals(order))
				return 1;
			else if("DSC".equals(order))
				return -1;
		}
		
		//else if same
		return 0;
	}
	
	private static int intComparison(int sl1, int sl2, String order) {
		
		
		if (sl1 > sl2){
			if("ASC".equals(order))
				return 1;
			else if("DSC".equals(order))
				return -1;
			else		
				return 1;
		}else if (sl1 < sl2) {
			if("ASC".equals(order))
				return -1;
			else if("DSC".equals(order))
				return 1;
			else
				return -1;
		}
		
		//else if same
		return 0;
	}
	
	private static int longComparison(long sl1, long sl2, String order) {
		
		if (sl1 < sl2) {
			if(order.equals("ASC"))
				return -1;
			else if(order.equals("DSC"))
				return 1;
		}
		else if (sl1 > sl2){
			if(order.equals("ASC"))
				return 1;
			else if(order.equals("DSC"))
				return -1;
		}
		else {
			int in = 0;
			if (sl1 == sl2)
				in = 0;
			return in;
		}
		
		return 0;
	}
	
	private static int stringNumberComparison(String sl1, String sl2, String order) {
		
		if(sl1 == null) sl1 = "";
		if(sl2 == null) sl2 = "";
		
		sl1 = sl1.toString().toUpperCase();
		sl2 = sl2.toString().toUpperCase();
		
		int ind1 = containsNumber(sl1.toString());
		int ind2 = containsNumber(sl2.toString());
		
		if(ind1 > -1 && ind2 > -1){
			
			String str1 = sl1.substring(0, ind1);
			long num1 = Long.parseLong(sl1.substring(ind1));
			
			String str2 = sl2.substring(0, ind2);
			long num2 = Long.parseLong(sl2.substring(ind2));
			
			int diff = stringComparison(str1, str2, order);
			
			if(diff == 0) return longComparison(num1, num2, order);
			else return diff;
		}
		
		return stringComparison(sl1, sl2, order);
	}
	
	
	// for use in stringNumberComparison
	// to check if this string contains any numbers
	// long can take in 19 digits
	private static int containsNumber(String chk){
		
		// stores the index to do substring to get string and number value
		int numIndex = -1;
		  
		for(int i=0; i<chk.length(); i++){
			  
			char c = chk.charAt(i);
			  
			try{
				Integer.parseInt(""+c);
				String str = chk.substring(i);
				long num = Long.parseLong(str);
				numIndex = i;
				break;
			}
			catch(Exception e){}
		}
		  
		return numIndex;
	}
} 
