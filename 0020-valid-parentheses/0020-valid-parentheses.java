class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            }
            else if (s.charAt(i) == '{') {
                stack.push('}');
            }
            else if (s.charAt(i) == '[') {
                stack.push(']');
            }
            else {
                char top = stack.isEmpty() ? '1' : stack.pop();

                if (top != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}