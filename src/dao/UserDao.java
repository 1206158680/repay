package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import convenience.util.BaseException;
import convenience.util.HibernateUtil;
import daoI.IUser;
import model.BeanUser;

@Repository
public class UserDao implements IUser{
	public UserDao(){
	      System.out.println("UserDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addUser(BeanUser user) {
		// TODO �Զ����ɵķ������
		
	}



	@Override
	public BeanUser SearchUser(String userId) {
		// TODO �Զ����ɵķ������
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanUser where userId = '" + userId + "'";
		Query qry = s.createQuery(hql);
		Object user = qry.uniqueResult();
		tx.commit();
		return (BeanUser)user;
	}



	@Override
	public BeanUser loadUser(String userId) {
		// TODO �Զ����ɵķ������
		return null;
	}



	@Override
	public BeanUser loadAllUser() {
		// TODO �Զ����ɵķ������
		return null;
	}



	@Override
	public void modifryUser(BeanUser user) {
		// TODO �Զ����ɵķ������
		
	}



	@Override
	public void DelUser(BeanUser user) {
		// TODO �Զ����ɵķ������
		
	}

}
