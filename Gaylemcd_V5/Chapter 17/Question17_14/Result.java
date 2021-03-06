package Question17_14;

import java.util.Hashtable;

import CtCILibrary.Trie;

public class Result {

	public int invalid = Integer.MAX_VALUE;
	public String parsed = "";

	public Result(int inv, String p) {
		invalid = inv;
		parsed = p;
	}

	public Result clone() {
		return new Result(this.invalid, this.parsed);
	}

	public static Result min(Result r1, Result r2) {
		if (r1 == null) {
			return r2;
		} else if (r2 == null) {
			return r1;
		}

		return r2.invalid < r1.invalid ? r2 : r1;
	}

	/* incomplete code */
	public static Result parse(String sentence, Trie dictionary, int wordStart,
			int wordEnd, Hashtable<Integer, Result> cache) {
		if (wordEnd >= sentence.length()) {
			return new Result(wordEnd - wordStart, sentence
					.substring(wordStart).toUpperCase());
		}
		if (cache.containsKey(wordStart)) {
			return cache.get(wordStart).clone();
		}
		String currentWord = sentence.substring(wordStart, wordEnd + 1);
		boolean validPartial = dictionary.contains(currentWord, false);
		boolean validExact = validPartial
				&& dictionary.contains(currentWord, true);

		/* break current word */
		Result bestExact = parse(sentence, dictionary, wordEnd + 1,
				wordEnd + 1, cache);
		if (validExact) {
			bestExact.parsed = currentWord + " " + bestExact.parsed;
		} else {
			bestExact.invalid += currentWord.length();
			bestExact.parsed = currentWord.toUpperCase() + " "
					+ bestExact.parsed;
		}

		/* extend current word */
		Result bestExtend = null;
		if (validPartial) {
			bestExtend = parse(sentence, dictionary, wordStart, wordEnd + 1, cache);
		}

		/* find best */
		Result best = Result.min(bestExact, bestExtend);
		cache.put(wordStart, best.clone());
		return best;
	}
}
