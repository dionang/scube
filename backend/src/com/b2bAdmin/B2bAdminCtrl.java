package com.b2bAdmin;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.object.b2bAdminDetail;
import com.util.helper.GeneralException;
import com.util.helper.SecurityObject;

@Remote
public interface B2bAdminCtrl {

	public ArrayList<b2bAdminDetail> adminList(SecurityObject so) throws GeneralException;

	public b2bAdminDetail login(SecurityObject so) throws GeneralException;

	public b2bAdminDetail addAdmin(SecurityObject so) throws GeneralException;

	public b2bAdminDetail getAdmin(SecurityObject so) throws GeneralException;

	public boolean checkAdminRights(int uid) throws GeneralException;

}
