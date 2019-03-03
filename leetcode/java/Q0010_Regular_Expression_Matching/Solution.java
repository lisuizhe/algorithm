package Q0010_Regular_Expression_Matching;

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length()+1][p.length()+1];
        return dp(s, p, 0, 0, memo);
    }

    private boolean dp(String s, String p, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j] > 0;
        }
        boolean ans;
        if (j == p.length()) {
            ans =  i == s.length();
        } else {
            boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if ((j+1 < p.length()) && (p.charAt(j+1) == '*')) {
                ans = dp(s, p, i, j+2, memo) || (firstMatch && dp(s, p, i+1, j, memo));
            } else {
                ans = firstMatch && dp(s, p, i+1, j+1, memo);
            }
        } 
        memo[i][j] = ans ? 1 : -1;
        return ans;
    }
}