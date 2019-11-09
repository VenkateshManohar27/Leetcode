package com.vm.practice;

public class StackOverflow {
	public void test() {
		StringBuilder sb = new StringBuilder();
		sb.append("E:\\path\\to\\logDirA\\A.log to E:\\path\\to\\logDirB\\B.log");
		// Building StringBuilder

		String string = sb.substring(0, (sb.indexOf(".log")) + 4);
		sb.setLength(0);
		sb.append(string);

		System.out.println(sb);

	}
	public static void main(String[] args) {
		StackOverflow so = new StackOverflow();
		so.test();
	}
}
