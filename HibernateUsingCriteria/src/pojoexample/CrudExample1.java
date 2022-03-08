package pojoexample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class CrudExample1 {

	
		// TODO Auto-generated method stub
		static Configuration cfg;
		static SessionFactory sf;
		static Session session;

		static void connection() {
			cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sf=cfg.buildSessionFactory();
			session =sf.openSession();
		}
		static void selectRecord()
		{

			Criteria q = session.createCriteria(Bankeg.class);
			List lst=q.list();
			Iterator it=lst.iterator();
			while(it.hasNext())
			{
				Bankeg s=(Bankeg)it.next();
				System.out.println(s.getId()+" "+s.getName());
			}
		}
		
		 static void closeconn() {
			 session.close();
		 }

		public static void main(String[] args) {
			connection();
				selectRecord();
				closeconn();
		}

}
