package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import daoI.IUserDao;
import model.BeanItemCost;
import model.BeanUser;
import util.HibernateUtil;

@Repository
public class UserDao implements IUserDao{
	public UserDao(){
	      System.out.println("UserDao Constructor...\n\n\n\n\n");
	}
	
	@Override
	public void addUser(BeanUser user) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanUser SearchUser(String userId) {
		// TODO 自动生成的方法存根
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from BeanUser where userId = '" + userId + "'";
		Query qry = s.createQuery(hql);
		Object user = qry.uniqueResult();
		tx.commit();
		return (BeanUser)user;
	}

	@Override
	public List<BeanUser> loadUser(String userName) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanUser where userName like '%" + userName + "%'";
		hql += " order by userId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanUser> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public List<BeanUser> loadAllUser() {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from BeanUser ";
		hql += " order by userId ";
		Query qry = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BeanUser> result = qry.list();
		tx.commit();
		return result;
	}

	@Override
	public void modifryUser(BeanUser user) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void delUser(BeanUser user) {
		// TODO 自动生成的方法存根
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public static void main(String arg[]){
		BeanUser user = new BeanUser();
		user.setUserId("12");
		user.setPassword("1235");
		new UserDao().addUser(user);
	}

	@Override
	public float exploreUserbudget(String userid) {
		float result=-1;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("BeanBudget.budgetSum from BeanProject,BeanBudget,BeanSummary where BeanProject.userId=?");
		qry.setParameter(0, userid);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(float)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
		// TODO Auto-generated method stub
		
	}
	public float exploreUsersummary(String userid) {
		float result=-1;
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("BeanSummary.sum from BeanProject,BeanBudget,BeanSummary where BeanProject.userId=?");
		qry.setParameter(0, userid);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(float)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
		
	}
}
