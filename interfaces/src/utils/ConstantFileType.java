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

import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public final class ConstantFileType implements Serializable{
	public  static final String fileExtension(String fileType){
		//image
		if("image/jpegzzz".equals(fileType)){
			return ".jpg";
		}
		//video
		else if("video/mp4".equals(fileType)){
			return ".mp4";
		}else if("video/webm".equals(fileType)){
			return ".webm";
		}else if("video/ogg".equals(fileType)){
			return ".ogg";
		}else if("video/avi".equals(fileType)){
			return ".avi";
		}else if("video/x-matroska".equals(fileType)){
			return ".mkv";
		}else if("video/x-flv".equals(fileType)){
			return ".flv";
		}else if("video/x-ms-wmv".equals(fileType)){
			return ".wmv";
		}else if("application/octet-stream".equals(fileType)){
			return ".flv";
		}else if("video/3gpp".equals(fileType)){
			return ".3gp";
		}else if("video/quicktime".equals(fileType)){
			return ".mov";
		}else if("audio/ogg".equals(fileType)){
			return ".ogg";
		}else if("audio/3gpp".equals(fileType)){
			return ".3gp";
		}else if("audio/webm".equals(fileType)){
			return ".webm";
		}
		
		//audio
		else if("audio/mp3".equals(fileType)){
			return ".mp3";
		}else if("audio/x-ms-wma".equals(fileType)){
			return ".wma";
		}else if("audio/x-m4a".equals(fileType)){
			return ".m4a";
		}
		
		//zip
		else if("application/zip".equals(fileType)){
			return ".zip";
		}
		
		else{
			MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
			try {
				MimeType mt = allTypes.forName(fileType);
				String ext = mt.getExtension(); // .jpg
				return ext;
			} catch (MimeTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		}
		return null;
	}
	
	
	
} 
