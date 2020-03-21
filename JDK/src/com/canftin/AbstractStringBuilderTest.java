package com.canftin;

public class AbstractStringBuilderTest {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer();
		System.out.println(s.capacity());// 16
		System.out.println(s.length());// 0
		System.out.println("容量：" + s.capacity());// 容量：16
		s.ensureCapacity(10);
		System.out.println("容量：" + s.capacity());// 容量：16
		s.ensureCapacity(30);
		System.out.println("容量：" + s.capacity());// 容量：34
		s.ensureCapacity(80);
		System.out.println("容量：" + s.capacity());// 容量：80

		System.out.println(s.indexOf("2"));// 1
		System.out.println(s.indexOf("5"));// -1

		// Unicode标量值测试：
		StringBuffer s1 = new StringBuffer();
		System.out.println(s1.append('a').append('b').length());// 2
		System.out.println(s1.codePointCount(0, s1.length()));// 2
		// Unicode增补字符测试：
		StringBuffer s2 = new StringBuffer();
		System.out.println(s2.append('\ud800').append('\udc00').length());// 2
		System.out.println(s2.codePointCount(0, s2.length()));// 1

		StringBuffer s3 = new StringBuffer();
		int n = Integer.MIN_VALUE;
		System.out.println("字符串：" + s3.append(n) + ";长度：" + s3.length());// 字符串：-2147483648;长度：11
		StringBuffer s4 = new StringBuffer();
		int n1 = 123;
		System.out.println("字符串：" + s4.append(n1) + ";长度：" + s4.length());// 字符串：123;长度：3

		StringBuffer sb = new StringBuffer("12345");
		String s5 = null;
		System.out.println("字符串：" + sb.insert(3, s5));// 字符串：123null45
	}
}
