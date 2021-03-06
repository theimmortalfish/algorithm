package algo.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LexicographicOrderFromDictionary {

	public static void main(String[] args) {
		LexicographicOrderFromDictionary ins = new LexicographicOrderFromDictionary();

		String[] input = new String[] { "abc", "acd", "bcc", "bed", "bdc",
				"dab" };
		System.out.println("Lexico Order is ");
		System.out.println(ins.lexicoOrder(input));
	}

	public String lexicoOrder(String[] dict) {
		String ans = "";

		// for each pair, maintain 2 HashMap
		HashMap<Character, Integer> incount = new HashMap<Character, Integer>();
		HashMap<Character, List<Character>> connection = new HashMap<Character, List<Character>>();
		for (String str : dict) {
			for (char c : str.toCharArray()) {
				incount.put(c, 0);
				connection.put(c, new ArrayList<Character>());
			}
		}
		buildGraph(dict, incount, connection);

		// start topology sorting
		Queue<Character> temp = new LinkedList<Character>();
		for (char c : incount.keySet()) {
			if (incount.get(c) == 0) {
				temp.offer(c);
				incount.remove(c);
				// remove any node whose incount is 0
			}
		}
		while (!temp.isEmpty()) {
			char top = temp.poll();
			ans += top;
			// 'top' is next char in line. remove it and delete connections
			List<Character> inNodes = connection.get(top);
			for (char c : inNodes) {
				// remove incount for all nodes from inNodes
				incount.put(c, incount.get(c) - 1);
				if (incount.get(c) == 0) {
					incount.remove(c);
					temp.offer(c);
				}
			}
		}
		if (incount.size() == 0)
			return ans;
		else
			return "unable to find a valid char sequence.";
	}

	public void buildGraph(String[] dict, HashMap<Character, Integer> incount,
			HashMap<Character, List<Character>> connection) {
		// build the graph map
		// abc
		// acd
		// bcc
		// bed
		// bdc
		// dab
		for (int i = 0; i < dict.length - 1; i++) {
			// compare dict[i] and dict[i+1]
			String str1 = dict[i];
			String str2 = dict[i + 1];
			int p = 0;
			while (p < str1.length() && p < str2.length()) {
				if (str1.charAt(p) == str2.charAt(p)) {
					p++;
				} else {
					break;
				}
			}
			if (p == str1.length()) {
				// this is special case eg. "ab" & "abc"
				// this will not give up any information about lexico order
				continue;
			}
			char from = str1.charAt(p);
			char to = str2.charAt(p);
			// update incount
			incount.put(to, incount.get(to) + 1);
			// update connection
			connection.get(from).add(to);
		}
	}
}
