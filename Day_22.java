LeetCode Problem 241 – Different Ways to Add Parentheses
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

Example 1:
Input: expression = "2-1-1"
Output: [0,2]

Code:
lass Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for(int a : left) {
                    for(int b : right) {
                        if(ch == '+') {
                            ans.add(a + b);
                        }
                        else if(ch == '-') {
                            ans.add(a - b);
                        }
                        else {
                            ans.add(a * b);
                        }
                    }
                }
            }
        }
        if(ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}
