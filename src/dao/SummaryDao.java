package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;
import daoI.ISummary;
import model.BeanSummary;
@Repository
public class SummaryDao implements ISummary {

	@Override
	public void addSummary(BeanSummary Summary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(Summary);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public BeanSummary SearchSummary(int SummaryId) {
		// TODO Auto-generated method stub
		BeanSummary result =new BeanSummary();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {

		org.hibernate.Query qry = session.createQuery("from BeanSummary where summaryId=?");
		qry.setParameter(0, SummaryId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(BeanSummary)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanSummary> loadSummary(int SummaryId) {
		// TODO Auto-generated method stub
		List<BeanSummary> result =new ArrayList<BeanSummary>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummary");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanSummary> loadAllSummary() {
		// TODO Auto-generated method stub
		List<BeanSummary> result =new ArrayList<BeanSummary>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummary");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public void modifrySummary(BeanSummary Summary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(Summary);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public void DelSummary(BeanSummary Summary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(Summary);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	public int SearchSummaryid(String userId, String projectId) {
		// TODO Auto-generated method stub
		int result ;
		result=-1;
		Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		org.hibernate.Query qry = session.createQuery("select max(summaryId) from BeanSummary"
				+ "		 where projectId=? and userId=?");
		qry.setParameter(0, projectId);
		qry.setParameter(1, userId);
		java.util.List list = qry.list();
		session.getTransaction().commit();	
		result =(int)list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		System.out.println(result);
		return result;
	}

	@Override
	public List<BeanSummary> loadASummary() {
		// TODO 自动生成的方法存根
		List<BeanSummary> result =new ArrayList<BeanSummary>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummary where applicationId = ''");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

	@Override
	public List<BeanSummary> loadAllSummary(String userId) {
		// TODO 自动生成的方法存根
		List<BeanSummary> result =new ArrayList<BeanSummary>();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			org.hibernate.Query qry = session.createQuery("from BeanSummary where userId = '"+userId+"'");
			java.util.List list = qry.list();
			session.getTransaction().commit();	
			result =list;
	
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return result;
	}

}
