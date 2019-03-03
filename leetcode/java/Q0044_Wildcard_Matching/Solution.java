package Q0044_Wildcard_Matching;

class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, matchIndex = 0, asteriskIndex = -1;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                asteriskIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (asteriskIndex != -1) {
                pIndex = asteriskIndex + 1;
                sIndex = matchIndex++;
            } else {
                return false;
            }
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }

    public boolean isMatchByRecursive(String s, String p) {
        if (p.length() == 0) {
            return recursiveMatch(s, p);
        } else {
            StringBuilder sb = new StringBuilder();
            char prev = p.charAt(0);
            sb.append(prev);
            for (int i = 1; i < p.length(); i++) {
                char current = p.charAt(i);
                if (prev == '*' && current == '*') {
                    continue;
                }
                sb.append(current);
                prev = current;
            }
            return recursiveMatch(s, sb.toString());
        } 
    }

    private boolean recursiveMatch(String s, String p) {   
        if (s.length() == 0) {
            if (p.length() == 0){
                return true;
            } else if (p.charAt(0) == '*') {
                return recursiveMatch(s, p.substring(1));
            } else {
                return false;
            }
        }
        if (p.length() == 0) {
            return false;
        }
        char sFirst = s.charAt(0);
        char pFirst = p.charAt(0);
        if (sFirst == pFirst || pFirst == '?') {
            return recursiveMatch(s.substring(1), p.substring(1));
        }
        if (pFirst == '*') {
            return recursiveMatch(s.substring(1), p.substring(1)) 
                || recursiveMatch(s, p.substring(1)) 
                || recursiveMatch(s.substring(1), p);
        }
        return false;
    }
}