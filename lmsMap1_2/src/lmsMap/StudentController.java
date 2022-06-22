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
		System.out.println("�й� �Է�: ");
		
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudnet(num);
			
			if(target != null) {
				dao.deleteStudent(num);
				System.out.println("�����Ǿ����ϴ�.");
			}
			else
				System.err.println("�������� �ʴ� ��ȣ�Դϴ�.");
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("�߸��� �Է��Դϴ�.");
		}
	}
	
	public void updateStudent() {
		System.out.print("�й��Է�: ");
		
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudnet(num);
			
			if(target != null)
				selectSubMenu(num);
			else
				System.err.println("�������� �ʴ� �й��Դϴ�.");
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("�߸��� �Է��Դϴ�.");
		}
	}
	
	public void selectSubMenu(int stuNum) {
		String[] subMenu = {"������û", "����öȸ", "�����Է�", "�ڷΰ���"};
		
		while(true) {
			Lms.printMenu(subMenu);
			System.out.print("�Է�: ");
			try {
				int sel = Lms.scan.nextInt();
				
				if(sel == 1) {}
				else if(sel == 2) {}
				else if(sel == 3) {}
				else if(sel == 4) {break;}
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.err.println("��ȣ�� �Է����ּ���.");
			}
		}
	}
	
	public void createStudent() {
		System.out.print("�л��̸�: ");
		String name = Lms.scan.next();
		Student student = new Student(name);
		int result = dao.addStudent(student);
		System.out.println("�й��߱�: " + result);
	}

}
