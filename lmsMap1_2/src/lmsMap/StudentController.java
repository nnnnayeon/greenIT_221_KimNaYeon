package lmsMap;

import java.util.InputMismatchException;
import java.util.Iterator;

public class StudentController {
	
	private StudentDAO dao;
	
	private RegistrationController rc;
	
	public StudentController() {
		this.dao = StudentDAO.getInstance();
		this.rc = new RegistrationController();
	}
	
	public void printStudents() {
		Iterator<Integer> keys = dao.getKeyset();
		
		while(keys.hasNext()) {
			System.out.println(dao.getStudnet(keys.next()));
		}
	}
	
	public void deleteStudent() {
		System.out.println("학번 입력: ");
		
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudnet(num);
			
			if(target != null) {
				dao.deleteStudent(num);
				System.out.println("삭제되었습니다.");
			}
			else
				System.err.println("존재하지 않는 번호입니다.");
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("잘못된 입력입니다.");
		}
	}
	
	public void updateStudent() {
		System.out.print("학번입력: ");
		
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudnet(num);
			
			if(target != null)
				selectSubMenu(num);
			else
				System.err.println("존재하지 않는 학번입니다.");
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("잘못된 입력입니다.");
		}
	}
	
	public void selectSubMenu(int stuNum) {
		String[] subMenu = {"수강신청", "수강철회", "성적입력", "뒤로가기"};
		
		while(true) {
			Lms.printMenu(subMenu);
			System.out.print("입력: ");
			try {
				int sel = Lms.scan.nextInt();
				
				if(sel == 1) {}
				else if(sel == 2) {}
				else if(sel == 3) {}
				else if(sel == 4) {break;}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.err.println("번호를 입력해주세요.");
			}
		}
	}
	
	public void createStudent() {
		System.out.print("학생이름: ");
		String name = Lms.scan.next();
		Student student = new Student(name);
		int result = dao.addStudent(student);
		System.out.println("학번발급: " + result);
	}

}
