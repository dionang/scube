package utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class DateHelper implements Serializable{
	
	
	public static String howLongAgo(Date start) {
		//HH converts hour in 24 hours format (0-23), day calculation
		Date end = getCurrentTime();
		String returnString="1 second";
		try {
			//in milliseconds
			Long diff = end.getTime() - start.getTime();
			Long diffSeconds = diff / 1000 % 60;
			Long diffMinutes = diff / (60 * 1000) % 60;
			Long diffHours = diff / (60 * 60 * 1000) % 24;
			Long diffDays = diff / (24 * 60 * 60 * 1000);
			Long diffYear = diff / (24 * 60 * 60 * 1000 * 12);
			
			if(diffSeconds >=1){
				if(diffSeconds.intValue()==1){
					returnString = diffSeconds.intValue()+" second";
					}else{
						returnString = diffSeconds.intValue()+" seconds";
					}
			}
			if(diffMinutes >=1){
				if(diffMinutes.intValue()==1){
					returnString = diffMinutes.intValue()+" minute";
					}else{
						returnString = diffMinutes.intValue()+" minutes";
					}
			}
			if(diffHours>=1){
				if(diffHours.intValue()==1){
				returnString = diffHours.intValue()+" hour";
				}else{
					returnString = diffHours.intValue()+" hours";
				}
			}
			if(diffDays >=1){
				if(diffDays.intValue()==1){
					returnString = diffDays.intValue()+" day";
					}else{
						returnString = diffDays.intValue()+" days";
					}
			}
			if(diffYear >=1){
				if(diffYear.intValue()==1){
					returnString = diffYear.intValue()+" year";
					}else{
						returnString = diffYear.intValue()+" years";
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString+" ago";
	}
	
	public static final String dateToString(Date date){
		String dateFormatSyntax="dd-MMM-yyyy hh:mm:ss";
		return dateToString(date,dateFormatSyntax);
	}
	public static final String dateToString(Date date,String dateFormatSyntax){
		if(Validator.isNotNull(date)){
		SimpleDateFormat dateFormat=new SimpleDateFormat(dateFormatSyntax);
		String dateInString=dateFormat.format(date);
		return dateInString;
		}else return null;
	}
	public static final Date stringToDate(String date){
		String dateFormatSyntax="dd-MMM-yyyy hh:mm:ss";
		return stringToDate(date,dateFormatSyntax);
	}
	public static final Date stringToDate(String date,String dateFormatSyntax){
		SimpleDateFormat dateFormat=new SimpleDateFormat(dateFormatSyntax);
		Date dateInString=null;
		try {
			dateInString = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateInString;
	}
	public static Timestamp getCurrentTime(){
//		Calendar currentTime = new GregorianCalendar(TimeZone.getTimeZone("Asia/Singapore"));
//		currentTime.setTimeInMillis(System.currentTimeMillis());
//		long millis = currentTime.getTimeInMillis();
//		Timestamp time = new Timestamp(millis);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
         Date datetime = new Timestamp(System.currentTimeMillis());
         sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
         String gmt8 = sdf.format(datetime);
         Timestamp time = StringToTimeStamp(gmt8,"dd-MMM-yyyy hh:mm:ss");
		return time;
	}
	public static final Timestamp StringToTimeStamp(String date){
		String dateFormatSyntax="dd-MMM-yyyy hh:mm:ss";
		return StringToTimeStamp(date,dateFormatSyntax);
	}
	public static final Timestamp StringToTimeStamp(String date,String dateFormatSyntax){
		if(Validator.isNotNull(date)){
			return dateToTimeStamp(stringToDate(date,dateFormatSyntax));
		}else{
			return null;
		}
	}
	
	public static final Timestamp dateToTimeStamp(Date date){
		if(date!=null)
			return new Timestamp(date.getTime());
		else return null;
	}
	
	/**
	 * @param year
	 *            in YYYY format
	 * @param month
	 *            in MM format - 1 for January, 2 for February etc.
	 * @param day
	 *            in DD format.
	 * @param hour -
	 *            0 to 23
	 * @param minute -
	 *            0 to 59
	 * @return a java.util.Date with the specified time elements
	 */
	public static final java.sql.Timestamp getTimestamp(int year, int month,
			int day, int hour, int minute, int sec) {
		Calendar cal = new GregorianCalendar(year, intToCalendarMonth(month),
				day, hour, minute, sec);
		long millis = cal.getTimeInMillis();
		java.sql.Timestamp time = new java.sql.Timestamp(millis);
		return time;
		// return cal.getTime();
	} // getDate
	
	public static int dayDiff(Date first, Date second){
		long msPerDay = 1000*60*60*24;
		long diff = (first.getTime()/msPerDay)-(second.getTime()/msPerDay);
		Long convertLong = new Long(diff);
		return convertLong.intValue();
	}
	private static int intToCalendarMonth(int month) {

		if (month == 1)
			return Calendar.JANUARY;
		else if (month == 2)
			return Calendar.FEBRUARY;
		else if (month == 3)
			return Calendar.MARCH;
		else if (month == 4)
			return Calendar.APRIL;
		else if (month == 5)
			return Calendar.MAY;
		else if (month == 6)
			return Calendar.JUNE;
		else if (month == 7)
			return Calendar.JULY;
		else if (month == 8)
			return Calendar.AUGUST;
		else if (month == 9)
			return Calendar.SEPTEMBER;
		else if (month == 10)
			return Calendar.OCTOBER;
		else if (month == 11)
			return Calendar.NOVEMBER;
		else if (month == 12)
			return Calendar.DECEMBER;
		else
			return Calendar.JANUARY;

	}
	public static int getYear(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		
		return calc.get(Calendar.YEAR);
	}
	public static int getMonth(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.get(Calendar.MONTH);//start from index 0 to index 11
	}
	public static String getMonthName(int mth){
		DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        String month = "invalid";
        if (mth >= 0 && mth <= 11 ) {
            month = months[mth];
        }
		return month;
	}
	public static int getDay(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getHour(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.get(Calendar.HOUR_OF_DAY);
	}
	public static int getDaily(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.get(Calendar.DAY_OF_WEEK);
	}
	public static int getMin(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.get(Calendar.MINUTE);
	}
	public static final int getMaxNoOfDaysInMonth(Date date){
		Calendar calc = new GregorianCalendar();
		calc.setTime(date);
		return calc.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public static final int getMaxNoOfDaysInMonth(Timestamp date){
		Date dateTime = new Date(date.getTime());
		Calendar calc = new GregorianCalendar();
		calc.setTime(dateTime);
		
		return calc.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public static final int getDays(int day, int month, int year){
		Timestamp date = getTimestamp(year,month,day,0,0,0);
		Date dateTime = new Date(date.getTime());
	//	String dayname = new SimpleDateFormat("EEEE").format(dateTime);//returns String Sunday,Monday,Tuesday etc 
		Calendar calc = Calendar.getInstance();
		calc.set(getYear(dateTime), getMonth(dateTime), getDay(dateTime));
		//return getNamesOfDay(calc.get(Calendar.DAY_OF_WEEK)); // returns int 1=sunday 2=monday untill 7
		return calc.get(Calendar.DAY_OF_WEEK);
	}
	public static String getNamesOfDay(int dayInt){
		String name="";
		if(dayInt ==1){
			name= "Sunday";
		}
		if(dayInt ==2){
			name= "Monday";
		}
		if(dayInt ==3){
			name= "Tuesday";
		}
		if(dayInt ==4){
			name= "Wednesday";
		}
		if(dayInt ==5){
			name= "Thursday";
		}
		if(dayInt ==6){
			name= "Friday";
		}
		if(dayInt ==7){
			name= "Saturday";
		}
		return name;
	}
	public static boolean isEqualOrBefore(Date targetDate,Date thisDate){
		int value=thisDate.compareTo(targetDate);
		if(value==0||value<0){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isEqualOrAfter(Date targetDate,Date thisDate){
		int value=thisDate.compareTo(targetDate);
		if(value==0||value>0){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isBefore(Date targetDate,Date thisDate){
		return thisDate.before(targetDate);
	}
	public static boolean isAfter(Date targetDate,Date thisDate){
		return thisDate.after(targetDate);
	}
	public static Date addDays(Date date,int days){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		
		return cal.getTime();
	}
	public static Date addMonths(Date date,int months){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		
		return cal.getTime();
	}
	public static Date addMins(Date date,int mins){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, mins);
		
		return cal.getTime();
	}

} 
