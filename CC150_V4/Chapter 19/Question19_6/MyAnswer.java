package Question19_6;

import CareerCupLibrary.AssortedMethods;

public class MyAnswer {

	private static String[] arr1 = { "Zero ", "One ", "Two ", "Three ",
			"Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine " };

	private static String[] arr11 = { "Ten ", "Eleven ", "Twelve ",
			"Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ",
			"Eighteen ", "Nineteen " };

	private static String[] arr10 = { "", "Ten ", "Twenty ", "Thirty ",
			"Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " };

	public static String numtostring(int num) {
		int part1 = num / 1000;
		int part2 = num % 1000;
		if (part1 == 0) {
			return numBelowTrousand(part2);
		} else {
			return numBelowTrousand(part1) + "Thousand, "
					+ numBelowTrousand(part2);
		}
	}

	public static String numBelowTrousand(int num) {
		StringBuilder sb = new StringBuilder();
		// assume num is below 1000

		// first, convert hundred digit
		int hundred = num / 100;
		if (hundred != 0) {
			sb.append(arr1[hundred] + "Hundred ");
		}

		// second, convert the rest of digits
		num %= 100;
		if (num != 0) {
			int ten = num / 10;
			int one = num % 10;
			if (ten == 1) {
				sb.append(arr11[num - 10]);
			} else {
				if (ten != 0) {
					// ten is in the range of [2,9]
					sb.append(arr10[ten]);
				}
				if (one != 0) {
					sb.append(arr1[one]);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			int value = AssortedMethods.randomIntInRange(0, 1000);
			String s = numtostring(value);
			System.out.println(value + ": " + s);
		}
		for (int i = 0; i < 4; i++) {
			int value = AssortedMethods.randomIntInRange(5000, 999000);
			String s = numtostring(value);
			System.out.println(value / 1000 + "," + value % 1000 + ": " + s);
		}
	}
}
