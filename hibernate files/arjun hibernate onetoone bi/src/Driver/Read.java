package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Read {
	
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
			
			//get the teacher detail object
			int tdId=1;
			TeacherDetails tempTd=session.get(TeacherDetails.class,tdId);
			 
			//print the teacher detail object
		System.out.println("teacher details is "+tempTd);
		
		
		// print the associated teacher detail
		
		    
		System.out.println( tempTd.getTeacher());
		
		
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			
		}finally {
			
			session.close();
			
		}
	}

}
