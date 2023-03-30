package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Delete {
	
	
	public static void main(String[] args) {
		
		

		///create session factory
		SessionFactory factory=new Configuration()
				    .configure("hibernate.cfg.xml")
				    .addAnnotatedClass(Teacher.class)
				    .addAnnotatedClass(TeacherDetails.class)
					.buildSessionFactory();
        ///create session
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int tId=1;
			
			Teacher tempT=session.get(Teacher.class,tId);
			 
		
			
			if(tempT!=null) {
				System.out.println("deleting.........."); 
				
				//it will delete teacher detail data also because we have gave cascade type =All
				session.delete(tempT);
			}
			
			session.getTransaction().commit();
			
			
			
			
		}finally {
			
			session.close();
			
		}
	}

}
