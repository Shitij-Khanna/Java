package com.practice.java;

public class LeapGame {

	public static void main(String[] args) {
		
		int leap = 5;
		int size = 10;
		int maxCount = 6;
		int[] array = { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1};
		boolean canWin = determinePossibility(leap, size, maxCount, array);
		System.out.println("Can win : " + canWin);
	}

	public static boolean determinePossibility(int leap, int size, int maxCount, int[] array) {
		int index = 0;
		int destination = array.length - 1;
		int counter = 0;
		int pointer = 0;
		boolean canWin = false;
		while (counter < maxCount) {
			pointer = index + 1;
			if (array[pointer] == 0) {
				index = pointer;
			} else {
				pointer = index + leap;
				if(pointer > destination) {
					canWin = true;
					return canWin;
				}else {
					if (array[pointer] == 0) {
						index = pointer;
					} else {
						return canWin;
					}
				}
			}
			if (index == destination || index > destination) {
				canWin = true;
				return canWin;
			}
			counter++;
		}
		return canWin;
	}
}
