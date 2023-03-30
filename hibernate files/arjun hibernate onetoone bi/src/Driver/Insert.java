package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Insert {
	
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
        	///create the objects
    		Teacher t1=new Teacher("Arjun","ks","arjun@gmail");
    		TeacherDetails td1=new TeacherDetails("Bengaluru","football");
    		
    		// associate  the objects
    		
    		t1.setTeacherDetails(td1);
    		
    		
    		//start transaction
    		session.beginTransaction();
    		
    		//save the teacher
    		
    		session.save(t1);
    		
    		///commit transaction
    		session.getTransaction().commit();
    		
    		
    		
        }finally {
        	
        	session.close();
				
			}
    		
			
		
        
        		
        		
        		
		
	}

}
