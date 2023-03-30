package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;
import entity.Project;

public class Mainclass {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Project.class)
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
				
		Session session=null;
		
		try {
			 session=factory.getCurrentSession();
			session.beginTransaction();
			
			Project p1=new Project("java project");
			Project p2=new Project("Spring project");
			Project p3=new Project("html project");
			
			Employee e1=new Employee("Arjun", "ks");
			Employee e2=new Employee("ajith", "aji");
			Employee e3=new Employee("vinayak", "Tk");
			
			e1.getProjects().add(p1);
			e1.getProjects().add(p2);
			e2.getProjects().add(p3);
			e3.getProjects().add(p1);
			e3.getProjects().add(p2);
			
			session.save(e1);
			session.save(e2);
			session.save(e3);
			
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			session.close();
			
		}
		
		
	}
	
}
