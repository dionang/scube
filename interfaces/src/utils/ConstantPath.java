package utils;

import java.io.File;
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

public final class ConstantPath implements Serializable{
	//--namespace
	public  static final String nameSpace(String docType){
		//setup
		if("acp".equals(docType)){
			return "/setup/accessProfile/";
		}else if("muReorg".equals(docType)){
			return "/setup/menu/";
		}else if("cpny".equals(docType)){
			return "/setup/subscriber/";
		}else if("usr".equals(docType)){
			return "/setup/user/";
		}else if("pfc".equals(docType)){
			return "/setup/pfc/";
		}else if("addr".equals(docType)){
			return "/setup/address/";
		}else if("qr".equals(docType)){
			return "/setup/qrCode/";
		}
		
		//finance
		else if("inv".equals(docType)){
			return "/finance/invoice/";
		}else if("ca".equals(docType)){
			return "/finance/creditor/";
		}else if("da".equals(docType)){
			return "/finance/debtor/";
		}
		//product
		else if("pdt".equals(docType)){
			return "/product/product/";
		}
		
		//ds
		else if("layout".equals(docType)){
			return "/ds/layout/";
		}else if("ds".equals(docType)){
			return "/ds/digitalSignage/";
		}else if("tf".equals(docType)){
			return "/ds/timeFrame/";
		}else if("dsAdv".equals(docType)){
			return "/ds/digitalSignageAdvertisementReport/";
		}
	
		//efile
		else if("para".equals(docType)){
			return "/efile/paragraph/";
		}else if("img".equals(docType)){
			return "/efile/image/";
		}else if("pdf".equals(docType)){
			return "/efile/pdf/";
		}else if("efile".equals(docType)){
			return "/efile/efile/";
		}else if("vid".equals(docType)){
			return "/efile/video/";
		}else if("aud".equals(docType)){
			return "/efile/audio/";
		}else if("excel".equals(docType)){
			return "/efile/excel/";
		}else if("eCat".equals(docType)){
			return "/efile/eCat/";
		}
		
		//edirectory
		else if("edir".equals(docType)){
			return "/edir/edir/";
		}
		
		//remote
		else if("xdb".equals(docType)){
			return "/remote/externalDatabase/";
		}else if("rtsp".equals(docType)){
			return "/remote/rtsp/";
		}
		
		//svg
		else if("map".equals(docType)){
			return "/svg/map/";
		}else if("svg".equals(docType)){
			return "/svg/";
		}
		return null;
	}
	
	public  static final String envDocumentRoot(String env,String cid){
		if("windows".equals(env)){
			String mainDir="C:/public/";
			//new File(mainDir+cid+"/flat/tmp/").mkdirs();
			return mainDir;
		}else if("cloud".equals(env)){
			String mainDir="C:/Program Files (x86)/Apache Group/Apache2/htdocs/";
			//new File(mainDir+cid+"/flat/tmp/").mkdirs();
			return mainDir;
		}else{
			String mainDir="/var/www/html/";
			//new File(mainDir+cid+"/flat/tmp/").mkdirs();
			return mainDir;
		}
	}
	public  static final String envDocumentRootNew(String env){
		if("windows".equals(env)){
			return "C:/public/";
		}else if("mac".equals(env)) {
			return "/Applications/MAMP/htdocs/";
		}else{
			return "/var/www/html/";
		}
	}
	public  static final String apachePort(){
		return "80";
	}
} 
