package Question11_2;

import java.util.Arrays;
import java.util.Comparator;

import CtCILibrary.AssortedMethods;

public class QuestionComparator {

	public static void main(String[] args) {
		String[] array = { "apple", "banana", "carrot", "ele", "duck", "papel",
				"tarroc", "cudk", "eel", "lee" };
		System.out.println(AssortedMethods.stringArrayToString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(AssortedMethods.stringArrayToString(array));
	}
}

class AnagramComparator implements Comparator<String> {
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
