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

public final class CodeHelper implements Serializable{

	public static final String HTTP_PORT=":8080";
	//-------------------------------------FIELD TYPE------------------------------------------------------------------//
	public static final String FIELD_STRING="STR";
	public static final String FIELD_DOUBLE="DBL";
	public static final String FIELD_INT="INT";
	public static final String FIELD_TIMESTAMP="TMP";
	
	//-------------------------------------STATUS------------------------------------------------------------------//
	public static final String STATUS_ACTIVE="ac";
	public static final String STATUS_INACTIVE="ia";
	public static final String STATUS_NEW="nw";
	public static final String STATUS_DRAFT="dr";
	public static final String STATUS_CONFIRMED="co";
	public static final String STATUS_ISSUE="is";
	public static final String STATUS_REDEEMED="rd";
	public static final String STATUS_AVAILABLE_FOR_REDEMPTION="avr";
	public static final String STATUS_EXPIRED="ex";
	public static final String STATUS_SUBMITTED="sm";
	public static final String STATUS_APPROVED="ap";
	public static final String STATUS_SHORT_LISTED="sl";
	public static final String STATUS_PENDING="pe";
	public static final String STATUS_COMPLETED="cp";
	public static final String STATUS_CANCELLED="cn";
	public static final String STATUS_ENDED="en";
	public static final String STATUS_WAITING_FOR_OFFER="pdo";
	public static final String STATUS_OFFERED="ofd";
	public static final String STATUS_REFUNDED="rfd";
	public static final String STATUS_REQUEST_REDEEM="rqr";
	public static final String STATUS_OFFER_ACCEPTED="oap";
	public static final String STATUS_OFFER_REJECTED="orj";
	public static final String STATUS_DOC_REQ="drq";
	public static final String DOC_TYPE_EVENT_LOG="elm";
	public static final String DOC_TYPE_PRODUCT="pdt";
	public static final String DOC_TYPE_RFQ="rfq";
	public static final String DOC_TYPE_INVOICE="inv";
	public static final String DOC_TYPE_CREDIT_NOTE="cn";
	public static final String DOC_TYPE_ACCESS_PROFILE="acp";
	public static final String DOC_TYPE_MENU_REORG="muReorg";
	public static final String DOC_TYPE_PROFIT_CENTER="pfc";
	public static final String DOC_TYPE_ADDRESS_BOOK="addr";
	public static final String DOC_TYPE_QR_CODE="qr";
	public static final String DOC_TYPE_CREDITOR_ACCT="ca";
	public static final String DOC_TYPE_DEBTOR_ACCT="da";
	public static final String DOC_TYPE_COMPANY="cpny";
	public static final String DOC_TYPE_LAYOUT="layout";
	public static final String DOC_TYPE_DS="ds";
	public static final String DOC_TYPE_TIME_FRAME="tf";
	public static final String DOC_TYPE_NESTED_SLOTS="nestedSlots";
	public static final String DOC_TYPE_DS_ADV="dsAdv";
	public static final String DOC_TYPE_PARAGRAPH="para";
	public static final String DOC_TYPE_IMAGE="img";
	public static final String DOC_TYPE_VIDEO="vid";
	public static final String DOC_TYPE_EXCEL="excel";
	
	public static final String DOC_TYPE_EFILE="efile";
	public static final String DOC_TYPE_EDIRECTORY="edir";
	public static final String DOC_TYPE_EXTERNAL_DB="xdb";
	public static final String DOC_TYPE_MAP="map";
	public static final String DOC_TYPE_DOC_ID_GEN="idGen";
	
} 
