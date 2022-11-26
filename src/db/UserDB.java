package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserDB {
	private File file; //파일경로
	private ObjectOutputStream write; //파일에 객체의 정보를 입력하는 스트림
	private ObjectInputStream read; //파일에 저장되어있는 객체를 읽어오는 스트림
	
	public UserDB(String filePath) {
		file = new File(filePath);
		String fileName = file.getName();
		try {
			this.write = new ObjectOutputStream(new FileOutputStream(fileName));
			this.read = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeObjectData(Object a) {
		try {
			write.writeObject(a);
		} catch (IOException e) {
			System.out.print("file write false");
			e.printStackTrace();
		}
	}
	public Object readObjecfData() {
		try {
			Object temp = (Object)read.readObject();
			return temp;
		} catch (ClassNotFoundException e) {
			System.out.print("file read false");
		} catch (IOException e) {
			System.out.print("file read false");
		}
		return null; // 못 읽으면 null 반환
	}
	public void deletObjectData() {
		file.delete();
	}
	public void close() {
		try {
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args) {
		String filePath = "C:\\JAVA_workplace\\DbTest\\test.txt";
		String temp1;
		String temp2;
		UserDB test = new UserDB(filePath);
		test.WriteObjectData("asdf");
		test.WriteObjectData("12345");
		temp1 = (String)test.ReadObjecfData();
		temp2 = (String)test.ReadObjecfData();
		System.out.print(temp1 + temp2);
		test.DeletObjectData();
	}test*/ 
}
