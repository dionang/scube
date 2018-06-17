package com.account;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.util.helper.GeneralException;
import com.util.helper.SecurityObject;
import com.object.AccountDetail;
import com.object.AccountEntity;

@Remote
public interface AccountCtrl {

//	public ArrayList<AccountDetail> adminList(SecurityObject so) throws GeneralException;

	public AccountEntity login(String username, String password);
//
//	public AccountDetail addAdmin(SecurityObject so) throws GeneralException;
//
//	public AccountDetail getAdmin(SecurityObject so) throws GeneralException;
//
//	public boolean checkAdminRights(int uid) throws GeneralException;

}
