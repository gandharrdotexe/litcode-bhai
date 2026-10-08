class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    res.append(ch);   // not the outermost '('
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    res.append(ch);   // not the outermost ')'
                }
            }
        }
        return res.toString();
    }
}