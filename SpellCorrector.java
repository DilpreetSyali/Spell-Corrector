import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SpellCorrector {
    private final Trie dictionary;
    private static final int MAX_CANDIDATES = 100; // Limit the number of candidates

    public SpellCorrector(Trie dictionary) {
        this.dictionary = dictionary;
    }

    public String correct(String word) {
        if (dictionary.search(word)) {
            return word; // Return the word if it is already in the dictionary
        }

        Set<String> candidates = new TreeSet<>();
        candidates.addAll(edits1(word));
        candidates.addAll(edits2(word));

        // Find the best match from candidates
        String bestMatch = null;
        int minDistance = Integer.MAX_VALUE;

        for (String candidate : candidates) {
            if (dictionary.search(candidate)) {
                int distance = editDistance(word, candidate);
                if (distance < minDistance) {
                    bestMatch = candidate;
                    minDistance = distance;
                }
            }
        }

        return bestMatch != null ? bestMatch : word; // Return the closest match or the original word
    }

    private Set<String> edits1(String word) {
        Set<String> edits = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            edits.add(word.substring(0, i) + word.substring(i + 1)); // Deletion
        }
        for (int i = 0; i < word.length() - 1; i++) {
            edits.add(word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2)); // Transposition
        }
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                edits.add(word.substring(0, i) + c + word.substring(i + 1)); // Alteration
            }
        }
        for (int i = 0; i <= word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                edits.add(word.substring(0, i) + c + word.substring(i)); // Insertion
            }
        }
        return edits;
    }

    private Set<String> edits2(String word) {
        Set<String> edits = new HashSet<>();
        for (String edit1 : edits1(word)) {
            edits.addAll(edits1(edit1));
            if (edits.size() > MAX_CANDIDATES) {
                break; // Stop if the limit is reached
            }
        }
        return edits;
    }

    private int editDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[len1][len2];
    }
}
