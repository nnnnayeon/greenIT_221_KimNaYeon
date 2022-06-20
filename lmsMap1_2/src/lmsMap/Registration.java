package lmsMap;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Registration {
	
	private int regCode;
	private Timestamp regDate;
	private Student student;
	private Subject subject;
	private int score;
	
	public Registration(Student student, Subject subject) {
		this.student = student;
		this.subject = subject;
	}
	
	public Registration(int regCode, Student student, Subject subject) {
		this.regCode = regCode;
		this.student = student;
		this.subject = subject;
		this.regDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("§§ %d/%s : %d¡° (%s)", this.regCode, this.subject.getTitle(), this.score, this.regDate);
	}
	
	public Student getStudent() {
		return this.student;
	}

	public Subject getSubject() {
		return this.subject;
	}
	
}
