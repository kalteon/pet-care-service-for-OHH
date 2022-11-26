package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserDB {
	private File file;
	private ObjectOutputStream write;
	private ObjectInputStream read;
	
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
	public void WriteObjectData(Object a) {
		try {
			write.writeObject(a);
		} catch (IOException e) {
			System.out.print("file write false");
			e.printStackTrace();
		}
	}
	public Object ReadObjecfData() {
		Object temp = new Object();
		try {
			temp = (Object)read.readObject();
			return temp;
		} catch (ClassNotFoundException e) {
			System.out.print("file read false");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("file read false");
			e.printStackTrace();
		}
		return temp;
	}
	public void DeletObjectData() {
		file.delete();
	}
	public void Close() {
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
