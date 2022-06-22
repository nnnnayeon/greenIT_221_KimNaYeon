package shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	
	String fileName = "SHOP.txt";
	String data = "";

	public void setData() {
		data = "";
		
	}
	
	public void save() {
		setData();
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
			System.out.println("파일 저장 성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("파일 저장 실패");
		}
	}
	
	public void load() {
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			if(file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
