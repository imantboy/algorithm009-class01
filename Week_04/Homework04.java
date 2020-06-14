import javafx.util.Pair;

import java.util.*;

public class Homework04 {

    /**
     * 860. 柠檬水找零
     * https://leetcode-cn.com/problems/lemonade-change/
     */
    class LemonadeChangeSolution {

        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;

            for (int bill : bills) {
                if (5 == bill) {
                    five++;
                } else if (10 == bill) {
                    ten++;
                    five--;
                } else {
                  if (ten > 0) {
                      ten--;
                      five--;
                  } else {
                      five -= 3;
                  }
                }

                if (five < 0) {
                    return  false;
                }
            }

            return  true;
        }
    }

    /**
     * 127. 单词接龙
     * https://leetcode-cn.com/problems/word-ladder/description/
     */
    class WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int length = beginWord.length();
            Map<String, List<String>> allComboDict = new HashMap<>();

            for (String word : wordList) {
                for (int i = 0; i < length; i++) {
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                    List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                    transformations.add(word);
                    allComboDict.put(newWord, transformations);
                }
            }
            Queue<Pair<String, Integer>> Q = new LinkedList<>();
            Q.add(new Pair(beginWord, 1));


            Map<String, Boolean> visited = new HashMap<>();
            visited.put(beginWord, true);

            while (!Q.isEmpty()) {
                Pair<String, Integer> node = Q.remove();
                String word = node.getKey();
                int level = node.getValue();
                for (int i = 0; i < length; i++) {

                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);

                    for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            Q.add(new Pair(adjacentWord, level + 1));
                        }
                    }
                }
            }
            return 0;
        }
    }

}
