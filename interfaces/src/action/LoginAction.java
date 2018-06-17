package action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.account.*;
import com.object.AccountEntity;
import com.opensymphony.xwork2.ActionSupport;

import utils.BeanManager;

public class LoginAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}  
	  
	//getters and setters  	  
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String execute() {
		AccountCtrl ctrl = BeanManager.getAccountCtrl();
		AccountEntity account = ctrl.login(username, password);
		
		if(account != null) {
			session.put("account", account);
			return "success";
		} else {
			return "error";
		}
	}
	
	public String login() {
		
//		try {
//			String username = front.getUsername();
//			String password = front.getPassword();
//			b2bAdminDetail backendDetail = new b2bAdminDetail();
//			backendDetail.setUsername(username);
//			backendDetail.setPassword(password);
//			SecurityObject so = new SecurityObject();
//			B2bAdminCtrl ac = BeanManager.getb2bAdminCtrl();
//			so.setObjDetail(backendDetail);
//			b2bAdminDetail returnDetail = new b2bAdminDetail();
//			returnDetail = ac.login(so);
//			
//		
//			
//
//			// pass value to front in B2BADMINDETAIL
//			front.setB2bAdmin(returnDetail);
			// check type of user
//			if (("admin").equals(returnDetail.getUserType())) {
//				return "b2bDashboard";
//			} else if (("salesman").equals(returnDetail.getUserType())) {
//				return "redirectSalesman";
//			} else
//				return "fasheHome";
//
//		} catch (GeneralException e) {
//
			return "fasheHome";
//		}

	}
}
