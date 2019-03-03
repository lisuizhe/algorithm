package Q0125_Valid_Palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= '0' && c <= '9')
                && !(c >= 'a' && c <= 'z')
                && !(c >= 'A' && c <= 'Z')) {
                continue;
            } else if (c >= 'A' && c <= 'Z') {
                c = (char)(c - 'A' + 'a');
            }
            sb.append(c);
        }
        String target = sb.toString();
        if (target.length() == 0) {
            return true;
        }
        int left = 0;
        int right = target.length() - 1;
        while(left <= right) {
            if (target.charAt(left) != target.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama") == true);
        System.out.println(s.isPalindrome("race a car") == false);
    }
}