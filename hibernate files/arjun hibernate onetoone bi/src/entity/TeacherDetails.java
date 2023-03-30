package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher_details")
public class TeacherDetails {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="city")
		private String city;
		
		@Column(name="hobby")
		private String hobby;
		
		//mapped by tells the hibernate to look at the teacher detail property in teacher class
		//uses the information from teacher class @JoinColumn
		 
		@OneToOne(mappedBy = "teacherDetails",cascade=CascadeType.ALL)
		private Teacher teacher; 

		public TeacherDetails(String city, String hobby) {
			super();
			
			this.city = city;
			this.hobby = hobby;
		}

		public TeacherDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		public Teacher getTeacher() {
			return teacher;
		}

		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
        
		//here in to string do not avoid the teacher attribute
		@Override
		public String toString() {
			return "TeacherDetails [id=" + id + ", city=" + city + ", hobby=" + hobby + "]";
		}

		

		

	
		
		

		
		
		
		

		
		
}
