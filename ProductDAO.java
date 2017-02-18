package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ProductVO;

public class ProductDAO 
{

	public void addProduct(ProductVO productVO)
	{
		try
		{
			SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr= session.beginTransaction();
			session.save(productVO);
			tr.commit();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
