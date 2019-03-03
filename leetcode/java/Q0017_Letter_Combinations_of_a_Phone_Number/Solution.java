package Q0017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            char[] chars = digitToChars(digit);
            List<String> previousResults = results;
            results = new ArrayList<>();
            for (char c: chars) {
                if (previousResults.isEmpty()) {
                    results.add(String.valueOf(c));
                } else {
                    for (String result: previousResults) {
                        results.add(result + c);
                    }
                }                
            }
        }
        return results;
    }

    private char[] digitToChars(char digit) {
        switch (digit) {
            case '2':
                return new char[] {'a', 'b', 'c'};
            case '3':
                return new char[] {'d', 'e', 'f'};
            case '4':
                return new char[] {'g', 'h', 'i'};
            case '5':
                return new char[] {'j', 'k', 'l'};
            case '6':
                return new char[] {'m', 'n', 'o'};
            case '7':
                return new char[] {'p', 'q', 'r', 's'};
            case '8':
                return new char[] {'t', 'u', 'v'};
            case '9':
                return new char[] {'w', 'x', 'y', 'z'};
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}