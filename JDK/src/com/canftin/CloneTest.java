package com.canftin;

class Bean1 implements Cloneable {
	private String name;
	public Bean1(String name) {
		this.name = name;
	}
	@Override
	protected Bean1 clone() throws CloneNotSupportedException {
		return (Bean1) super.clone();
	}
}

class Bean implements Cloneable {
	private String name;
	private String firstSign;//获取名字首字母
	public Bean(String name) {
		this.name = name;
		if (name.length() != 0) {
			firstSign = name.substring(0, 1);
			firstSign += "abc";
		}
	}
	@Override
	protected Bean clone() throws CloneNotSupportedException {
		return (Bean) super.clone();
	}
}

public class CloneTest {
	private static final int COUNT = 10000 * 1000;
	public static void main(String[] args) throws CloneNotSupportedException {
		long s1 = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			Bean1 bean1 = new Bean1("CanftIn");
		}
		long s2 = System.currentTimeMillis();
		Bean1 bean1 = new Bean1("CanftIn");
		for (int i = 0; i < COUNT; i++) {
			Bean1 b = bean1.clone();
		}
		long s3 = System.currentTimeMillis();
		System.out.println("new  = " + (s2 - s1));
		System.out.println("clone = " + (s3 - s2));

		long s4 = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			Bean bean = new Bean("CanftIn");
		}
		long s5 = System.currentTimeMillis();
		Bean bean = new Bean("CanftIn");
		for (int i = 0; i < COUNT; i++) {
			Bean b = bean.clone();
		}
		long s6 = System.currentTimeMillis();
		System.out.println("new  = " + (s5 - s4));
		System.out.println("clone = " + (s6 - s5));
	}
}
