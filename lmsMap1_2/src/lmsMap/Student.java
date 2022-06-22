package lmsMap;

import java.util.ArrayList;

public class Student {
	
	private int num;
	private String name;
	private ArrayList<Registration> subs;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
		this.subs = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNum() {
		return this.num;
	}
	
	@Override
	public String toString() {
		String str = String.format("[%d] %s (%d���� ������)\n", this.num, this.name, this.subs.size());
		
		for(Registration r : this.subs) {
			str += r.toString() + "\n";
		}
		str.substring(0, str.length() -1);
		return str;
	}
	
	public void printSubs() {
		for(int i=0; i<this.subs.size(); i++) {
			System.out.printf("%d) %s\n", i+1, this.subs.get(i));
		}
	}
	
	public void addSubs(Registration newRegistration) {
		this.subs.add(newRegistration);
	}
	
	public void delSubs(int num) {
		this.subs.remove(num);
	}
	
	public int subSize() {
		return this.subs.size();
	}
	
	public Subject getSubject(int subNum) {
		for(int i=0; i<this.subs.size(); i++) {
			if(i == subNum) {
				return this.subs.get(i).getSubject();
			}
		}
		return null;
	}

}
