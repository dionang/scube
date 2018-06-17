package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.helper.ExceptionDetail;
import com.util.helper.GeneralException;

import utils.ConstantPath;
import utils.PropHelper;
import utils.Validator;

public class Action extends ActionSupport{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2614878859930746001L;
	/**
	 * 
	 * @author PK Tan
	 */
	public String extentActionKey(Object form,String returnNotFoundString){
		if(Validator.isNotNull(actionKey)){
			return returnNotFoundString;
		}
		return returnNotFoundString;
	}
	public HttpServletRequest request = ServletActionContext.getRequest();
	public HttpServletResponse respond = ServletActionContext.getResponse();
	
	protected Map<String, Object> applicationContext=ActionContext.getContext().getApplication();
	protected Map<String, Object> userSession=ActionContext.getContext().getSession();
	protected Map<String, Object> contextMap=ActionContext.getContext().getContextMap() ;

	protected String env=listenEnv();
	protected String actionKey=loadParameterKey("actionKey");
	protected String urlAction=loadParameterKey("urlAction");
	protected String targetId=new String();
	protected String type=new String();
	protected String errorMessage=new String();
	protected String jspMessage=new String();
	protected ArrayList<String> errorMessageList=new ArrayList<>();
	protected ArrayList<String> successMessageList=new ArrayList<>();
	 
	
	protected ResourceBundle applicationResource=getTexts("ApplicationResources");

	
	
	public boolean getDebug(){
		return Boolean.parseBoolean(loadFormBean("debug", "false", userSession)+"");
	}
	public void responseHeaderSet(){
		respond.setStatus(HttpServletResponse.SC_OK);
		respond.setHeader("Access-Control-Allow-Origin", "*");
		respond.setHeader("Access-Control-Allow-Methods", "POST");
		respond.setHeader("Access-Control-Allow-Headers", "Content-Type");
		respond.setHeader("Access-Control-Max-Age", "86400");
	}
	public void responseHeaderSetError(){
		try{
		respond.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "123");
		respond.setHeader("Access-Control-Allow-Origin", "*");
		respond.setHeader("Access-Control-Allow-Methods", "POST");
		respond.setHeader("Access-Control-Allow-Headers", "Content-Type");
		respond.setHeader("Access-Control-Max-Age", "86400");
		}catch(Exception ex){}
	}
	 
	public String listenEnv(){
		String paramEnv=loadParameterKey("env");
		if(Validator.isNotNull(paramEnv)){
			setENV(paramEnv);
		}
		return getENV();
	}
	public String loadParameterKey(String key){
		Map<String,Object> parameter=ActionContext.getContext().getParameters();
		if(Validator.isNotNull(key)&&parameter!=null){
			if(parameter.containsKey(key)){
				String[] value=(String[])parameter.get(key);
				if(value.length>0){
					return value[0]+"";
				}
			}
		}
		
		return null;
	}
	public ResourceBundle getWorkFlowResource(String modType){
		if(Validator.isNotNull(modType)){
			String rephaseModType=modType.toLowerCase();
			String firstChar=modType.substring(0,1);
			firstChar=firstChar.toUpperCase();
			rephaseModType=firstChar+rephaseModType.substring(1);
			ResourceBundle rb=getTexts("workFlow.workFlow"+rephaseModType);
			return rb;
		}
		return null;
	}
	
	public String addParameterkey(String key, String value){
		try{
			Map<String,Object> parameter=ActionContext.getContext().getParameters();
			if(Validator.isNotNull(key)&&Validator.isNotNull(value)){
				String[] put=new String[1];
				put[0]=key;
				parameter.put(key, put);
				return key;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
	public Object getFormBean(String formBeanName,Map<String, Object> userSession){
		try{
			if(userSession.containsKey(formBeanName)){
				return userSession.get(formBeanName);
			}else{
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public Object loadFormBean(String formBeanName,Object formBean,Map<String, Object> userSession){
		return loadFormBean(formBeanName, formBean, userSession,"erpSessionAttributeNameList");
	}
	public Object loadFormBean(String formBeanName,Object formBean,Map<String, Object> userSession, String sessionType){
		try{
			if(userSession.containsKey(formBeanName)){
				return userSession.get(formBeanName);
			}else{
				userSession.put(formBeanName, formBean);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			formBean=createNewFormBean(formBeanName, formBean, userSession,sessionType);
		}
		return formBean;
	}
 
	public void setENV(String env){
		if(Validator.isNull(env)){
			env="linux";
		}
		createNewFormBean("env", env, userSession);
	}
	public String getENV(){ 
		return(String)loadFormBean("env","linux",userSession); 
	}
	public Object createNewFormBean(String formBeanName,Object formBean,Map<String, Object> userSession){
		return createNewFormBean(formBeanName, formBean, userSession,"erpSessionAttributeNameList");
	}
	public Object createNewFormBean(String formBeanName,Object formBean,Map<String, Object> userSession,String sessionType){
		userSession.put(formBeanName, formBean);
		HashSet<String> erpSessionAttributeNameList=new HashSet<>();
		if(userSession.containsKey(sessionType)){
			erpSessionAttributeNameList=(HashSet)userSession.get(sessionType);
		}
		erpSessionAttributeNameList.add(formBeanName);
		userSession.put(sessionType, erpSessionAttributeNameList);
		return formBean;
	}
	public void removeFormBean(String formBeanName,Map<String, Object> userSession){
		userSession.remove(formBeanName);
	}
	 
	  
	public void formatError(Object form, GeneralException ge, String docMod){
		if(ge!=null){
			ArrayList<ExceptionDetail> errorList=ge.getErrorList();
			if(Validator.isNotNull(errorList)){
				ResourceBundle applicationResource=getTexts("ErrorResources");
				for(int i=0; i<errorList.size(); i++){
					ExceptionDetail detail=errorList.get(i);
					String errorCode=detail.getErrorCode();
					String fieldName=detail.getFieldName();
					HashMap errorMap=detail.getErrorMap();
					String error="";
					if(Validator.isNotNull(errorCode)){
						if("ignoreErrorRes".equals(errorCode)){
							error=detail.getError();
						}else{
							try{
								if(Validator.isNull(errorMap)){
									error=applicationResource.getString(errorCode);
								}else{
									error=constructErrorMsg(applicationResource.getString(errorCode), errorMap, docMod);
								}
							}catch (Exception e) {
								error="Error Encounted! *fail to retrieve error message*";
							}
						}
					}
					try{
					PropertyUtils.setProperty(form, "errorMessage", error);
					}catch(Exception ex){}
				}
			}
		}
	}
	
	private String constructErrorMsg(String errorStatement, HashMap<String,String> errorMap, String docMod){
		ResourceBundle applicationResource=getTexts("ApplicationResources");
		PropHelper ph = new PropHelper();
		if(Validator.isNotNull(errorStatement)){
			Iterator itErrorMap = null;
			itErrorMap = errorMap.entrySet().iterator();
			
			while(itErrorMap !=null && itErrorMap.hasNext()){
				Map.Entry errorEntry = (Map.Entry)itErrorMap.next();
				String errorParameter = (String)errorEntry.getKey();
				String errorVariable = (String)errorEntry.getValue();
				String replacementString = "";
				
				if(errorStatement.contains("{"+errorParameter+"}")){
					StringTokenizer errorParameterTokenizer = new StringTokenizer(errorParameter,"#");
					String errorResType=(String)errorParameterTokenizer.nextElement();
					if("docType".equals(errorResType)){
						replacementString = applicationResource.getString(errorResType+"."+errorVariable);
						errorStatement = errorStatement.replace("{"+errorParameter+"}", replacementString);
					}else{
						replacementString = ph.getLabel(errorResType+"."+errorVariable, docMod);
						errorStatement = errorStatement.replace("{"+errorParameter+"}", replacementString);
					}
				}
				if(errorStatement.contains("|"+errorParameter+"|")){
					errorStatement = errorStatement.replace("|"+errorParameter+"|", errorVariable);
				}
			}
			addActionError(errorStatement);
		}
		return errorStatement;
	}
	protected String formDocId=loadParameterKey("formDocId");
	protected String docId;
	public String getDocId(){
		return docId;
	}
	protected String redirectActionName;
	protected String redirectActionKey;
	protected String redirectNameSpace;
	public String getRedirectActionName() {
		return redirectActionName;
	}
	public String getRedirectActionKey() {
		return redirectActionKey;
	}
	public String getRedirectNameSpace() {
		return redirectNameSpace;
	}
	 
	
	
	 
	public String printOnScreen(Object form, String returnNotFoundString){
		return "printOnScreen";
	}
	 
	
	public static void sendEmail(String host, String port,String sender,
            String recipient, String subject, String message, File attachFile)
                    throws AddressException, MessagingException {
		final String emailUsername="noreply@scube.com.sg";
		final String emailPassword="Jonger123";
		
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", emailUsername);
        properties.put("mail.password", emailPassword);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailUsername, emailPassword);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        if(Validator.isNull(sender)){
        	sender=emailUsername;
        }
        msg.setFrom(new InternetAddress(sender));
        InternetAddress[] toAddresses = { new InternetAddress(recipient) };//multiple recipient
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFile != null) {
            MimeBodyPart attachPart = new MimeBodyPart();
 
            try {
                attachPart.attachFile(attachFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
 
            multipart.addBodyPart(attachPart);
        }
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
    }

	public String uploadFile(File file,String folder,String fileName) throws IOException {
		String filePath = ConstantPath.envDocumentRootNew(getENV());
		String subPath = folder;
		filePath += subPath;

		File directory = new File(filePath);
		if (!directory.exists()) {
			if (directory.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				if (directory.mkdirs()) {
					System.out.println("Directories is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
		}
		
		//check duplicated file name
		if(Validator.isNull(fileName)) {
			File checkFile;
			do {
				Calendar currentTime = new GregorianCalendar(TimeZone.getTimeZone("Asia/Singapore"));
				currentTime.setTimeInMillis(System.currentTimeMillis());
				long millis = currentTime.getTimeInMillis();
				fileName = Long.toString(millis);
				checkFile = new File(filePath+=fileName);
			}while(checkFile.exists());
		}
		subPath += fileName;
		filePath += fileName;

		File fileToCreate = new File(filePath);
		try {
			FileUtils.copyFile(file, fileToCreate);
			return subPath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	public String getActionName(){
		String thisActionName=ActionContext.getContext().getName();
		if(Validator.isNotNull(thisActionName)){
			int cutOff=thisActionName.indexOf("/");
			if(cutOff==-1){
				return thisActionName;
			}
			int totalLen=thisActionName.length();
			thisActionName=thisActionName.substring(0,cutOff);
		}
		return thisActionName;
	}
	
	public String getActionKey() {
		return actionKey;
	}
	public void setActionKey(String actionKey) {
		this.actionKey = actionKey;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getJspMessage() {
		return jspMessage;
	}
	public void setJspMessage(String jspMessage) {
		this.jspMessage = jspMessage;
	}
	public String getUrlAction() {
		return urlAction;
	}
	public void setUrlAction(String urlAction) {
		this.urlAction = urlAction;
	}
	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	public ArrayList<String> getSuccessMessageList() {
		return successMessageList;
	}
	public void setSuccessMessageList(ArrayList<String> successMessageList) {
		this.successMessageList = successMessageList;
	}
	
	
}

