package com.canftin;

import java.io.*;

class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Name;
	private int age;
	private String sex;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}

public class SerializableTest {
	/**
	 * 将obj对象写入文件
	 */
	public static void writeData(Object obj) throws Exception {

		FileOutputStream fos = new FileOutputStream(
				"./SerializableTest.txt");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(obj);
		os.close();
		System.out.println("java 对象存储完成");
	}

	/**
	 * 从文件中读取对象
	 */
	public static Object readData() throws Exception {
		FileInputStream fis = new FileInputStream("./SerializableTest.txt");
		ObjectInputStream oi = new ObjectInputStream(fis);
		Object obj = oi.readObject();
		oi.close();
		System.out.println("java 对象读取完成");
		return obj;
	}
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("CanftIn");
		person.setAge(20);
		//将person写入文件
		SerializableTest.writeData(person);
		//读取person对象
		person = (Person) SerializableTest.readData();
		System.out.println(person.getName());
	}
}
