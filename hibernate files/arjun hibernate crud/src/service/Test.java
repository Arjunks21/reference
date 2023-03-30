package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Test {
	
	public static void main(String[] args) {
		
		
		System.out.println("Connecting to the data base..........");
		
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
		
        factory=new Configuration()
				    .configure("hibernate.cfg.xml")
					.buildSessionFactory();
        
        
        		Teacher t1=new Teacher("arjun", "ks", "arjun@gmail");
        		 Teacher t2=new Teacher("ajith", "ks", "ajith@gmail");
        		 Teacher t3=new Teacher("vinayak", "tk", "vinayak@gmail");
        
        //insertion of data
        try {
        	
        	session=factory.getCurrentSession();
            tx=session.beginTransaction();
            
            ///////////////////////////////////////////////////
            // step 2  for saving data to database
//        	session.save(t1);
//        	session.save(t2);
//        	session.save(t3);
            
         //////////////////////////////////////////////////////////////   
            // //step 3 Retrieving data from the database
            
//            Teacher teacher=session.get(Teacher.class,1);
//            System.out.println(teacher);
            
        ///////////////////////////////////////////////////////////////    
            ////Querying objects (listing all objects/data)
            
//            List<Teacher> teacher1=session.createQuery("from Teacher").list();
//            for (Teacher tt1 : teacher1) {
//            	System.out.println(tt1);
//				
//			}
           
            
            ////display teacher lastname =tk
            
//            List<Teacher> teacher2=session.createQuery("from Teacher where l_name='tk'").list();
//           
//            System.out.println(teacher2);
            
          ////display teacher email is =arjun@gmail
            
//            List<Teacher> teacher3=session.createQuery("from Teacher where email like 'arjun%'").list();
//            System.out.println(teacher3);
//            
            
            
            
            
            //////////////////////////////////////////////////////////////////////////
            //step 5 updating data/objects
            
            /////using setters
            
//            int teacherid=1;
//            
//            Teacher teacher1=session.get(Teacher.class,teacherid);
//            
//            teacher1.setF_name("Arjun");
//            session.update(teacher1);
            
            
            //using createQuery & execute update
            
//            session.createQuery("update Teacher set f_name='Ajith' where email='ajith@gmail'").executeUpdate();
//            
            
            
            /////////////////////////////////////////////////////////
            //step 6 deleting the objects
            //using session.delete();
            
            
//            Teacher teacher112= session.get(Teacher.class,2);
//            
//            session.delete(teacher112);
//            
            //using create Query & execute update
            
            session.createQuery("delete from Teacher where id='2'").executeUpdate();
            
            tx.commit();
        	
        	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("error");
		}
        
        finally {
			session.close();
		}
        
        System.out.println("success!!!!!!");
	}

}
