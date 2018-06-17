package com.b2bAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.apache.commons.beanutils.PropertyUtils;

import com.object.b2bAdminEntity;
import com.b2bAdmin.B2bAdminCtrl;
import com.object.b2bAdminDetail;
import com.util.helper.ExceptionDetail;
import com.util.helper.GeneralException;
import com.util.helper.SecurityObject;
import utils.Validator;

@Stateless
public class B2bAdminCtrlBean implements B2bAdminCtrl {

	@PersistenceContext(unitName = "backPU", type = PersistenceContextType.TRANSACTION)
	EntityManager entityManager;
	@Resource

	private SessionContext context;

	public b2bAdminDetail login(SecurityObject so) throws GeneralException {
		try {
			b2bAdminDetail detail = (b2bAdminDetail) so.getObjDetail();
			String username = detail.getUsername();
			String password = detail.getPassword();
			Query query = entityManager
					.createQuery("SELECT u FROM b2bAdminEntity u WHERE u.username='" + username + "' ");
			List<b2bAdminEntity> resultList = query.getResultList();
			if (Validator.isNotNull(resultList)) {
				b2bAdminEntity entity = resultList.get(0);
				if (entity.getPassword().equals(password) && entity.getUsername().equals(username)) {
					PropertyUtils.copyProperties(detail, entity);
					detail.setUsername(null);
					detail.setPassword(null);
					return detail;
				}
			}
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		} catch (Exception ex) {
			this.context.setRollbackOnly();
			System.out.print(ex.getMessage());
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		}
	}

	public ArrayList<b2bAdminDetail> adminList(SecurityObject so) throws GeneralException {
		ArrayList<b2bAdminDetail> dList = new ArrayList<>();
		try {
			if (checkAdminRights(so.getUid())) {
				Query q = entityManager.createQuery("SELECT u FROM admin u ");
				List<b2bAdminEntity> eList = q.getResultList();
				for (b2bAdminEntity e : eList) {
					b2bAdminDetail d = new b2bAdminDetail();
					PropertyUtils.copyProperties(d, e);
					dList.add(d);
				}
				return dList;
			}
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		} catch (Exception ex) {
			this.context.setRollbackOnly();
			System.out.print(ex.getMessage());
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		}
	}

	public b2bAdminDetail addAdmin(SecurityObject so) throws GeneralException {
		try {
			if (checkAdminRights(so.getUid())) {
				b2bAdminDetail detail = (b2bAdminDetail) so.getObjDetail();
				b2bAdminEntity e = new b2bAdminEntity();
				PropertyUtils.copyProperties(e, detail);
				e.setId(null);
				entityManager.persist(e);
				detail.setId(e.getId());
				return detail;
			}
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		} catch (Exception ex) {
			this.context.setRollbackOnly();
			System.out.print(ex.getMessage());
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		}
	}

	public b2bAdminDetail getAdmin(SecurityObject so) throws GeneralException {
		try {

			b2bAdminEntity e = entityManager.find(b2bAdminEntity.class, so.getDocId());
			b2bAdminDetail d = new b2bAdminDetail();
			PropertyUtils.copyProperties(d, e);
			return d;

		} catch (Exception ex) {
			this.context.setRollbackOnly();
			System.out.print(ex.getMessage());
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		}
	}

	public boolean checkAdminRights(int uid) throws GeneralException {
		try {
			b2bAdminEntity e = entityManager.find(b2bAdminEntity.class, uid);
			if (e != null) {
				return true;
			}
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		} catch (Exception ex) {
			this.context.setRollbackOnly();
			System.out.print(ex.getMessage());
			throw new GeneralException(new ExceptionDetail("setup.gen.001", new HashMap(), ""));
		}
	}

}
