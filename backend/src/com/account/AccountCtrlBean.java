package com.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.PropertyUtils;

import com.object.AccountDetail;
import com.object.AccountEntity;
import com.util.helper.ExceptionDetail;
import com.util.helper.GeneralException;
import com.util.helper.SecurityObject;
import utils.Validator;

@Stateless
public class AccountCtrlBean implements AccountCtrl {

	@PersistenceContext(unitName = "backPU", type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	@Resource

	private SessionContext context;

	public AccountEntity login(String username, String password) {
		Query query = em.createQuery("SELECT a FROM AccountEntity a "
				+ "where a.username = :username and a.passwordHash = :passwordHash");
		query.setParameter("username", username);
		query.setParameter("passwordHash", password);
		//hash the password and compare with bcrypt
		
		try {
			AccountEntity account = (AccountEntity) query.getSingleResult();
			return account;
		} catch (NoResultException e) {
			return null;
		}
		
	}

//	public ArrayList<AccountDetail> adminList(SecurityObject so) throws GeneralException {
//		ArrayList<AccountDetail> dList = new ArrayList<>();
//		try {
//			if (checkAdminRights(so.getUid())) {
//				Query q = entityManager.createQuery("SELECT u FROM admin u ");
//				List<AccountDetail> eList = q.getResultList();
//				for (AccountDetail e : eList) {
//					AccountDetail d = new AccountDetail();
//					PropertyUtils.copyProperties(d, e);
//					dList.add(d);
//				}
//				return dList;
//			}
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		} catch (Exception ex) {
//			this.context.setRollbackOnly();
//			System.out.print(ex.getMessage());
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		}
//	}
//
//	public AccountDetail addAdmin(SecurityObject so) throws GeneralException {
//		try {
//			if (checkAdminRights(so.getUid())) {
//				AccountDetail detail = (AccountDetail) so.getObjDetail();
//				AccountDetail e = new AccountDetail();
//				PropertyUtils.copyProperties(e, detail);
//				e.setId(null);
//				entityManager.persist(e);
//				detail.setId(e.getId());
//				return detail;
//			}
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		} catch (Exception ex) {
//			this.context.setRollbackOnly();
//			System.out.print(ex.getMessage());
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		}
//	}
//
//	public AccountDetail getAdmin(SecurityObject so) throws GeneralException {
//		try {
//
//			AccountDetail e = entityManager.find(AccountDetail.class, so.getDocId());
//			AccountDetail d = new AccountDetail();
//			PropertyUtils.copyProperties(d, e);
//			return d;
//
//		} catch (Exception ex) {
//			this.context.setRollbackOnly();
//			System.out.print(ex.getMessage());
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		}
//	}
//
//	public boolean checkAdminRights(int uid) throws GeneralException {
//		try {
//			AccountDetail e = entityManager.find(AccountDetail.class, uid);
//			if (e != null) {
//				return true;
//			}
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		} catch (Exception ex) {
//			this.context.setRollbackOnly();
//			System.out.print(ex.getMessage());
//			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
//		}
//	}

}
