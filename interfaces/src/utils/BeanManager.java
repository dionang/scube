package utils;

import javax.naming.InitialContext;

import com.account.*;
//import com.b2bAdmin.B2bAdminCtrl;
//import com.b2bAdmin.B2bAdminCtrlBean;
//import com.member.memberctrl;

public class BeanManager {
	public static AccountCtrl getAccountCtrl() {
		AccountCtrl ctrl = null;
		try {
			InitialContext context = new InitialContext();
			ctrl = (AccountCtrl) context.lookup("java:global/ear/all/AccountCtrlBean!com.account.AccountCtrl");
		} catch (Exception ex) {
			System.out.print("error getting Account Ctlr");// throw error
		}
		return ctrl;
	}
//
//	public static memberctrl getmemberctrl() {
//		memberctrl ctrl = null;
//
//		try {
//
//			InitialContext context = new InitialContext();
//			ctrl = (memberctrl) context.lookup("java:global/ear/all/memberctrlbean!com.member.memberctrl");
//
//		} catch (Exception ex) {
//			System.out.println("error getting Controller");
//		}
//
//		return ctrl;
//	}
//
//	public static B2bAdminCtrl getb2bAdminCtrl() {
//		B2bAdminCtrl ctrl = null;
//
//		try {
//
//			InitialContext context = new InitialContext();
//
//			ctrl = (B2bAdminCtrl) context.lookup("java:global/ear/all/B2bAdminCtrlBean!com.b2bAdmin.B2bAdminCtrl");
//			// context.lookup("java:global/ear/all/CompanyCtlrBean!com.company.CompanyCtlr")
//
//		} catch (Exception ex) {
//			System.out.println("error getting b2b admin Controller");
//		}
//
//		return ctrl;
//	}

	


}
