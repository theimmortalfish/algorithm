package common;

import java.util.List;

public class Common {

	public static void printArray(int[] array) {
		if (array == null || array.length == 0) {
			System.out.println("The array you input is null/empty. ");
		}
		System.out.println("Print the array: ");
		System.out.print("{");
		StringBuilder sb = new StringBuilder();
		for (int i : array) {
			sb.append(", " + i);
		}
		System.out.println(sb.toString().substring(2) + "}");
	}

	public static void printList(List<?> list) {
		System.out.println("Print the list: ");
		for (Object obj : list) {
			System.out.println(obj.toString());
		}
	}

	public static boolean compareArray(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean compareMatrix(int[][] a, int[][] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!compareArray(a[i], b[i])) {
				return false;
			}
		}
		return true;
	}
}