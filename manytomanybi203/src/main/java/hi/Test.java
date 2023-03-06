package hi;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Course c1 = new Course();
		c1.setCourseName("cs");
		c1.setCost(100);

		Course c2 = new Course();
		c2.setCourseName("english");
		c2.setCost(200);

		Course c3 = new Course();
		c3.setCourseName("kannada");
		c3.setCost(300);

		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(c1);// p
		courses1.add(c2);// m
		courses1.add(c3);// b

		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(c2);// m
		courses2.add(c3);// b

		List<Course> courses3 = new ArrayList<Course>();
		courses3.add(c1);// p
		courses3.add(c2);// m

		Student s1 = new Student();
		s1.setName("raghu");
		s1.setAge(18);
		s1.setCourses(courses1);// p m b

		Student s2 = new Student();
		s2.setName("binod");
		s2.setAge(19);
		s2.setCourses(courses2);// m b

		Student s3 = new Student();
		s3.setName("rock");
		s3.setAge(17);
		s3.setCourses(courses3);// p m

		//list of students who have taken physics
		List<Student> students1 = new ArrayList<Student>();// p
		students1.add(s1);//a
		students1.add(s3);//k

		//list of students who have taken maths
		List<Student> students2 = new ArrayList<Student>();// m
		students2.add(s1);
		students2.add(s2);
		students2.add(s3);

		//list of students who have taken biology
		List<Student> students3 = new ArrayList<Student>();// b
		students3.add(s1);
		students3.add(s2);

		c1.setStudents(students1);
		c2.setStudents(students2);
		c3.setStudents(students3);
		
		et.begin();
	
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		et.commit();
		

	}

}
