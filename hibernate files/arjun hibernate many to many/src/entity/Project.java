package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="projects")
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private int project_id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(mappedBy = "projects", cascade = {CascadeType.ALL})
	Set<Employee> employees=new HashSet<Employee>();

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String title) {
		super();
		this.title = title;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", title=" + title + "]";
	}
	
	
	

}
