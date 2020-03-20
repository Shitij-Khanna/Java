package com.practice.java;

public class Palindrome {

	public static void main(String[] args) {
		String s = "shittihs";
		int length = s.length();
		boolean isPalindrome = true;
		for (int i = 0, j = length - 1; i <= length / 2; i++, j--) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (a != b) {
				isPalindrome = false;
			}
		}
		System.out.println(isPalindrome);
	}

}
