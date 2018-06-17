package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionSupport;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/


public final class PropHelper  extends ActionSupport implements Serializable{
	String setPath="setup.package";
	String dsPath="ds.package";
	String efilePath="efile.package";
	String edirPath="edir.package";
	String remotePath="remote.package";
	String svgPath="svg.package";
	public String getMod(String docType){
		ResourceBundle rc=getTexts("ApplicationResources");
		if(Validator.isNotNull(rc)&&Validator.isNotNull(docType)&&rc.containsKey(docType+".mod")){
			return rc.getString(docType+".mod");
		}
		
		/*
		Enumeration<String>keyList=documentBundle.getKeys();
		ArrayList<DocumentForm> defaultDocListSrc=new ArrayList<DocumentForm>();
		if(keyList!=null&&keyList.hasMoreElements()&&Validator.isNotNull(docType)){
			while(keyList.hasMoreElements()){
				String key=keyList.nextElement();
				if(Validator.isNotNull(key)&&key.startsWith("docType.")){
					String thisDocType=key.substring(8);
					if(docType.equals(thisDocType)){
						break;
					}
				}
			}
		}*/
		return null;
	}
	public String getLabel(String key, String mod) {
		String path=null;
		if("set".equals(mod)){
			path=setPath;
		}else if("ds".equals(mod)){
			path=dsPath;
		}else if("efile".equals(mod)){
			path=efilePath;
		}else if("edir".equals(mod)){
			path=edirPath;
		}else if("rmt".equals(mod)){
			path=remotePath;
		}else if("svg".equals(mod)){
			path=svgPath;
		}
		if(Validator.isNotNull(path)){
			ResourceBundle rb=getTexts(path);
			String label="";
			try{
				label=rb.getString(key);
			}catch (Exception e) {
				return key;
			}
			if("".equals(label)){
				return label=" ";
			}
			if(Validator.isNotNull(label))
				return label;
		}
		return key;
	}
	
	public ArrayList<String> getDefaultMasterFields(String mod, String docType) {
		ArrayList<String> defaultMasterFieldsList=new ArrayList<>();
		String path=null;
		if("fin".equals(mod)){
			String directory="finance.";
			if("inv".equals(docType)){
				path=directory+"invSetting";
			}
		}else if("set".equals(mod)){
			String directory="setup.";
			if("usr".equals(docType)){
				path=directory+"usrSetting";
			}
		}
		if(Validator.isNotNull(path)){
			ResourceBundle rb=getTexts(path);
		
			Enumeration<String>keyList=rb.getKeys();
			ArrayList defaultDocListSrc=new ArrayList<>();
			if(keyList!=null&&keyList.hasMoreElements()){
				while(keyList.hasMoreElements()){
					String key=keyList.nextElement();
					if(Validator.isNotNull(key)&&key.startsWith("masterField.")){
						String setting=rb.getString(key);
						defaultMasterFieldsList.add(setting);
					}
				}
			}
		}
		return defaultMasterFieldsList;
	}
	
} 
