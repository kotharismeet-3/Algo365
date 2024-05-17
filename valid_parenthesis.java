class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            // closing
            char c = s.charAt(i);
            if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if(c == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }
            else if(c == ']') {
                if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else  return false;
            }
            else stack.push(c);
        }
        return stack.size() == 0;
    }
}