package lmsMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudentDAO {
	
	private Map<Integer, Student> stuDb;
	
	private static StudentDAO instance = new StudentDAO();
	
	private StudentDAO() {
		this.stuDb = new HashMap<>();
	}
	
	public static StudentDAO getInstance() {
		return instance;
	}
	
	private int randomNum() {
		Set<Integer> keyset = this.stuDb.keySet();
		
		while(true) {
			int key = Lms.ran.nextInt(8999) +1000;
			if(!keyset.contains(key))
				return key;
		}
	}
	
	int addStudent(Student student) {
		int num = randomNum();
		Student newStudent = new Student(num, student.getName());
		this.stuDb.put(num, newStudent);
		return num;
	}
	
	public void deleteStudent(int num) {
		stuDb.remove(num);
	}
	
	public Object getSize() {
		return this.stuDb.size();
	}
	
	public Iterator<Integer> getKeyset(){
		return this.stuDb.keySet().iterator();
	}
	
	public Student getStudnet(Integer key) {
		return this.stuDb.get(key);
	}
	
	

}
