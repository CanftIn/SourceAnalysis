package com.canftin;

import java.util.stream.IntStream;

public class CharSequenceTest {

    public static void main(String[] args) {
	    CharSequence name1cs = "this2121";
	    CharSequence name2cs = "this";
		int b = CharSequence.compare(name1cs, name2cs);
		System.out.println(b);
	    IntStream intStream = name1cs.chars();
	    String string = intStream
			    .collect(StringBuilder::new,
					    StringBuilder::appendCodePoint,
					    StringBuilder::append)
			    .toString();
	    System.out.println(string);
	    IntStream intStream2 = name2cs.codePoints();
	    String string2 = intStream2
			    .collect(StringBuilder::new,
					    StringBuilder::appendCodePoint,
					    StringBuilder::append)
			    .toString();
	    System.out.println(string2);
    }
}
