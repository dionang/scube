package action;

import com.b2bAdmin.B2bAdminCtrl;
import com.object.b2bAdminDetail;
import com.util.helper.GeneralException;
import com.util.helper.SecurityObject;

import utils.BeanManager;

public class IndexAction extends Action {
	/**
	 * @author PK Tan
	 */
	private static final long serialVersionUID = 1603664919975905679L;

//	FrontObject front = (FrontObject) loadFormBean("front", new FrontObject(), userSession);

	public String execute() {
		if ("index".equals(getActionName())) {
			if ("submit".equals(actionKey)) {
				// submit from login page
				return login();
			} else {
				// go to login page
				return "fasheHome";
			}
		} else if ("try".equals(getActionName())) 
			
		{
			return"try";
			
		}else if ("pro".equals(getActionName())) 
			
		{
			return"pro";
		}
			
			
			
		else {
			return "fasheHome";
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
				return "fasheHome";

//		} catch (GeneralException e) {
//
//			return "fasheHome";
//		}

	}

//	public FrontObject getFront() {
//		return front;
//	}
//
//	public void setFront(FrontObject front) {
//		this.front = front;
//	}

}
