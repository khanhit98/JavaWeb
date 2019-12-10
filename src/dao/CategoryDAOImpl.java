package dao;
import model.Category;
import util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CategoryDAOImpl implements CategoryDAO{
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	

	@Override
	public void insertCategory(Category c) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
		}
		catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	} 
		
	

}
