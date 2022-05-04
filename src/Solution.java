import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static long solveIssueOne(List<String> input) {
        long score = 0;
        if (null == input) return score;
        if (input.isEmpty()) return score;
        for (String s : input) {
            List<Character> list = new ArrayList<>();
            boolean exitLoop = false;
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    list.add(c);
                } else {
                    Character lastElement = list.remove(list.size() - 1);
                    if (c == ')' && lastElement != '(') {
                        score += 3;
                        exitLoop = true;
                    } else if (c == ']' && lastElement != '[') {
                        score += 57;
                        exitLoop = true;
                    } else if (c == '}' && lastElement != '{') {
                        score += 1197;
                        exitLoop = true;
                    } else if (c == '>' && lastElement != '<') {
                        score += 25137;
                        exitLoop = true;
                    }
                }
                if (exitLoop) break;
            }
        }
        return score;
    }

    public static long solveIssueTwo(List<String> input) {
        ArrayList<Long> scores = new ArrayList<>();
        if (null == input) return 0;
        if (input.isEmpty()) return 0;
        for (int i = input.size() - 1; i >= 0; i--) {
            String s = input.get(i);
            List<Character> list = new ArrayList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    list.add(c);
                } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                    list.remove(list.size() - 1);
                }
            }
            long score = 0;
            while (list.size() > 0) {
                char c = list.remove(list.size() - 1);
                score *= 5;
                switch (c) {
                    case '(':
                        score += 1;
                        break;
                    case '[':
                        score += 2;
                        break;
                    case '{':
                        score += 3;
                        break;
                    case '<':
                        score += 4;
                        break;
                }
            }
            scores.add(score);
        }
        scores.sort(Long::compareTo);
        return scores.get(scores.size() / 2);
    }
}
