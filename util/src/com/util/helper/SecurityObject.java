package com.util.helper;

import java.io.Serializable;
public class SecurityObject implements Cloneable,Serializable{
	private String pfcCode;
	private String accessMode;
	private int uid;
	private int docId;
	private int companyId;
	private String docType;
	private Object objDetail;
	private boolean checkAccess=false;
	private boolean logEnabled=false;
	private boolean checkLogic=true;
	private String contextPath;
	private String changes;
	private String action;
	private String status;
	private String user;
	private String businessType;
	private Object oldDetail;
	private String serverName;
	private String stockPfcCode;
	private String costMethod;
	private String revision;
	private String userEmail;
	private Object newDetail;
	private boolean populatePrintFormat=false;
	private String homeCurrencyCode;
	 
	public String getPfcCode() {
		return pfcCode;
	}
	public void setPfcCode(String pfcCode) {
		this.pfcCode = pfcCode;
	}
	public String getAccessMode() {
		return accessMode;
	}
	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}
	 
	public Object getObjDetail() {
		return objDetail;
	}
	public void setObjDetail(Object objDetail) {
		this.objDetail = objDetail;
	}
	public boolean isCheckAccess() {
		return checkAccess;
	}
	public void setCheckAccess(boolean checkAccess) {
		this.checkAccess = checkAccess;
	}
	public boolean isLogEnabled() {
		return logEnabled;
	}
	public void setLogEnabled(boolean logEnabled) {
		this.logEnabled = logEnabled;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	 
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
	public String getChanges() {
		return changes;
	}
	public void setChanges(String changes) {
		this.changes = changes;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public Object getOldDetail() {
		return oldDetail;
	}
	public void setOldDetail(Object oldDetail) {
		this.oldDetail = oldDetail;
	}
	public String getStockPfcCode() {
		return stockPfcCode;
	}
	public void setStockPfcCode(String stockPfcCode) {
		this.stockPfcCode = stockPfcCode;
	}
	public String getCostMethod() {
		return costMethod;
	}
	public void setCostMethod(String costMethod) {
		this.costMethod = costMethod;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public Object getNewDetail() {
		return newDetail;
	}
	public void setNewDetail(Object newDetail) {
		this.newDetail = newDetail;
	}
	public boolean isPopulatePrintFormat() {
		return populatePrintFormat;
	}
	public void setPopulatePrintFormat(boolean populatePrintFormat) {
		this.populatePrintFormat = populatePrintFormat;
	}
	public String getHomeCurrencyCode() {
		return homeCurrencyCode;
	}
	public void setHomeCurrencyCode(String homeCurrencyCode) {
		this.homeCurrencyCode = homeCurrencyCode;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public boolean isCheckLogic() {
		return checkLogic;
	}
	public void setCheckLogic(boolean checkLogic) {
		this.checkLogic = checkLogic;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
