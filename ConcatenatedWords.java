import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		Trie dict = new Trie();
		List<String> results = new ArrayList<>();

		for (String word : words) {
			dict.insert(word);
		}

		for (String word : words) {
			if (isCancat(word, dict, 0)) {
				results.add(word);
			}
		}

		return results;
	}

	private boolean isCancat(String word, Trie dict, int st) {

		for (int i = st + 1; i < word.length(); i++) {
			String firstPart = word.substring(st, i);
			if (dict.searchCompleteWord(firstPart)) {
				boolean next = helper(word, dict, i);
				if (next) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean helper(String word, Trie dict, int st) {
		if (st >= word.length()) {
			return true;
		}

		for (int i = st + 1; i <= word.length(); i++) {
			String firstPart = word.substring(st, i);
			if (dict.searchCompleteWord(firstPart)) {
				boolean next = helper(word, dict, i);
				if (next) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String args[]) {
		ConcatenatedWords obj = new ConcatenatedWords();
		String[] words = { "concat", "cat", "co", "n" };
		List<String> res = obj.findAllConcatenatedWordsInADict(words);

		for (String str : res) {
			System.out.println(str);
		}
	}
}
