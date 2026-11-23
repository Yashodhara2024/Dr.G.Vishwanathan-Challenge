 Leetcode Problem 316 : Remove Duplicate Letters
Given a string s, remove duplicate letters so that every letter appears once and only once. The relative order of the letters that were not removed must be preserved. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Code:
public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] visited = new boolean[26];
    class Solution {
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        char[] stack = new char[26];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (visited[idx]) {
                continue;
            }
            while (top >= 0 && stack[top] > c &&
                   last[stack[top] - 'a'] > i) {
                visited[stack[top] - 'a'] = false;
                top--;
            }
            stack[++top] = c;
            visited[idx] = true;
        }
        return new String(stack, 0, top + 1);
    }
}
